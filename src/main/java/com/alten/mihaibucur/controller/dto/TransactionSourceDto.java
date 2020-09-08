package com.alten.mihaibucur.controller.dto;

public class TransactionSourceDto {
    private String maskedPan;
    private String name;

    public TransactionSourceDto(){

    }

    public TransactionSourceDto(String maskedPan, String name) {
        this.maskedPan = maskedPan;
        this.name = name;
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
