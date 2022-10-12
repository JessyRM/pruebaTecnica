package com.devssi.prueba.repository;

import com.devssi.prueba.model.Balance;
import org.springframework.data.repository.CrudRepository;

public interface BalanceRepository extends CrudRepository<Balance, Long> {
}
