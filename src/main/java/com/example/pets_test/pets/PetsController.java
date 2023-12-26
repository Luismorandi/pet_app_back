/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.example.pets_test.pets;

import com.example.pets_test.pets.repository.jpa.Pets_entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/pets")
public class PetsController {

    private final PetsService petsServices;

            @Autowired
            public PetsController(PetsService petsServices){
        this.petsServices= petsServices;
            }

            @GetMapping
    public List<Pets_entity> getPets(){
        return petsServices.getPets();
            }

    @PostMapping()
    public Pets_entity createPet(@RequestBody PetsDTO body) {
        return petsServices.createPet(body);
    }

    @PutMapping(path = "/id/{id}")
    public Pets_entity updatePet(@RequestBody PetsDTO body, @PathVariable UUID id ) {
        return petsServices.updatePet(id, body);
    }

    @DeleteMapping(path = "/id/{id}")
    public Pets_entity deletePet(@PathVariable UUID id ) {
        return petsServices.deletePet(id);
    }

}
