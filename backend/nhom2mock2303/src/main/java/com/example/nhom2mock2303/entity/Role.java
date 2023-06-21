package com.example.nhom2mock2303.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Table(name = "role" , catalog = "mock2303")
@Entity
public class Role {
	
	@Id
	@Column(name = "role_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "role_name", length = 100, nullable = false, unique = true)
	private String roleName;

	@OneToMany(mappedBy = "role")
	private List<User> users;
	
}
