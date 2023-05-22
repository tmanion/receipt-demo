package com.example.demo.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;

public record Receipt(
    @JsonProperty("retailer") String retailer,
    @JsonProperty("purchaseDate") @JsonDeserialize(using = LocalDateDeserializer.class)  
    @JsonSerialize(using = LocalDateSerializer.class)  LocalDate purchaseDate,
    @JsonProperty("purchaseTime") @JsonDeserialize(using = LocalTimeDeserializer.class)  
    @JsonSerialize(using = LocalTimeSerializer.class) LocalTime purchaseTime,
    @JsonProperty("total") double total,
    @JsonProperty("items") List<Item> items,
    String id ) {

        public Receipt {
            id = UUID.randomUUID().toString();
        }

        public void addItem(Item item) {
            items.add(item);
        }
}
