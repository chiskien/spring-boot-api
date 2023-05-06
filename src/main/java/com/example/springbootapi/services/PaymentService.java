package com.example.springbootapi.services;

import com.example.springbootapi.exceptions.NotEnoughMoneyException;
import com.example.springbootapi.models.Payment;
import com.example.springbootapi.models.PaymentDetail;
import com.example.springbootapi.repositories.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PaymentService implements PaymentRepository {
    private final List<Payment> payments = new ArrayList<>();
    public PaymentDetail processPayment() {
        throw new NotEnoughMoneyException();
    }

    public PaymentService() {
        payments.add(new Payment(UUID.randomUUID().toString(), 10));
        payments.add(new Payment(UUID.randomUUID().toString(), 20));
    }

    @Override
    public List<Payment> getAll() {
        return payments;
    }

    @Override
    public Payment getById(String id) {
        return null;
    }

    @Override
    public void createPayment(Payment payment) {
        payments.add(payment);
    }

}
