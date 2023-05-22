package com.example.demo.service;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.Item;
import com.example.demo.model.Receipt;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RulesServiceTest {

    @Autowired
    private RuleService testRuleService;

    @Test
    public void twentyEightPointRecipt() {
        List<Item> testItems = new ArrayList<>();
        
        Item item1 = new Item("Mountain Dew 12PK", 6.49f);
        testItems.add(item1);

        Item item2 = new Item("Emils Cheese Pizza", 12.25f);
        testItems.add(item2);

        Item item3 = new Item("Knorr Creamy Chicken", 1.26f);
        testItems.add(item3);

        Item item4 = new Item("Doritos Nacho Cheese", 3.35f);
        testItems.add(item4);

        Item item5 = new Item("   Klarbrunn 12-PK 12 FL OZ  ", 12.00f);
        testItems.add(item5);

        Receipt testReceipt = new Receipt("Target", LocalDate.parse("2022-01-01"),
         LocalTime.parse("13:01:00"), 35.35f, testItems);

        int result = testRuleService.runRules(testReceipt);

        assertEquals(28, result);
    }

    @Test
    public void oneHundredEightPointReceipt() {
        List<Item> testItems = new ArrayList<>();
        
        Item item1 = new Item("Gatorade", 2.25f);

        for(int i = 0; i < 4; i++) {
            testItems.add(item1);
        }

        Receipt testReceipt = new Receipt("M&M Corner Market", LocalDate.parse("2022-03-20"),
         LocalTime.parse("14:33:00"), 9.00, testItems);

         int result = testRuleService.runRules(testReceipt);

         assertEquals(109, result);
    }
}
