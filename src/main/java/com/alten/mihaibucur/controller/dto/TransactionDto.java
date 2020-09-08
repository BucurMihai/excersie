package com.alten.mihaibucur.controller.dto;

import java.util.Date;

public class TransactionDto {

    private Long id;
    private String accountId;
    private RateDto exchangeRate;
    private AmountDto originalAmount;
    private TransactionSourceDto creditor;
    private TransactionSourceDto debtor;
    private String status;
    private String currency;
    private Double amount;
    private Date update;
    private String description;

    public TransactionDto(){

    }

    public TransactionDto(Long id, String accountId, RateDto rateDto, AmountDto originalAmount, TransactionSourceDto creditor, TransactionSourceDto debtor, String status, String currency, Double amount, Date update, String description) {
        this.id = id;
        this.accountId = accountId;
        this.originalAmount = originalAmount;
        this.creditor = creditor;
        this.debtor = debtor;
        this.status = status;
        this.currency = currency;
        this.amount = amount;
        this.update = update;
        this.description = description;
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

    public RateDto getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(RateDto exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public AmountDto getOriginalAmount() {
        return originalAmount;
    }

    public void setOriginalAmount(AmountDto originalAmount) {
        this.originalAmount = originalAmount;
    }

    public TransactionSourceDto getCreditor() {
        return creditor;
    }

    public void setCreditor(TransactionSourceDto creditor) {
        this.creditor = creditor;
    }

    public TransactionSourceDto getDebtor() {
        return debtor;
    }

    public void setDebtor(TransactionSourceDto debtor) {
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
