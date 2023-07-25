package com.example.nhom2mock2303.entity;

import javax.persistence.*;
import lombok.Data;
import lombok.ToString;

@Data
@Table(name = "tour_location", catalog = "mock2303")
@Entity

public class TourLocation {

    @Id
    @Column(name = "tour_location_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @ToString.Exclude
    @ManyToOne
//    @MapsId("location_id")
    @JoinColumn(name = "location_id")
    private  Locations locationId;
    //

    @ToString.Exclude
    @ManyToOne
//    @MapsId("tour_id")
    @JoinColumn(name = "tour_id")
    private Tour tourId;
}
