package com.alten.mihaibucur.service.impl;

import com.alten.mihaibucur.service.data.TransactionData;
import com.alten.mihaibucur.service.interfaces.TransactionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Override
    public void update(List<TransactionData> transactionDataList) {

    }

    @Override
    public List<TransactionData> getTransactions(String jwtToken) {
        return null;
    }
}
