package com.devssi.prueba.dto;

import com.devssi.prueba.model.Account;

import java.util.List;


public class AccountsDTO {
    List<AccountDTO> accounts;

    public List<AccountDTO> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<AccountDTO> accounts) {
        this.accounts = accounts;
    }
}
