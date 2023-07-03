package com.example.nhom2mock2303.service;

import com.example.nhom2mock2303.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRoleService extends JpaRepository<Role, Integer> {
    public Optional<Role> findById(Integer id);
}
