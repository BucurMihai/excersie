package com.alten.mihaibucur.service.impl.mapping;

import com.alten.mihaibucur.controller.dto.CustomerDto;
import com.alten.mihaibucur.model.entity.Customer;
import com.alten.mihaibucur.model.entity.Rate;
import com.alten.mihaibucur.model.entity.Transaction;
import com.alten.mihaibucur.model.entity.TransactionSource;
import com.alten.mihaibucur.service.data.CustomerData;
import com.alten.mihaibucur.service.data.RateData;
import com.alten.mihaibucur.service.data.TransactionData;
import com.alten.mihaibucur.service.data.TransactionSourceData;
import com.alten.mihaibucur.service.interfaces.CustomerService;
import com.alten.mihaibucur.service.interfaces.TransactionService;
import com.alten.mihaibucur.service.interfaces.mapping.DataMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
//this could be replaced by a dozer mechanism to handle the mappings
public class DataMapperServiceImpl implements DataMapperService {

    @Autowired
    CustomerService customerService;

    @Autowired
    TransactionService transactionService;

    @Override
    public List<Customer> map(List<CustomerData> customerDataList) {
        return customerDataList.stream()
                .map(this::mapCustomerDataToCustomer)
                .collect(Collectors.toList());
    }

    @Override
    public List<CustomerDto> map(Page<Customer> customerPage) {
        return customerPage.stream().map(this::mapCustomerToDto).collect(Collectors.toList());
    }

    @Override
    public List<Transaction> mapTransactions(List<TransactionData> transactionDataList) {
        return transactionDataList.stream().map(this::mapTransactionDataToEntity).collect(Collectors.toList());
    }

    private Transaction mapTransactionDataToEntity(TransactionData transactionData) {
        Transaction transaction = transactionService.findById(transactionData.getId()).orElse(new Transaction());
        transaction.setStatus(transactionData.getStatus());
        transaction.setCurrency(transactionData.getCurrency());
        transaction.setAmount(transactionData.getAmount());
        transaction.setUpdate(transactionData.getUpdate());
        transaction.setDescription(transactionData.getDescription());
        transaction.setExchangeRate(mapRateDataToEntity(transactionData.getExchangeRate()));
        transaction.setCreditor(mapTransactionSourceToEntity(transactionData.getCreditor()));
        transaction.setDebtor(mapTransactionSourceToEntity(transactionData.getDebtor()));
        return transaction;
    }

    private TransactionSource mapTransactionSourceToEntity(TransactionSourceData transactionSourceData) {
        TransactionSource transactionSource = new TransactionSource();
        if(transactionSourceData != null){
            transactionSource.setMaskedPan(transactionSourceData.getMaskedPan());
            transactionSource.setName(transactionSourceData.getName());
        }
        return transactionSource;
    }

    private Rate mapRateDataToEntity(RateData exchangeRate) {
        Rate rate = new Rate();
        if(exchangeRate != null){
            rate.setCurrencyFrom(exchangeRate.getCurrencyFrom());
            rate.setCurrencyTo(exchangeRate.getCurrencyFrom());
            rate.setRate(exchangeRate.getRate());
        }
        return rate;
    }

    private CustomerDto mapCustomerToDto(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setBalance(customer.getBalance());
        customerDto.setName(customer.getName());
        customerDto.setBalance(customer.getBalance());
        customerDto.setProduct(customer.getProduct());
        customerDto.setStatus(customer.getStatus());
        return customerDto;
    }

    private Customer mapCustomerDataToCustomer(CustomerData customerData) {
        Customer customer = customerService.findById(customerData.getId()).orElse(new Customer());
        customer.setName(customerData.getName());
        customer.setBalance(customerData.getBalance());
        customer.setProduct(customerData.getProduct());
        customer.setStatus(customerData.getStatus());
        customer.setType(customerData.getType());
        return customer;
    }

}
