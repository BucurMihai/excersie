package com.alten.mihaibucur.controller.endpoint;

import com.alten.mihaibucur.controller.dto.CustomerDto;
import com.alten.mihaibucur.controller.dto.TransactionDto;
import com.alten.mihaibucur.controller.facade.interfaces.TransactionFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;
import java.util.List;

@RestController
public class TransactionController {

    @Autowired
    TransactionFacade transactionFacade;


    @GetMapping({ "/transactions" })
    public List<TransactionDto> get(@RequestParam int startPage, @RequestParam int endPage) throws URISyntaxException {
        return transactionFacade.getTransactions(startPage, endPage);
    }
}
