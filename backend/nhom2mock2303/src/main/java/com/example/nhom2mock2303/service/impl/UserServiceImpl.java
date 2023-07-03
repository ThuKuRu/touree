package com.example.nhom2mock2303.service.impl;

import com.example.nhom2mock2303.config.Security.model.UserDetail;
import com.example.nhom2mock2303.entity.User;
import com.example.nhom2mock2303.service.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements  UserService {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDetail loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetail userDetails = new UserDetail();
        User user = iUserService.findByUserName(username);
//        BeanUtils.copyProperties(user, userDetails);
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole().getRoleName()));
        userDetails.setGrantedAuthorities(grantedAuthorities);
         modelMapper.map(user,userDetails);
         return userDetails;
    }

    @Override
    public User save(User user) {
        return iUserService.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return iUserService.findByUserName(username);
    }
}
