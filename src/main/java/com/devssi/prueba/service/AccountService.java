package com.devssi.prueba.service;

import com.devssi.prueba.dto.AccountDTO;
import com.devssi.prueba.dto.AccountsDTO;
import com.devssi.prueba.dto.TransactionDTO;
import com.devssi.prueba.dto.TransactionsDTO;
import com.devssi.prueba.model.Account;
import com.devssi.prueba.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    AccountRepository repository;

    public AccountsDTO getAllAccounts() {
        AccountsDTO accountsDTO = new AccountsDTO();
        for (Account account : repository.findAll()) {
            accountsDTO.getAccounts()
                    .add(
                            new AccountDTO(account.getId(),
                                    account.getLastBalance().getAmount(),
                                    account.getClient().getNumber(),
                                    account.getCreatedAt())
                    );
        }
        return accountsDTO;
    }

    public Optional<Account> getAccountById(Long id) {
        return repository.findById(id);
    }

    public TransactionsDTO getReceivedTransactions(Long accountId) {
        Optional<Account> account = repository.findById(accountId);
        TransactionsDTO transactionsDTO = new TransactionsDTO();
        if (account.isPresent()) {
            account.get().getReceivedTransactionHistory().forEach(
                    transaction -> {
                        TransactionDTO transactionDTO = new TransactionDTO();
                        transactionDTO.setFromAccount(transaction.getFromAccount().getId());
                        transactionDTO.setToAccount(transaction.getToAccount().getId());
                        transactionDTO.setSentAt(transaction.getCreatedAt());
                        transactionDTO.setAmount(transaction.getAmount());
                        transactionsDTO.getTransactions().add(transactionDTO);
                    }
            );
        }
        return transactionsDTO;
    }

    public TransactionsDTO getSentTransactions(Long accountId) {
        Optional<Account> account = repository.findById(accountId);
        TransactionsDTO transactionsDTO = new TransactionsDTO();
        if (account.isPresent()) {
            account.get().getSentTransactionHistory().forEach(
                    transaction -> {
                        TransactionDTO transactionDTO = new TransactionDTO();
                        transactionDTO.setFromAccount(transaction.getFromAccount().getId());
                        transactionDTO.setToAccount(transaction.getToAccount().getId());
                        transactionDTO.setSentAt(transaction.getCreatedAt());
                        transactionDTO.setAmount(transaction.getAmount());
                        transactionsDTO.getTransactions().add(transactionDTO);
                    }
            );
        }
        return transactionsDTO;
    }
}
