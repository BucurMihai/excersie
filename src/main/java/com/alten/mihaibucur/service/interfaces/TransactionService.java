package com.alten.mihaibucur.service.interfaces;

import com.alten.mihaibucur.model.entity.Transaction;
import com.alten.mihaibucur.service.data.TransactionData;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

public interface TransactionService {
    void update(List<TransactionData> transactionDataList);

    List<TransactionData> getTransactions(String jwtToken) throws URISyntaxException;

    Optional<Transaction> findById(Long id);
}
