package com.example.nhom2mock2303.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tour_location", catalog = "mock2303")
@Entity

public class TourLocation {

    @Id
    @Column(name = "tour_location_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonIgnore
    @ManyToOne
    @MapsId("location_id")
    @JoinColumn(name = "location_id")
    private Locations locationId;

    @JsonIgnore
    @ManyToOne
    @MapsId("tour_id")
    @JoinColumn(name = "tour_id")
    private Tour tourId;

}
