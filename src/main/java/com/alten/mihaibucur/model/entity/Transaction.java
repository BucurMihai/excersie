package com.alten.mihaibucur.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.Date;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String status;
    private String currency;
    private Double amount;
    private Date update;
    private String description;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "amount_id", referencedColumnName = "id")
    private Amount originalAmount;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "rate_id", referencedColumnName = "id")
    private Rate exchangeRate;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "creditor_id", referencedColumnName = "id")
    private TransactionSource creditor;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "debtor_id", referencedColumnName = "id")
    private TransactionSource debtor;


    public Transaction(){

    }
    public Transaction(String status, String currency, Double amount, Date update, String description, Amount originalAmount, Rate exchangeRate, TransactionSource creditor, TransactionSource debtor) {
        this.status = status;
        this.currency = currency;
        this.amount = amount;
        this.update = update;
        this.description = description;
        this.originalAmount = originalAmount;
        this.exchangeRate = exchangeRate;
        this.creditor = creditor;
        this.debtor = debtor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Amount getOriginalAmount() {
        return originalAmount;
    }

    public void setOriginalAmount(Amount originalAmount) {
        this.originalAmount = originalAmount;
    }

    public Rate getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(Rate exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public TransactionSource getCreditor() {
        return creditor;
    }

    public void setCreditor(TransactionSource creditor) {
        this.creditor = creditor;
    }

    public TransactionSource getDebtor() {
        return debtor;
    }

    public void setDebtor(TransactionSource debtor) {
        this.debtor = debtor;
    }
}
