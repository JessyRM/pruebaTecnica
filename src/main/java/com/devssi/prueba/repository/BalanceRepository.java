package com.devssi.prueba.repository;

import com.devssi.prueba.model.Balance;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BalanceRepository extends CrudRepository<Balance, Long> {
    @Query(value = "select * from balance b where b.account_id = :accountId order by b.created_at limit 1 ", nativeQuery = true)
    Balance getBalanceForAccount(Long accountId);
}
