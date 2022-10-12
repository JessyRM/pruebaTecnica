package com.devssi.prueba.service;

import com.devssi.prueba.dto.TransactionDTO;
import com.devssi.prueba.dto.TransactionResultDTO;
import com.devssi.prueba.dto.TransactionsDTO;
import com.devssi.prueba.model.Account;
import com.devssi.prueba.model.Transaction;
import com.devssi.prueba.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    AccountService accountService;

    @Autowired
    BalanceService balanceService;

    @Autowired
    TransactionRepository repository;

    public TransactionsDTO getAccountTransactions(Long accountId) {
        List<Transaction> transactionList = repository.getAllTransactionsByAccountId(accountId);
        TransactionsDTO transactionsDTO = new TransactionsDTO();
        for (Transaction transaction : transactionList) {
            transactionsDTO.getTransactions().add(
                    new TransactionDTO(transaction.getFromAccount().getId(),
                            transaction.getToAccount().getId(),
                            transaction.getAmount(),
                            transaction.getCreatedAt())
            );
        }
        return transactionsDTO;
    }

    public TransactionResultDTO doTransaction(Long fromAccountId, Long toAccountId, Long amount) {
        return accountService.getAccountById(fromAccountId)
                .flatMap(
                        fromAccount ->
                                accountService.getAccountById(toAccountId)
                                        .map(toAccount -> createTransaction(fromAccount, toAccount, amount)
                                        )
                ).orElse(new TransactionResultDTO("cuenta inexistente"));
    }

    private TransactionResultDTO createTransaction(Account fromAccount, Account toAccount, Long amount) {
        if (fromAccount.getLastBalance().getAmount() < amount) {
            return new TransactionResultDTO("saldo insuficiente");
        }
        Long newFromAmount = fromAccount.getLastBalance().getAmount() - amount;
        Long newToAmount = toAccount.getLastBalance().getAmount() + amount;
        boolean success = balanceService.createBalance(newFromAmount, fromAccount) &&
                balanceService.createBalance(newToAmount, toAccount);
        return success ? new TransactionResultDTO() : new TransactionResultDTO("error en la operacion");
    }
}
