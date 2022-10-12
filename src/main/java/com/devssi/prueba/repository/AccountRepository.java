package com.devssi.prueba.repository;

import com.devssi.prueba.model.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {

}
