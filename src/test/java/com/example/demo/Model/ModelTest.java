package com.example.demo.Model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.example.demo.model.Item;
import com.example.demo.model.Receipt;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ModelTest {
    private ObjectMapper mapper;

    @Before
    public void setUp() {
        mapper = new ObjectMapper();
    } 
    
    @Test
    public void itemTest() {
        Item testItem = null;
        String jsonString = "{\"shortDescription\": \"Pepsi - 12-oz\", \"price\": \"1.25\"}";

        try {
            testItem = mapper.readValue(jsonString, Item.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            Assert.fail();
        }

        assertNotNull(testItem);
        assertEquals("Pepsi - 12-oz", testItem.getShortDescription());
        assertEquals(1.25, testItem.getPrice(), 0);

    }

    @Test
    public void receiptTest() {
        Receipt testReceipt = null;
        String jsonString = "{ \"retailer\": \"Target\", \"purchaseDate\": \"2022-01-02\", \"purchaseTime\": \"13:13\", \"total\": \"1.25\", \"items\": [ {\"shortDescription\": \"Pepsi - 12-oz\", \"price\": \"1.25\"} ] }";
        try {
            testReceipt = mapper.readValue(jsonString, Receipt.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            System.out.println(e.getLocalizedMessage());
            Assert.fail();
        }

        assertNotNull(testReceipt);
        assertEquals("Target", testReceipt.getRetailer());
        assertEquals(LocalDate.parse("2022-01-02"), testReceipt.getPurchaseDate());
        assertEquals(LocalTime.parse("13:13"), testReceipt.getPurchaseTime());
        assertEquals(1.25, testReceipt.getTotal(), 0);

        assertNotNull(testReceipt.getItems());
        assertEquals(1, testReceipt.getItems().size());

        Item testItem = testReceipt.getItems().get(0);
        assertNotNull(testItem);
        assertEquals("Pepsi - 12-oz", testItem.getShortDescription());
        assertEquals(1.25, testItem.getPrice(), 0);
    }
}
