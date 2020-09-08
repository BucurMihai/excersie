package com.alten.mihaibucur.service.interfaces;

import com.alten.mihaibucur.controller.dto.CustomerDto;
import com.alten.mihaibucur.model.entity.Customer;
import com.alten.mihaibucur.service.data.CustomerData;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<CustomerData> getCustomers(String jwtToken) throws URISyntaxException;

    void update(List<CustomerData> customerDataList);

    Optional<Customer> findById(Long id);

    List<CustomerDto> getCustomers(int startPage, int endPage);
}
