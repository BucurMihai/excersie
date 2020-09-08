package com.alten.mihaibucur.controller.facade.interfaces;

import com.alten.mihaibucur.controller.dto.CustomerDto;

import java.util.List;

public interface CustomerFacade {
    List<CustomerDto> getCustomers(int startPage, int endPage);
}
