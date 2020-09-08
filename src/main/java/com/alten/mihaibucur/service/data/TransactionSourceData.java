package com.alten.mihaibucur.service.data;

import java.io.Serializable;

public class TransactionSourceData implements Serializable {
    private String maskedPan;
    private String name;

    public TransactionSourceData(){

    }
    public TransactionSourceData(String maskedPan, String name) {
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
