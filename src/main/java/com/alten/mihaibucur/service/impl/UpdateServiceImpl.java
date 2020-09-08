package com.alten.mihaibucur.service.impl;

import com.alten.mihaibucur.service.data.CustomerData;
import com.alten.mihaibucur.service.data.TransactionData;
import com.alten.mihaibucur.service.interfaces.CustomerService;
import com.alten.mihaibucur.service.interfaces.LoginService;
import com.alten.mihaibucur.service.interfaces.TransactionService;
import com.alten.mihaibucur.service.interfaces.UpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;
import java.util.List;

@Service
public class UpdateServiceImpl implements UpdateService {

    @Autowired
    LoginService loginService;

    @Autowired
    CustomerService customerService;

    @Autowired
    TransactionService transactionService;

    @Override
    public void update() throws URISyntaxException {
        String jwtToken = loginService.getToken();

        List<CustomerData> customerDataList = customerService.getCustomers(jwtToken);
        customerService.update(customerDataList);

        List<TransactionData> transactionDataList = transactionService.getTransactions(jwtToken);
        transactionService.update(transactionDataList);
    }
}
