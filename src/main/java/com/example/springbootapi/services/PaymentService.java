package com.example.springbootapi.services;

import com.example.springbootapi.exceptions.NotEnoughMoneyException;
import com.example.springbootapi.models.PaymentDetail;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    public PaymentDetail processPayment() {
        throw new NotEnoughMoneyException();
    }
}
