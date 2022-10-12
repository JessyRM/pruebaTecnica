package com.devssi.prueba.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Table
@Entity
public class Balance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private Timestamp createdAt;
    @Column(nullable = false)
    private Integer amount;
    @ManyToOne
    @JoinColumn(name = "account_id")
    Account account;

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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
