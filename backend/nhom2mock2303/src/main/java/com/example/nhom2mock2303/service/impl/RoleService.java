package com.example.nhom2mock2303.service.impl;

import com.example.nhom2mock2303.entity.Role;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface RoleService {
    Optional<Role> findByid(Integer id);
}
