package com.alten.mihaibucur.service.data;

import java.io.Serializable;

public class JwtRequestData implements Serializable {
    private static final long serialVersionUID = 5926468583005150707L;
    private String username;

    //need default constructor for JSON Parsing
    public JwtRequestData() {
    }

    public JwtRequestData(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}