package com.example.nhom2mock2303.dto;


import javax.persistence.*;

import com.example.nhom2mock2303.entity.FavoriteLocation;
import com.example.nhom2mock2303.entity.FavoriteTour;
import com.example.nhom2mock2303.entity.Oder;
import com.example.nhom2mock2303.entity.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import java.util.List;


@Data
public class UserDTO {

    private String fullName;

    private String userName;

//    private String password;

    private String phoneNumber;

}

