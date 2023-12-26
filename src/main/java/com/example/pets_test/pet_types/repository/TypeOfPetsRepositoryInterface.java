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

import java.util.List;
import java.util.UUID;

public interface TypeOfPetsRepositoryInterface {

    List<TypesOfPets_entity> getTypes();

    TypesOfPets_entity createType(TypesOfPetsDTO body);


    TypesOfPets_entity deleteType(UUID id);
}