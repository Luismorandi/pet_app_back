
package com.example.pets_test.pets;
import java.time.LocalDateTime;
import java.util.UUID;

public class PetsDTO {

    private String name;
    private String genre;
    private Integer age;
    private String breed;
    private String ownerId;
    private String address;
    private String type;

    private String description;

    private LocalDateTime updatedAt;

    private String imageUrl;

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public PetsDTO(String name, String genre, Integer age, String breed, String ownerId, String address, String type, String description,String imageUrl) {
        this.name = name;
        this.genre = genre;
        this.age = age;
        this.breed = breed;
        this.ownerId = ownerId;
        this.address = address;
        this.type = type;
        this.description = description;
        this.imageUrl = imageUrl;

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
