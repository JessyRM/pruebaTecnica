package com.devssi.prueba.dto;

import java.util.ArrayList;
import java.util.List;


public class AccountsDTO {
    List<AccountDTO> accounts;

    public AccountsDTO() {
        this(new ArrayList<>());
    }

    public AccountsDTO(List<AccountDTO> accounts) {
        this.accounts = accounts;
    }

    public List<AccountDTO> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<AccountDTO> accounts) {
        this.accounts = accounts;
    }
}
