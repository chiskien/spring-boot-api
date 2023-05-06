package com.example.springbootapi.repositories;

import com.example.springbootapi.models.Payment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository {
    List<Payment> getAll();

    Payment getById(String id);

    void createPayment(Payment payment);
}
