package com.ll.store.config.security.controller;

import com.ll.store.config.security.dto.TokenDto;
import com.ll.store.config.security.model.LoginModel;
import com.ll.store.config.security.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<TokenDto> authentication(@RequestBody @Valid LoginModel model){
        UsernamePasswordAuthenticationToken dataLogin = model.convertModelToAuthenticationToken();

        try {
            Authentication authentication = authManager.authenticate(dataLogin);
            String token = tokenService.tokenGenerate(authentication);
            return ResponseEntity.ok(new TokenDto(token, "Bearer"));
        } catch (AuthenticationException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}

