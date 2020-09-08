package com.alten.mihaibucur.service.impl.mapping;

import com.alten.mihaibucur.controller.dto.AmountDto;
import com.alten.mihaibucur.controller.dto.CustomerDto;
import com.alten.mihaibucur.controller.dto.RateDto;
import com.alten.mihaibucur.controller.dto.TransactionDto;
import com.alten.mihaibucur.controller.dto.TransactionSourceDto;
import com.alten.mihaibucur.model.entity.Amount;
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
import org.springframework.security.core.parameters.P;
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

    @Override
    public List<TransactionDto> mapTransactionPage(Page<Transaction> transactionPage) {
        return transactionPage.stream().map(this::mapTransactionToDto).collect(Collectors.toList());
    }

    private TransactionDto mapTransactionToDto(Transaction transaction) {
        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setStatus(transaction.getStatus());
        transactionDto.setCurrency(transaction.getCurrency());
        transactionDto.setAmount(transaction.getAmount());
        transactionDto.setUpdate(transaction.getUpdate());
        transactionDto.setDescription(transaction.getDescription());
        transactionDto.setExchangeRate(mapExchangeRateToDto(transaction.getExchangeRate()));
        transactionDto.setOriginalAmount(mapAmountToDto(transaction.getOriginalAmount()));
        transactionDto.setCreditor(mapTransactionSourceToDto(transaction.getCreditor()));
        return transactionDto;
    }

    private TransactionSourceDto mapTransactionSourceToDto(TransactionSource transactionSource) {
        TransactionSourceDto transactionSourceDto = new TransactionSourceDto();
        if(transactionSource != null){
            transactionSourceDto.setMaskedPan(transactionSource.getMaskedPan());
            transactionSourceDto.setName(transactionSource.getName());
        }

        return transactionSourceDto;
    }

    private AmountDto mapAmountToDto(Amount originalAmount) {
        AmountDto amountDto = new AmountDto();
        if(originalAmount != null){
            amountDto.setAmount(originalAmount.getAmount());
            amountDto.setCurrency(originalAmount.getCurrency());
        }
        return amountDto;
    }

    private RateDto mapExchangeRateToDto(Rate exchangeRate) {
        RateDto rateDto = new RateDto();
        if(exchangeRate != null){
            rateDto.setCurrencyFrom(exchangeRate.getCurrencyFrom());
            rateDto.setCurrencyTo(exchangeRate.getCurrencyTo());
            rateDto.setRate(exchangeRate.getRate());
        }
        return rateDto;
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
