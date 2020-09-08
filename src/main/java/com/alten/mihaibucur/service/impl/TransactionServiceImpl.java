package com.alten.mihaibucur.service.impl;

import com.alten.mihaibucur.controller.dto.CustomerDto;
import com.alten.mihaibucur.controller.dto.TransactionDto;
import com.alten.mihaibucur.model.dao.TransactionRepository;
import com.alten.mihaibucur.model.entity.Customer;
import com.alten.mihaibucur.model.entity.Transaction;
import com.alten.mihaibucur.service.data.TransactionData;
import com.alten.mihaibucur.service.interfaces.TransactionService;
import com.alten.mihaibucur.service.interfaces.mapping.DataMapperService;
import com.alten.mihaibucur.service.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final static String ENDPOINT_PATH = "/transactions";

    @Autowired
    DataMapperService dataMapperService;

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public void update(List<TransactionData> transactionDataList) {
        List<Transaction> transactions = dataMapperService.mapTransactions(transactionDataList);
        transactionRepository.saveAll(transactions);
    }

    @Override
    public List<TransactionData> getTransactions(String jwtToken) throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = Constants.ENDPOINT_URL + ENDPOINT_PATH;
        URI uri = new URI(baseUrl);

        HttpHeaders headers = new HttpHeaders();
        headers.set(Constants.CONTENT_HEADER_KEY, Constants.CONTENT_HEADER_VALUE);
        headers.set(Constants.TOKEN_KEY, jwtToken);

        HttpEntity entity = new HttpEntity(headers);

        ParameterizedTypeReference<List<TransactionData>> responseType = new ParameterizedTypeReference<List<TransactionData>>() {
        };
        ResponseEntity<List<TransactionData>> response = restTemplate.exchange(uri, HttpMethod.GET, entity, responseType);

        return response.getStatusCode() == HttpStatus.OK ? response.getBody() : Collections.EMPTY_LIST;
    }

    @Override
    public Optional<Transaction> findById(Long id) {
        return transactionRepository.findById(id);
    }

    @Override
    public List<TransactionDto> getTransactions(int startPage, int endPage) {
        Pageable pageable = PageRequest.of(startPage, endPage);
        Page<Transaction> transactionPage = transactionRepository.findAll(pageable);
        List<TransactionDto> transactionDtoList = dataMapperService.mapTransactionPage(transactionPage);
        return transactionDtoList;
    }
}
