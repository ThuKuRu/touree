package com.example.nhom2mock2303.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import java.util.List;


@Data
@Table(name = "user", catalog = "mock2303")
@Entity

public class User {
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "full_name", length = 50, nullable = false)
	private String fullName;

	@Column(name = "user_name", length = 100, nullable = false, unique = true)
	private String userName;

	@Column(name = "password", length = 200, nullable = false)
	private String password;

	@Column(name = "phone", length = 20, nullable = false)
	private String phone;

	//thêm thằng role id vào

	@ManyToOne
	@JoinColumn(name = "role_id")
	@JsonIgnore
	private Role role;

	@OneToMany(mappedBy = "userId")
	private List<Oder> oders;

	@OneToMany(mappedBy = "userId")
	private List<FavoriteTour> favoriteTours;

	@OneToMany(mappedBy = "userId")
	private List<FavoriteLocation> favoriteLocations;

}
