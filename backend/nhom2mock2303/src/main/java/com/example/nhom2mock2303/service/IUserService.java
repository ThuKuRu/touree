package com.example.nhom2mock2303.service;

import com.example.nhom2mock2303.config.Security.model.UserDetail;
import com.example.nhom2mock2303.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserService extends JpaRepository<User, Integer> {
    User findByUserName(String username);
}
