
/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.example.pets_test.pet_types;
import java.time.LocalDateTime;
import java.util.UUID;

public class TypesOfPetsDTO {

    private String type;


    public TypesOfPetsDTO() {
    }
    public TypesOfPetsDTO(String type) {

        this.type = type;

    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }
}