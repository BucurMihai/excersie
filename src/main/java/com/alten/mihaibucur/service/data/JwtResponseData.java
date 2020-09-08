package com.alten.mihaibucur.service.data;

import java.io.Serializable;

public class JwtResponseData implements Serializable {
    private String token;


    public JwtResponseData(){

    }

    public JwtResponseData(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}