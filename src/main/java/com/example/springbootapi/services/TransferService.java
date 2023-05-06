package com.example.springbootapi.services;

import com.example.springbootapi.models.Account;
import com.example.springbootapi.repositories.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransferService {

    private final AccountRepository accountRepository;

    public TransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public void transferMoney(long idSender, long idReceiver, BigDecimal amount) {
        Account sender = accountRepository.findAccountById(idSender);
        Account receiver = accountRepository.findAccountById(idReceiver);


        BigDecimal senderAmount = sender.getAmount().subtract(amount);
        BigDecimal receiverAmount = receiver.getAmount().add(amount);

        accountRepository.changeAmount(idSender, senderAmount);
        accountRepository.changeAmount(idReceiver, receiverAmount);
    }

    public List<Account> findAllAccounts() {
        return accountRepository.findAllAccounts();
    }
}
