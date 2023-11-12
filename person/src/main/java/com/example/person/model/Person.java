package com.example.person.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
public class Person {
    @Id
    @GeneratedValue
    private int id;
    @NonNull
    private String name;
    @NonNull
    private String location;



    public Person() {
    }

    public Person(@NonNull String name, @NonNull String location) {
        this.name = name;
        this.location = location;
    }

    public Person(int id, @NonNull String name, @NonNull String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}