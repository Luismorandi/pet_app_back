/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.example.pets_test.pet_types;

import com.example.pets_test.pet_types.repository.TypeOfPetsRepositoryInterface;
import com.example.pets_test.pet_types.repository.jpa.TypesOfPets_entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TypeOfPetService {

    private final TypeOfPetsRepositoryInterface typesOfPetRepository;

    @Autowired
    public TypeOfPetService(TypeOfPetsRepositoryInterface typesOfPetRepository){
        this.typesOfPetRepository =typesOfPetRepository;
    }

    public TypesOfPets_entity createType(TypesOfPetsDTO body) {
        System.out.print(body);
        return this.typesOfPetRepository.createType(body);
    }

    public List<TypesOfPets_entity> getTypes() {
        return this.typesOfPetRepository.getTypes();
    }


    public TypesOfPets_entity deletType(UUID id) {
        return this.typesOfPetRepository.deleteType(id);
    }



}