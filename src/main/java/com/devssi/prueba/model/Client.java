package com.devssi.prueba.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Table
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Timestamp createdAt;
    @Column(nullable = false)
    private Integer number;
    @OneToMany(mappedBy = "client")
    private List<Account> accounts;


    public Long getId() {
        return id;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
