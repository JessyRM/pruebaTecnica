package com.devssi.prueba.service;

import com.devssi.prueba.dto.AccountDTO;
import com.devssi.prueba.dto.AccountsDTO;
import com.devssi.prueba.model.Account;
import com.devssi.prueba.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    AccountRepository repository;

    public AccountsDTO getAllAccounts() {
        AccountsDTO accountsDTO = new AccountsDTO();
        for (Account account : repository.findAll()) {
            accountsDTO.getAccounts()
                    .add(
                            new AccountDTO(account.getId(),
                                    account.getLastBalance().getAmount(),
                                    account.getClient().getNumber(),
                                    account.getCreatedAt())
                    );
        }
        return accountsDTO;
    }
}
