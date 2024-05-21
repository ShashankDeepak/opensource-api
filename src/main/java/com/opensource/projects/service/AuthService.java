package com.opensource.projects.service;

import com.opensource.projects.controller.Authentication;
import com.opensource.projects.modal.User;
import com.opensource.projects.modal.auth_modal.AuthenticationResponseModal;
import com.opensource.projects.modal.auth_modal.LoginRequestModal;
import com.opensource.projects.modal.auth_modal.RegisterRequestModal;
import com.opensource.projects.modal.roles.Role;
import com.opensource.projects.service.user_service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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

    public String register(RegisterRequestModal registerRequestModal,Role role) throws UsernameNotFoundException {
        User user = User.builder()
                .email(registerRequestModal.getEmail())
                .password(passwordEncoder.encode(registerRequestModal.getPassword()))
                .role(role)
                .build();
        String jwtToken = jwtService.generateToken(user);
        saveUser(user);
        return jwtToken;
    }

    public AuthenticationResponseModal login(LoginRequestModal loginRequestModal) throws AuthenticationException {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequestModal.getEmail(),
                        loginRequestModal.getPassword()
                )
        );
        User user = userService.findUserByEmail(loginRequestModal.getEmail());
        String jwtToken = jwtService.generateToken(user);
        return AuthenticationResponseModal.builder().token(jwtToken).build();
    }
    @Async
    void saveUser(User user) {
        userService.save(user);
    }
}
