package com.alten.mihaibucur.service.impl.mapping;

import com.alten.mihaibucur.controller.dto.CustomerDto;
import com.alten.mihaibucur.model.entity.Customer;
import com.alten.mihaibucur.service.data.CustomerData;
import com.alten.mihaibucur.service.interfaces.CustomerService;
import com.alten.mihaibucur.service.interfaces.mapping.DataMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
//this could be replaced by a dozer mechanism to handle the mappings
public class DataMapperServiceImpl implements DataMapperService {

    @Autowired
    CustomerService customerService;


    @Override
    public List<Customer> map(List<CustomerData> customerDataList) {
        return customerDataList.stream()
                .map(this::mapCustomerDataToCustomer)
                .collect(Collectors.toList());
    }

    @Override
    public List<CustomerDto> map(Page<Customer> customerPage) {
        List<CustomerDto> customerDtoList = customerPage.stream().map(this::mapCustomerToDto).collect(Collectors.toList());
        return customerDtoList;
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
