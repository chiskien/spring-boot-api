package com.example.springbootapi.controllers;

import com.example.springbootapi.dto.TransferRequest;
import com.example.springbootapi.models.Account;
import com.example.springbootapi.services.TransferService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {
    private final TransferService transferService;

    public AccountController(TransferService transferService) {
        this.transferService = transferService;
    }

    @GetMapping("/account")
    public List<Account> getAllAccounts() {
        return transferService.findAllAccounts();
    }

    @PostMapping("/transfer")
    public ResponseEntity<String> transferMoney(@RequestBody TransferRequest transferRequest) {
        transferService.transferMoney(
                transferRequest.senderAccountId(),
                transferRequest.receiverAccountId(),
                transferRequest.amount());
        return ResponseEntity.ok("Transfer money successfully from: " + transferRequest.senderAccountId()
                + " to " + transferRequest.receiverAccountId() + " amount: " + transferRequest.amount());
    }
}
