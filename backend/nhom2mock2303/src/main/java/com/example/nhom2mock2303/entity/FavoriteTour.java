package com.example.nhom2mock2303.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "favorite_tour", catalog = "mock2303")
@Entity
public class FavoriteTour {

    @Id
    @Column(name = "favorite_tour_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @MapsId("tour_id")
    @JoinColumn(name = "tour_id")
    private Tour tourId;

    @ManyToOne
    @MapsId("user_id")
    @JoinColumn(name = "user_id")
    private User userId;
}
