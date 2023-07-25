package com.example.nhom2mock2303.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

//@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "locations", catalog = "mock2303")
@Entity

public class Locations {

	@Id
	@Column(name = "location_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "location_name", length = 100, nullable = false)
	private String locationName;

	@Column(name = "information",length = 8000,  nullable = false)
	private String information;

	@Column(name = "image",length = 255,  nullable = false)
	private String image;

	@OneToMany(mappedBy = "locationId")
	private List<TourLocation> tourLocations;

	@OneToMany(mappedBy = "locationId")
	private List<FavoriteLocation> favoriteLocations;

//	@Override
//	public String toString() {
//		return "Locations{" +
//				"id=" + id +
//				", locationName='" + locationName + '\'' +
//				", information='" + information + '\'' +
//				", image='" + image +
//				'}';
//	}
}
