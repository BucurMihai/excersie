package com.alten.mihaibucur.service.interfaces;

import com.alten.mihaibucur.service.data.TransactionData;

import java.util.List;

public interface TransactionService {
    void update(List<TransactionData> transactionDataList);

    List<TransactionData> getTransactions(String jwtToken);
}
