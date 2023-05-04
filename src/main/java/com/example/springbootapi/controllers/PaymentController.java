package com.example.springbootapi.controllers;

import com.example.springbootapi.models.PaymentDetail;
import com.example.springbootapi.services.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.logging.Logger;

@Controller
public class PaymentController {
    private static final Logger logger = Logger
            .getLogger(PaymentController.class.getName());

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }


    @PostMapping("/payment")
    public ResponseEntity<?> makePayment(@RequestBody PaymentDetail paymentDetail) {
        logger.info("Received payment " + paymentDetail.getAmount());
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(paymentDetail);
    }

}
