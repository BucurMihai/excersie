package com.alten.mihaibucur.service.impl;

import com.alten.mihaibucur.controller.dto.CustomerDto;
import com.alten.mihaibucur.model.dao.CustomerRepository;
import com.alten.mihaibucur.model.entity.Customer;
import com.alten.mihaibucur.service.data.CustomerData;
import com.alten.mihaibucur.service.data.CustomerResponseData;
import com.alten.mihaibucur.service.data.JwtRequestData;
import com.alten.mihaibucur.service.data.JwtResponseData;
import com.alten.mihaibucur.service.interfaces.CustomerService;
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

import javax.transaction.Transactional;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final static String ENDPOINT_PATH = "/accounts";

    @Autowired
    DataMapperService dataMapperService;

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<CustomerData> getCustomers(String jwtToken) throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = Constants.ENDPOINT_URL + ENDPOINT_PATH;
        URI uri = new URI(baseUrl);

        HttpHeaders headers = new HttpHeaders();
        headers.set(Constants.CONTENT_HEADER_KEY, Constants.CONTENT_HEADER_VALUE);
        headers.set(Constants.TOKEN_KEY, jwtToken);

        HttpEntity entity = new HttpEntity(headers);

        ParameterizedTypeReference<List<CustomerData>> responseType = new ParameterizedTypeReference<List<CustomerData>>() {};
        ResponseEntity<List<CustomerData>> response = restTemplate.exchange(uri, HttpMethod.GET, entity, responseType);

        return response.getStatusCode() == HttpStatus.OK ? response.getBody(): Collections.EMPTY_LIST;
    }

    @Override
    public void update(List<CustomerData> customerDataList) {
        List<Customer> customerList = dataMapperService.map(customerDataList);
        customerRepository.saveAll(customerList);

    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public List<CustomerDto> getCustomers(int startPage, int endPage) {
        Pageable pageable = PageRequest.of(startPage, endPage);
        Page<Customer> customerPage = customerRepository.findAll(pageable);
        List<CustomerDto> customerDtoList = dataMapperService.map(customerPage);
        return customerDtoList;
    }

}
