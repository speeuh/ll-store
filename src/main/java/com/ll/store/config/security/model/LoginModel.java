package com.ll.store.config.security.model;

import lombok.Setter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Setter
public class LoginModel {

    private String userName;
    private String password;

    public UsernamePasswordAuthenticationToken convertModelToAuthenticationToken() {
        return new UsernamePasswordAuthenticationToken(userName, password);
    }

}
