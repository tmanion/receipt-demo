package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ProcessResponse(@JsonProperty("id") Long id) {
    
}
