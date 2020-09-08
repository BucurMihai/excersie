package com.alten.mihaibucur.service.data;


import java.io.Serializable;
import java.util.Date;

public class TransactionData implements Serializable {

    private Long id;
    private String accountId;

    private RateData exchangeRate;
    private AmountData amountData;
    private TransactionSourceData creditor;
    private TransactionSourceData debtor;
    private String status;
    private String currency;
    private Double amount;
    private Date update;
    private String description;

    public TransactionData() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public RateData getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(RateData exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public AmountData getAmountData() {
        return amountData;
    }

    public void setAmountData(AmountData amountData) {
        this.amountData = amountData;
    }

    public TransactionSourceData getCreditor() {
        return creditor;
    }

    public void setCreditor(TransactionSourceData creditor) {
        this.creditor = creditor;
    }

    public TransactionSourceData getDebtor() {
        return debtor;
    }

    public void setDebtor(TransactionSourceData debtor) {
        this.debtor = debtor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getUpdate() {
        return update;
    }

    public void setUpdate(Date update) {
        this.update = update;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
