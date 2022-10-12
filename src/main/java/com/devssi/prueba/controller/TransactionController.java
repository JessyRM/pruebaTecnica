package com.devssi.prueba.controller;

import com.devssi.prueba.dto.TransactionDTO;
import com.devssi.prueba.dto.TransactionResultDTO;
import com.devssi.prueba.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    TransactionService service;

    @PostMapping
    public TransactionResultDTO createTransaction(@RequestBody TransactionDTO transactionDTO) {
        return service.doTransaction(transactionDTO.getFromAccount(), transactionDTO.getToAccount(), transactionDTO.getAmount());
    }
}
