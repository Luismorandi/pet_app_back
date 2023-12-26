/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.example.pets_test.pet_types.repository;

import com.example.pets_test.pet_types.TypesOfPetsDTO;
import com.example.pets_test.pet_types.repository.jpa.TypesOfPets_entity;
import com.example.pets_test.pet_types.repository.jpa.TypesOfPets_jpa;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.*;

@Component
public class TypesOfPetsRepository implements TypeOfPetsRepositoryInterface {

    private final TypesOfPets_jpa typesOfPetsRepository;

    @Autowired
    public TypesOfPetsRepository(@Qualifier("typeOfPets") TypesOfPets_jpa typesOfPetsRepository){
        this.typesOfPetsRepository= typesOfPetsRepository;
    }


    public List<TypesOfPets_entity> getTypes() {
        return this.typesOfPetsRepository.findAll();
    }

    public TypesOfPets_entity createType(TypesOfPetsDTO body) {
        return this.typesOfPetsRepository.save(new TypesOfPets_entity(
                UUID.randomUUID(),
                body.getType(),
                LocalDateTime.now(),
                LocalDateTime.now()
        ));
    }


    public TypesOfPets_entity deleteType(UUID id) {
        Optional<TypesOfPets_entity> existingType= this.typesOfPetsRepository.findById(id);

        if (existingType.isPresent()) {
            TypesOfPets_entity typeToDelete = existingType.get();
            this.typesOfPetsRepository.deleteById(id);
            return typeToDelete;
        } else {
            throw new EntityNotFoundException("I cant delete this pet with id " + id);
        }
    }

}