package com.alten.mihaibucur.service.data;

import java.io.Serializable;
import java.util.List;

public class CustomerResponseData implements Serializable {

    private List<CustomerData> customerDataList;

    public CustomerResponseData(){

    }

    public CustomerResponseData(List<CustomerData> customerDataList) {
        this.customerDataList = customerDataList;
    }

    public List<CustomerData> getCustomerDataList() {
        return customerDataList;
    }

    public void setCustomerDataList(List<CustomerData> customerDataList) {
        this.customerDataList = customerDataList;
    }
}
