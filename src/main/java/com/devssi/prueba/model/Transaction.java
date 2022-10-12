package com.devssi.prueba.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Table
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false)
    private Timestamp createdAt;
    @Column(nullable = false)
    private Long amount;
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

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
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
