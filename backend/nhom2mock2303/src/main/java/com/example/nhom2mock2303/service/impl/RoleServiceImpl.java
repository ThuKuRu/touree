package com.example.nhom2mock2303.service.impl;

import com.example.nhom2mock2303.entity.Role;
import com.example.nhom2mock2303.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private IRoleService iRoleService;

    @Override
    public Optional<Role> findByid(Integer id){
        return iRoleService.findById(id);
    }
}
