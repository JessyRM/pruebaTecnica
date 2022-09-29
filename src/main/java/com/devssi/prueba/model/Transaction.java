package com.devssi.prueba.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Transaction {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private Timestamp createdAt;
    @Column(nullable = false)
    private Integer amount;
    @ManyToOne
    @JoinColumn(name = "to_account_id")
    private Account toAccount;
    @ManyToOne
    @JoinColumn(name = "from_account_id")
    private Account fromAccount;


    public Long getId() {
        return id;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Account getToAccount() {
        return toAccount;
    }

    public void setToAccount(Account toAccount) {
        this.toAccount = toAccount;
    }

    public Account getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(Account fromAccount) {
        this.fromAccount = fromAccount;
    }
}
