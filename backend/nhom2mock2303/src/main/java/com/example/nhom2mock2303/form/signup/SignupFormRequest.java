package com.example.nhom2mock2303.form.signup;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SignupFormRequest {
    private String fullname;
    private String username;
    private String password;
    private String phonenumber;
}
