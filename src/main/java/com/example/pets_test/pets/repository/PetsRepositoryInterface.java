/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.example.pets_test.pets.repository;

import com.example.pets_test.pets.PetsDTO;
import com.example.pets_test.pets.repository.jpa.Pets_entity;

import java.util.List;
import java.util.UUID;

public interface PetsRepositoryInterface {

    List<Pets_entity> getPets();

    Pets_entity createPet(PetsDTO body);

    Pets_entity updatePet(UUID id, PetsDTO body);

    Pets_entity deletePet(UUID id);
}