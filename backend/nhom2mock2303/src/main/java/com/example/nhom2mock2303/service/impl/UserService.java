package com.example.nhom2mock2303.service.impl;

import com.example.nhom2mock2303.config.Security.model.UserDetail;
import com.example.nhom2mock2303.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

public interface UserService extends UserDetailsService {
    public UserDetail loadUserByUsername(String username);
    public User save(User user);
    public User findByUsername(String username);
}
