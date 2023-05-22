package com.example.demo.model.rule;

import org.springframework.stereotype.Component;

import com.example.demo.model.Receipt;

@Component
public class EveryTwoItemsRule implements Rule {

    @Override
    public int processRule(Receipt receipt) {
        int numItems = receipt.getItems().size();

        return (numItems / 2) * 5;
    }
    
}
