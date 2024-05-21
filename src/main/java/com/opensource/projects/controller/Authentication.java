package com.opensource.projects.controller;

import com.opensource.projects.modal.auth_modal.AuthenticationResponseModal;
import com.opensource.projects.modal.auth_modal.LoginRequestModal;
import com.opensource.projects.modal.auth_modal.RegisterRequestModal;
import com.opensource.projects.modal.roles.Role;
import com.opensource.projects.service.AuthService;
import com.opensource.projects.service.JsonService;
import com.opensource.projects.service.user_service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import static com.opensource.projects.modal.Error.*;

@RestController
@RequestMapping("/v1/auth")
public class Authentication {

    @Autowired
    AuthService authService;

    @Autowired
    UserServiceImpl userService;

    @Autowired
    JsonService jsonService;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRequestModal registerRequestModal){
       if(userService.doesUserEmailExist(registerRequestModal.getEmail())){
           return ResponseEntity
                   .status(403)
                   .contentType(MediaType.APPLICATION_JSON)
                   .body(jsonService.jsonError(USER_ALREADY_EXISTS));
       }
       else {
           String token = authService.register(registerRequestModal, Role.MEMBER);
           return ResponseEntity.ok(AuthenticationResponseModal.builder().token(token).build());
       }
    }
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestModal loginRequestModal){
        AuthenticationResponseModal authResponse = new AuthenticationResponseModal();
        try{
            if(!userService.doesUserEmailExist(loginRequestModal.getEmail())){
                return ResponseEntity
                        .status(404)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(jsonService.jsonError(USER_NOT_FOUND));
            }
            authResponse = authService.login(loginRequestModal);

        } catch (AuthenticationException e){
            ResponseEntity
                    .status(401)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(jsonService.jsonError(INCORRECT_EMAIL_AND_PASSWORD));
        }
        return ResponseEntity.ok(authResponse);
    }
}
