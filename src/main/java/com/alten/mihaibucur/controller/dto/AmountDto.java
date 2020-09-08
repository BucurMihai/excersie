package com.alten.mihaibucur.controller.dto;

public class AmountDto {
    private Double amount;
    private String currency;

    public AmountDto(){

    }

    public AmountDto(Double amount, String currency) {
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
