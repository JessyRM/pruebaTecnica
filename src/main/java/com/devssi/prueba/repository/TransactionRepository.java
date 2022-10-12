package com.devssi.prueba.repository;

import com.devssi.prueba.model.Transaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {

    @Query("select t from Transaction t where t.fromAccount.id = :id or t.toAccount.id = :id")
    List<Transaction> getAllTransactionsByAccountId(Long id);
}
