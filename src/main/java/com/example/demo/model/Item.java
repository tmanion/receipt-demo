package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Item {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("shortDescription")
    private String shortDescription;

    @JsonProperty("price")
    private float price;

    @ManyToOne
    private Receipt receipt;

    @JsonValue
    public String getShortDescription() {
        return shortDescription;
    }

    public Item() {
    }

    public Item(String shortDescription, float price) {
        this.shortDescription = shortDescription;
        this.price = price;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    @JsonValue
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }


}