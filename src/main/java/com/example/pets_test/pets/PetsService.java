/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.example.pets_test.pets;

import com.example.pets_test.pets.repository.jpa.Pets_entity;
import com.example.pets_test.pets.repository.PetsRepositoryInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class PetsService {

    private final PetsRepositoryInterface petsRepository;

    @Autowired
    public PetsService(PetsRepositoryInterface petsRepository){
        this.petsRepository =petsRepository;
    }

    public Pets_entity createPet(PetsDTO body) {
        return this.petsRepository.createPet(body);
    }

    public List<Pets_entity> getPets() {
        return this.petsRepository.getPets();
    }

    public Pets_entity updatePet(UUID id, PetsDTO body) {
        LocalDateTime today = LocalDateTime.now();
        body.setUpdatedAt(today);
        return this.petsRepository.updatePet(id, body);
    }
    public Pets_entity deletePet(UUID id) {
        return this.petsRepository.deletePet(id);
    }



}