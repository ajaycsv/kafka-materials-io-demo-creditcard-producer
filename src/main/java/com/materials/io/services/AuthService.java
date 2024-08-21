package com.materials.io.services;

import com.materials.io.model.LoginResponse;
import com.materials.io.security.JwtIssuer;
import com.materials.io.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final JwtIssuer jwtIssuer;
    private final AuthenticationManager authenticationManager;

    public LoginResponse attemptLogin(String email, String password) {
//        AuthenticationManager authentication = (AuthenticationManager) authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(email, password)
//        );
//        SecurityContextHolder.getContext().setAuthentication((Authentication) authentication);
//        UserPrincipal principal = (UserPrincipal) ((Authentication) authentication).getPrincipal();

        String token = jwtIssuer.issue(JwtIssuer.Request.builder()
                .userId(1001L)
                .email(email)
                .roles(Arrays.asList("ADMIN", "USER"))
                .build());

        return LoginResponse.builder()
                .token(token)
                .build();
    }
}