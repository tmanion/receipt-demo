package com.example.demo.model.rule;

import org.springframework.stereotype.Component;

import com.example.demo.model.Receipt;

@Component
public class RoundDollarAmountRule implements Rule{
    public static Integer REWARD_POINTS = 50;

    @Override
    public int processRule(Receipt receipt) {
        double total = receipt.getTotal();

        if(total > 0.0 && Math.ceil(total) == Math.floor(total)) {
            return REWARD_POINTS.intValue();
        }

        return 0;
    }
    
}
