package com.ll.store.config.security;

import com.ll.store.config.security.service.TokenService;
import com.ll.store.repository.entity.user.User;
import com.ll.store.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtTokenFilterAuthentication extends OncePerRequestFilter {

    private TokenService tokenService;

    private UserRepository userRepository;

    public JwtTokenFilterAuthentication(TokenService tokenService, UserRepository userRepository) {
        this.tokenService = tokenService;
        this.userRepository = userRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = getToken(request);
        boolean valid = tokenService.tokenIsValid(token);
        if (valid) {
            clientAuthenticate(token);
        }

        filterChain.doFilter(request, response);
    }

    private void clientAuthenticate(String token) {
        Long userId = tokenService.getUserId(token);
        User user = userRepository.findById(userId).get();
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    private String getToken(HttpServletRequest request) {
        String token =  request.getHeader("Authorization");

        if( token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
            return null;
        }

        return token.substring(7, token.length());
    }
}
