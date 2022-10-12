package com.devssi.prueba.dto;

import java.util.ArrayList;
import java.util.List;

public class TransactionsDTO {

    List<TransactionDTO> transactions;

    public TransactionsDTO() {
        this(new ArrayList<>());
    }

    public TransactionsDTO(List<TransactionDTO> transactions) {
        this.transactions = transactions;
    }

    public List<TransactionDTO> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionDTO> transactions) {
        this.transactions = transactions;
    }
}
