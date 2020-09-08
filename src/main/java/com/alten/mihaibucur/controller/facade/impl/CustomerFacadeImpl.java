package com.alten.mihaibucur.controller.facade.impl;

import com.alten.mihaibucur.controller.dto.CustomerDto;
import com.alten.mihaibucur.controller.facade.interfaces.CustomerFacade;
import com.alten.mihaibucur.service.interfaces.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerFacadeImpl implements CustomerFacade {

    @Autowired
    CustomerService customerService;

    @Override
    public List<CustomerDto> getCustomers(int startPage, int endPage) {
        return customerService.getCustomers(startPage, endPage);
    }
}
