package com.example.nhom2mock2303.form.Reponse;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.security.authentication.jaas.AuthorityGranter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Data
public class TokenReponse {
    @NonNull
    private String role;
    @NonNull
    private String token;
}
