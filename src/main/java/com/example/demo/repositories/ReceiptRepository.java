package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.example.demo.model.Receipt;

@Component
public interface ReceiptRepository extends CrudRepository<Receipt, Long> {
    
}
