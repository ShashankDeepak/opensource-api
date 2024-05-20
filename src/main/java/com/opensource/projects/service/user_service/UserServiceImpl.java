package com.opensource.projects.service.user_service;

import com.opensource.projects.modal.User;
import com.opensource.projects.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;

    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Override
    public User findUserByEmail(String email){
        User user = userRepository.findUserByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
        return user;
    }

    @Override
    public boolean doesUserEmailExist(String email){
        var user = userRepository.findUserByEmail(email);
        return user.isPresent();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
