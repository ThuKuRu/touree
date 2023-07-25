package com.example.nhom2mock2303.entity;

import javax.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@Table(name = "locations", catalog = "mock2303")
@Entity
@ToString
public class Locations {

	@Id
	@Column(name = "location_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "location_name", length =255, nullable = false)
	private String locationName;

	@Column(name = "information", length = 8000, nullable = false)
	private String information;

	@Column(name = "image", length = 255, nullable = false)
	private String image;

	@ToString.Exclude
	@OneToMany(mappedBy = "locationId")
	private List<TourLocation> tourLocations;

	@ToString.Exclude
	@OneToMany(mappedBy = "locationId")
	private List<FavoriteLocation> favoriteLocations;
}
