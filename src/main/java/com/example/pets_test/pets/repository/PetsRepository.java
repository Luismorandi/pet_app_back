/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.example.pets_test.pets.repository;

import com.example.pets_test.pets.PetsDTO;

import com.example.pets_test.pets.repository.jpa.Pets_jpa;
import com.example.pets_test.pets.repository.jpa.Pets_entity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.*;

@Component
public class PetsRepository implements PetsRepositoryInterface {

    private final Pets_jpa petsRepository;

    @Autowired
    public PetsRepository(@Qualifier("pets") Pets_jpa petsRepository){
        this.petsRepository= petsRepository;
    }


    public List<Pets_entity> getPets() {
        return this.petsRepository.findAll();
    }

    public Pets_entity createPet(PetsDTO body) {
        return this.petsRepository.save(new Pets_entity(
                UUID.randomUUID(),
                body.getName(),
                body.getGenre(),
                body.getAge(),
                body.getBreed(),
                body.getOwnerId(),
                body.getAddress(),
                body.getType(),
                body.getDescription(),
                body.getImageUrl(),
                LocalDateTime.now(),
                LocalDateTime.now()
        ));
    }

    public Pets_entity updatePet(UUID id, PetsDTO body) {
        Optional<Pets_entity> existingPet = this.petsRepository.findById(id);

        if (existingPet.isPresent()) {
            Pets_entity petToUpdate = existingPet.get();

            Map<String, Object> updatedProperties = getNonNullPropertyValues(body);

            updatedProperties.forEach((property, value) -> {
                try {
                    Field field = Pets_entity.class.getDeclaredField(property);
                    field.setAccessible(true);

                    if (value != null) {
                        field.set(petToUpdate, value);
                    }
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    throw new EntityNotFoundException("this property dont exist");
                }
            });

            return petsRepository.save(petToUpdate);
        } else {
            throw new EntityNotFoundException("I cant update this pet with id " + id);
        }
    }

    public Pets_entity deletePet(UUID id) {
        Optional<Pets_entity> existingPet = this.petsRepository.findById(id);

        if (existingPet.isPresent()) {
            Pets_entity petToDelete = existingPet.get();
            this.petsRepository.deleteById(id);
            return petToDelete;
        } else {
            throw new EntityNotFoundException("I cant delete this pet with id " + id);
        }
    }

    private Map<String, Object> getNonNullPropertyValues(PetsDTO body) {

        Map<String, Object> propertyValues = new HashMap<>();

        for (Field field : body.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                Object value = field.get(body);
                if (value != null) {
                    propertyValues.put(field.getName(), value);
                }
            } catch (IllegalAccessException e) {
                throw new EntityNotFoundException("This property dont exist");

            }
        }

        return propertyValues;
    }


}