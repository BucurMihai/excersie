package com.alten.mihaibucur.service.data;

import java.io.Serializable;

public class RateData  implements Serializable {
    private String currencyFrom;
    private String currencyTo;
    private Double rate;

    public RateData(){

    }
    public RateData(String currencyFrom, String currencyTo, Double rate) {
        this.currencyFrom = currencyFrom;
        this.currencyTo = currencyTo;
        this.rate = rate;
    }

    public String getCurrencyFrom() {
        return currencyFrom;
    }

    public void setCurrencyFrom(String currencyFrom) {
        this.currencyFrom = currencyFrom;
    }

    public String getCurrencyTo() {
        return currencyTo;
    }

    public void setCurrencyTo(String currencyTo) {
        this.currencyTo = currencyTo;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
}
