package com.devssi.prueba.controller;

import com.devssi.prueba.dto.AccountsDTO;
import com.devssi.prueba.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    AccountService service;

    @GetMapping("/account")
    public AccountsDTO getAllAccounts(){
        return service.getAllAccounts();
    }
}
