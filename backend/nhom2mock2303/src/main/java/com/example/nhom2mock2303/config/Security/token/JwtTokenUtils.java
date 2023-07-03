package com.example.nhom2mock2303.config.Security.token;

import com.example.nhom2mock2303.config.Security.model.UserDetail;
import com.example.nhom2mock2303.service.IUserService;
import com.example.nhom2mock2303.service.impl.UserService;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.SignatureAlgorithm;
import netscape.javascript.JSObject;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Jwts;

import java.util.Date;



@Component
public class JwtTokenUtils {

    @Autowired
    private UserService userService;

    public static Integer expiration = 7 * 24 * 60 * 60 * 1000;
    public static String secret = "BvPHGM8C0ia4uOuxxqPD5DTbWC9F9TWvPStp3pb7ARo0oK2mJ3pd3YG4lxA9i8bj6OTbadwezxgeEByY";
    public static String tokenPrefix = "Bearer";

    public String createToken(UserDetail userDetail){
        String token = Jwts.builder()
                        .setId(userDetail.getId().toString())
                        .setSubject(userDetail.getUsername())
                        .setIssuer("NMS")
                        .setExpiration(new Date(System.currentTimeMillis() + expiration))
                        .signWith(SignatureAlgorithm.HS256, secret)
                        .claim("authorities", userDetail.getAuthorities())
                        .compact();
        return token;
    }

    public UserDetail parseToken(String token){
        token = token.substring(tokenPrefix.length()).trim();
        String username = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
        System.out.println("Username: " + username);
        return userService.loadUserByUsername(username);
    }


}
