package com.devssi.prueba.service;

import com.devssi.prueba.dto.TransactionDTO;
import com.devssi.prueba.dto.TransactionsDTO;
import com.devssi.prueba.model.Transaction;
import com.devssi.prueba.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository repository;

    public TransactionsDTO getAccountTransactions(Long accountId){
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
}
