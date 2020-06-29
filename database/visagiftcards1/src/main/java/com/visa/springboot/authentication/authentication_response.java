package com.visa.springboot.authentication;

public class authentication_response {

    private final String jwt;

    public authentication_response(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }
}
