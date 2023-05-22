package com.example.demo.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Item(@JsonProperty("shortDescription") String shortDescription,
@JsonProperty("price") float price, String id) {

    public Item {
        id = UUID.randomUUID().toString();
    }
    
}
