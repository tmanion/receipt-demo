package com.example.demo.Model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.example.demo.model.Item;
import com.example.demo.model.Item;
import com.example.demo.model.ReceiptObj;
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
        assertEquals("Pepsi - 12-oz", testItem.shortDescription());
        assertEquals(1.25, testItem.price(), 0);
        assertNotNull(testItem.id());
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
        assertEquals("Target", testReceipt.retailer());
        assertEquals(LocalDate.parse("2022-01-02"), testReceipt.purchaseDate());
        assertEquals(LocalTime.parse("13:13"), testReceipt.purchaseTime());
        assertEquals(1.25, testReceipt.total(), 0);

        assertNotNull(testReceipt.items());
        assertEquals(1, testReceipt.items().size());
        
        Item testItem = testReceipt.items().get(0);
        assertNotNull(testItem);
        assertEquals("Pepsi - 12-oz", testItem.shortDescription());
        assertEquals(1.25, testItem.price(), 0);
    }
}
