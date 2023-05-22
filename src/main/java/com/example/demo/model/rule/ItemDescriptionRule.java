package com.example.demo.model.rule;

import org.springframework.stereotype.Component;

import com.example.demo.model.Item;
import com.example.demo.model.Receipt;

@Component
public class ItemDescriptionRule implements Rule {

    @Override
    public int processRule(Receipt receipt) {
        int points = 0;

        for(Item item : receipt.getItems()) {
            String itemDescription = item.getShortDescription().trim();
            
            if( itemDescription.length() % 3 == 0) {
                points += Math.ceil(item.getPrice() * 0.2);
            }
        }
        
        return points;
    }

    
}
