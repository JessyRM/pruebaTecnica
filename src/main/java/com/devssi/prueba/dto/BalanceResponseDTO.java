package com.devssi.prueba.dto;

public class BalanceResponseDTO {
    BalanceDTO balance;

    public BalanceResponseDTO() {
    }

    public BalanceResponseDTO(BalanceDTO balance) {
        this.balance = balance;
    }

    public BalanceDTO getBalance() {
        return balance;
    }

    public void setBalance(BalanceDTO balance) {
        this.balance = balance;
    }
}
