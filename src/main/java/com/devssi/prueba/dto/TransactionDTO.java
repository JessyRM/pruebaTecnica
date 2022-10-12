package com.devssi.prueba.dto;

import java.util.Date;

public class TransactionDTO {
    Long fromAccount;
    Long toAccount;
    Long amount;
    Date sentAt;

    public TransactionDTO() {
    }

    public TransactionDTO(Long fromAccount, Long toAccount, Long amount, Date sentAt) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
        this.sentAt = sentAt;
    }

    public Long getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(Long fromAccount) {
        this.fromAccount = fromAccount;
    }

    public Long getToAccount() {
        return toAccount;
    }

    public void setToAccount(Long toAccount) {
        this.toAccount = toAccount;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Date getSentAt() {
        return sentAt;
    }

    public void setSentAt(Date sentAt) {
        this.sentAt = sentAt;
    }
}
