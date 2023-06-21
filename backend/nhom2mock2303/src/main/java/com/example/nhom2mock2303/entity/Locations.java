package com.example.nhom2mock2303.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Table(name = "locations", catalog = "mock2303")
@Entity

public class Locations {

	@Id
	@Column(name = "location_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "location_name", length = 50, nullable = false)
	private String locationName;

	@Column(name = "information", length = 100, nullable = false)
	private String information;

	@Column(name = "image", length = 100, nullable = false)
	private String image;

	@OneToMany(mappedBy = "locationId")
	private List<TourLocation> tourLocations;

	@OneToMany(mappedBy = "locationId")
	private List<FavoriteLocation> favoriteLocations;
}
