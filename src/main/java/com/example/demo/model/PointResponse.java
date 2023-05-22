package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PointResponse(@JsonProperty("points") int points) {

}
