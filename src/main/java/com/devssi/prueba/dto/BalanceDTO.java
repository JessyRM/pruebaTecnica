package com.devssi.prueba.dto;

import java.util.Date;

public class BalanceDTO {
    Long account;
    Long balance;
    Long owner;
    Date createdAt;

    public BalanceDTO() {
    }

    public BalanceDTO(Long account, Long balance, Long owner, Date createdAt) {
        this.account = account;
        this.balance = balance;
        this.owner = owner;
        this.createdAt = createdAt;
    }

    public Long getAccount() {
        return account;
    }

    public void setAccount(Long account) {
        this.account = account;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public Long getOwner() {
        return owner;
    }

    public void setOwner(Long owner) {
        this.owner = owner;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
