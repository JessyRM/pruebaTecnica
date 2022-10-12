package com.devssi.prueba.repository;

import com.devssi.prueba.model.Balance;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BalanceRepository extends CrudRepository<Balance, Long> {
    @Query("select b from Balance b where b.account.id = :accountId")
    Balance getBalanceForAccount(Long accountId);
}
