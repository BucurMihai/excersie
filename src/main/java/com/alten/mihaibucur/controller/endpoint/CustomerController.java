package com.alten.mihaibucur.controller.endpoint;

import com.alten.mihaibucur.controller.dto.CustomerDto;
import com.alten.mihaibucur.controller.facade.interfaces.CustomerFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;
import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerFacade customerFacade;

    @GetMapping({ "/customers" })
    public List<CustomerDto> get(@RequestParam int startPage, @RequestParam int endPage) throws URISyntaxException {
       return customerFacade.getCustomers(startPage,endPage);
    }
}
