package com.opensource.projects.service.user_service;

import com.opensource.projects.modal.User;

import java.util.Optional;

public interface UserService {
    public User findUserByEmail(String email);
    public void save(User user);
}
