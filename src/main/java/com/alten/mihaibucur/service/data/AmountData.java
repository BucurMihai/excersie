package com.alten.mihaibucur.service.data;

import java.io.Serializable;

public class AmountData implements Serializable {
    private Double amount;
    private String currency;

    public AmountData() {

    }

    public AmountData(Double amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
