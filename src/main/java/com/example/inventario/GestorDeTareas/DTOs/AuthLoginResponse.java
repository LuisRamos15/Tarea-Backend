package com.example.inventario.GestorDeTareas.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthLoginResponse {

    @JsonProperty("token")
    private String token;

    @JsonProperty("userID")
    private long userID;

    public AuthLoginResponse(String token, long userID) {
        this.token = token;
        this.userID = userID;
    }
}
