package com.alten.mihaibucur.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TransactionSource {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String maskedPan;
    private String name;

    public TransactionSource(String maskedPan, String name) {
        this.maskedPan = maskedPan;
        this.name = name;
    }

    public TransactionSource(){

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMaskedPan() {
        return maskedPan;
    }

    public void setMaskedPan(String maskedPan) {
        this.maskedPan = maskedPan;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
