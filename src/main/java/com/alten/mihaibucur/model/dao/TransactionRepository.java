package com.alten.mihaibucur.model.dao;

import com.alten.mihaibucur.model.entity.Customer;
import com.alten.mihaibucur.model.entity.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {
    Page<Transaction> findAll(Pageable pageable);
}
