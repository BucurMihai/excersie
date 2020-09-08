package com.alten.mihaibucur.service.interfaces.mapping;

import com.alten.mihaibucur.controller.dto.CustomerDto;
import com.alten.mihaibucur.model.entity.Customer;
import com.alten.mihaibucur.model.entity.Transaction;
import com.alten.mihaibucur.service.data.CustomerData;
import com.alten.mihaibucur.service.data.TransactionData;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DataMapperService {

    List<Customer> map(List<CustomerData> customerDataList);

    List<CustomerDto> map(Page<Customer> customerPage);

    List<Transaction> mapTransactions(List<TransactionData> transactionDataList);
}
