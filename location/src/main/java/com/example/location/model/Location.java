package com.example.location.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
public class Location {
    @Id
    @GeneratedValue
    private int id;
    @NonNull
    private String name;
    @NonNull
    private Double lat;
    @NonNull
    private Double lon;

    public Location(){
    }
    public Location(@NonNull String name, @NonNull Double lat, @NonNull Double lon){
        this.name = name;
        this.lat = lat;
        this.lon = lon;
    }

    public Location(int id, @NonNull String name, @NonNull Double lat, @NonNull Double lon) {
        this.id = id;
        this.name = name;
        this.lat = lat;
        this.lon = lon;
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

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }
}
