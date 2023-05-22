package com.example.demo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.Receipt;
import com.example.demo.repositories.ReceiptRepository;

@Service
public class ReceiptService {

    private final ReceiptRepository receiptRepository;

    public ReceiptService(ReceiptRepository receiptRepository) {
        this.receiptRepository = receiptRepository;
    }

    public Receipt add(Receipt receipt) {
        return receiptRepository.save(receipt);
    }

    public Receipt getById(Long id) {
        Optional<Receipt> receiptOptional = receiptRepository.findById(id);

        if(receiptOptional.isPresent()) {
            return receiptOptional.get();
        }

        return null;
    }
    
}
