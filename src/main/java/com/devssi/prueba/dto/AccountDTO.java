package com.devssi.prueba.dto;

import java.util.Date;

public class AccountDTO {
    Long account;
    Integer balance;
    Integer owner;
    Date createdAt;

    public AccountDTO() {
    }

    public AccountDTO(Long account, Integer balance, Integer owner, Date createdAt) {
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

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Integer getOwner() {
        return owner;
    }

    public void setOwner(Integer owner) {
        this.owner = owner;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
