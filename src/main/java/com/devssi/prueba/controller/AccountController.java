package com.devssi.prueba.controller;

import com.devssi.prueba.dto.AccountsDTO;
import com.devssi.prueba.dto.BalanceResponseDTO;
import com.devssi.prueba.dto.TransactionsDTO;
import com.devssi.prueba.service.AccountService;
import com.devssi.prueba.service.BalanceService;
import com.devssi.prueba.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    AccountService service;

    @Autowired
    TransactionService transactionService;

    @Autowired
    BalanceService balanceService;

    @GetMapping
    public AccountsDTO getAllAccounts() {
        return service.getAllAccounts();
    }

    @GetMapping("/{accountId}/transactions")
    public TransactionsDTO getAccountTransactions(@PathVariable Long accountId) {
        return transactionService.getAccountTransactions(accountId);
    }

    @GetMapping("/{accountId}/balance")
    public BalanceResponseDTO getBalanceForAccount(@PathVariable Long accountId) {
        return balanceService.getBalanceForAccount(accountId);
    }

    @GetMapping("/{accountId}/received-transactions")
    public TransactionsDTO getReceivedTransactions(@PathVariable Long accountId) {
        return service.getReceivedTransactions(accountId);
    }

}
