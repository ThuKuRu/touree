package com.example.nhom2mock2303.form.login;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginFormRequest {
    private String username;
    private String password;
}
