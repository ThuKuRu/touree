package com.example.nhom2mock2303.controller;

import com.example.nhom2mock2303.config.Security.model.UserDetail;
import com.example.nhom2mock2303.config.Security.token.JwtTokenUtils;
import com.example.nhom2mock2303.dto.UserDTO;
import com.example.nhom2mock2303.entity.Role;
import com.example.nhom2mock2303.entity.User;
import com.example.nhom2mock2303.form.Reponse.TokenReponse;
import com.example.nhom2mock2303.form.login.LoginFormRequest;
import com.example.nhom2mock2303.form.signup.SignupFormRequest;
import com.example.nhom2mock2303.service.impl.RoleService;
import com.example.nhom2mock2303.service.impl.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("auth")
@CrossOrigin("*")
public class AuthController {


    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserService iUserService;

    @Autowired
    private RoleService iRoleService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtils jwtTokenUtils;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignupFormRequest signupFormRequest){
        User user = new User();
        user.setFullName(signupFormRequest.getFullname());
        user.setUserName(signupFormRequest.getUsername());
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        String password = bCryptPasswordEncoder.encode(signupFormRequest.getPassword());
        String password = new BCryptPasswordEncoder().encode(signupFormRequest.getPassword());
        user.setPassword(password);
        user.setPhone(signupFormRequest.getPhonenumber());
        Optional<Role> role = (Optional<Role>) (iRoleService.findByid(1));
        user.setRole(role.get());
        User user1 = iUserService.save(user);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginFormRequest loginFormRequest){
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    loginFormRequest.getUsername(), loginFormRequest.getPassword()
            ));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            UserDetail userDetail = (UserDetail) authentication.getPrincipal();
            User user = iUserService.findByUsername(userDetail.getUsername());
            String token = jwtTokenUtils.createToken(userDetail);
            Role role = user.getRole();
            TokenReponse tokenReponse = new TokenReponse(role.getRoleName(),token);
            return ResponseEntity.status(HttpStatus.OK).body(tokenReponse);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        }
    }
    @GetMapping("/profile")
    public ResponseEntity<?> showResults() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return new ResponseEntity<>(userDetails,HttpStatus.OK);
    }

    @PutMapping("/updateProfile")
    public ResponseEntity<?> update(@RequestBody UserDTO userupdate){
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            UserDetail userDetails = (UserDetail) authentication.getPrincipal();
            User user = iUserService.findByUsername(userDetails.getUsername());
//            String password = bCryptPasswordEncoder.encode(userupdate.getPassword());
//            userupdate.setPassword(password);
            modelMapper.map(userupdate,user);
//            iUserService.save(user);
//            userDetails.setUserName(userupdate.getUserName());
            modelMapper.map(user,userDetails);
            iUserService.save(user);
            String token = jwtTokenUtils.createToken(userDetails);
            TokenReponse tokenReponse = new TokenReponse(user.getRole().toString(),token);
            return ResponseEntity.status(HttpStatus.OK).body(tokenReponse);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        }
    }
}
