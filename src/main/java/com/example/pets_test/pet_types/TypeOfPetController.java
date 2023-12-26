/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.example.pets_test.pet_types;

import com.example.pets_test.pet_types.repository.jpa.TypesOfPets_entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/types")
public class TypeOfPetController {

    private final TypeOfPetService typeOfPetService;

            @Autowired
            public TypeOfPetController(TypeOfPetService typeOfPetService){
        this.typeOfPetService= typeOfPetService;
            }

            @GetMapping
    public List<TypesOfPets_entity> getTypes(){
        return typeOfPetService.getTypes();
            }

    @PostMapping()
    public TypesOfPets_entity creteType(@RequestBody TypesOfPetsDTO body) {
        System.out.print(body);

        return typeOfPetService.createType(body);
    }



}
