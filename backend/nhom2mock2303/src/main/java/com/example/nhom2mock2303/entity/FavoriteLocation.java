package com.example.nhom2mock2303.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "favorite_location", catalog = "mock2303")
@Entity

public class FavoriteLocation {

    @Id
    @Column(name = "favorite_location_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @MapsId("location_id")
    @JoinColumn(name = "location_id")
    private Locations locationId;

    @ManyToOne
    @MapsId("user_id")
    @JoinColumn(name = "user_id")
    private User userId;
}
