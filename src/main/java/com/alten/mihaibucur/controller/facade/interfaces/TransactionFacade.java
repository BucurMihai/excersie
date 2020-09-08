package com.alten.mihaibucur.controller.facade.interfaces;

import com.alten.mihaibucur.controller.dto.TransactionDto;

import java.util.List;

public interface TransactionFacade {
    List<TransactionDto> getTransactions(int startPage, int endPage);
}
