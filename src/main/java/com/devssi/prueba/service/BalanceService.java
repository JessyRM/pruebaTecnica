package com.devssi.prueba.service;

import com.devssi.prueba.dto.BalanceDTO;
import com.devssi.prueba.dto.BalanceResponseDTO;
import com.devssi.prueba.model.Account;
import com.devssi.prueba.model.Balance;
import com.devssi.prueba.repository.BalanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class BalanceService {

    @Autowired
    BalanceRepository repository;

    public boolean createBalance(Long newAmount, Account account) {
        Balance balance = new Balance();
        if (account == null) {
            return false;
        }
        balance.setAccount(account);
        balance.setAmount(newAmount);
        balance.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        repository.save(balance);
        return true;
    }

    public BalanceResponseDTO getBalanceForAccount(Long accountId) {
        Balance balance = repository.getBalanceForAccount(accountId);
        BalanceResponseDTO balanceResponseDTO = new BalanceResponseDTO(new BalanceDTO());
        balanceResponseDTO.getBalance().setAccount(balance.getAccount().getId());
        balanceResponseDTO.getBalance().setOwner(balance.getAccount().getClient().getNumber());
        balanceResponseDTO.getBalance().setBalance(balance.getAmount());
        balanceResponseDTO.getBalance().setCreatedAt(balance.getCreatedAt());
        return balanceResponseDTO;
    }
}
