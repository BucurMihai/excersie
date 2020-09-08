package com.alten.mihaibucur.controller.facade.impl;

import com.alten.mihaibucur.controller.dto.TransactionDto;
import com.alten.mihaibucur.controller.facade.interfaces.TransactionFacade;
import com.alten.mihaibucur.service.interfaces.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionFacadeImpl implements TransactionFacade {
    @Autowired
    TransactionService transactionService;


    @Override
    public List<TransactionDto> getTransactions(int startPage, int endPage) {
        return transactionService.getTransactions(startPage,endPage);
    }
}
