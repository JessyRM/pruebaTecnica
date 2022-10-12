package com.devssi.prueba.service;

import com.devssi.prueba.dto.AccountDTO;
import com.devssi.prueba.dto.AccountsDTO;
import com.devssi.prueba.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    AccountRepository repository;

    public AccountsDTO getAllAccounts() {
        AccountsDTO accountsDTO = new AccountsDTO();
        accountsDTO.setAccounts(List.of(
                new AccountDTO(),
                new AccountDTO(),
                new AccountDTO())
        );
        return accountsDTO;
    }
}
