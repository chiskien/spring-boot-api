package com.example.springbootapi.controllers;

import com.example.springbootapi.models.Payment;
import com.example.springbootapi.services.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@RestController
public class PaymentController {
    private static final Logger logger = Logger
            .getLogger(PaymentController.class.getName());
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment")
    public ResponseEntity<Payment> createPayment(@RequestHeader String requestId,
                                                 @RequestBody Payment payment) {
        logger.info("Received request with ID: " + requestId +
                "; Payment amount: " + payment.getAmount());
        payment.setId(UUID.randomUUID().toString());
        paymentService.createPayment(payment);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .header("request Id", requestId)
                .body(payment);
    }

    @GetMapping("/payment")
    public ResponseEntity<List<Payment>> getAll() {
        logger.info("List all payments at: " + LocalDate.now());
        return ResponseEntity.status(HttpStatus.OK)
                .body(paymentService.getAll());
    }
}
