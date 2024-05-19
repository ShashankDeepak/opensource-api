package com.opensource.projects.service;

import com.opensource.projects.modal.User;
import com.opensource.projects.modal.auth_modal.RegisterRequestModal;
import com.opensource.projects.service.user_service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class AuthService {
    @Autowired
    UserService userService;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtService jwtService;

    @Autowired
    AuthenticationManager authenticationManager;

    public String register(RegisterRequestModal registerRequestModal) throws InterruptedException{
        User user = User.builder()
                .email(registerRequestModal.getEmail())
                .password(passwordEncoder.encode(registerRequestModal.getPassword()))
                .role(registerRequestModal.getRole())
                .build();
        String jwtToken = jwtService.generateToken(user);
        saveUser(user);
        return jwtToken;
    }

    @Async
    void saveUser(User user) throws InterruptedException {
        userService.save(user);
    }
}
