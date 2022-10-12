package com.devssi.prueba.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Table
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false)
    private Timestamp createdAt;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @OneToMany(mappedBy = "account")
    @OrderBy("createdAt ASC")
    private List<Balance> balanceHistory;
    @OneToMany(mappedBy = "toAccount")
    @OrderBy("createdAt ASC")
    private List<Transaction> receivedTransactionHistory;
    @OneToMany(mappedBy = "fromAccount")
    @OrderBy("createdAt ASC")
    private List<Transaction> sentTransactionHistory;


    public Long getId() {
        return id;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Balance> getBalanceHistory() {
        return balanceHistory;
    }

    public void setBalanceHistory(List<Balance> balance_history) {
        this.balanceHistory = balance_history;
    }

    public Balance getLastBalance(){
        // obtener el ultimo estado de cuenta
        return this.balanceHistory.get(this.balanceHistory.size() - 1);
    }

    public List<Transaction> getReceivedTransactionHistory() {
        return receivedTransactionHistory;
    }

    public void setReceivedTransactionHistory(List<Transaction> receivedTransactionHistory) {
        this.receivedTransactionHistory = receivedTransactionHistory;
    }

    public List<Transaction> getSentTransactionHistory() {
        return sentTransactionHistory;
    }

    public void setSentTransactionHistory(List<Transaction> sentTransactionHistory) {
        this.sentTransactionHistory = sentTransactionHistory;
    }
}
