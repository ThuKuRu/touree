package com.example.nhom2mock2303.entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.*;

import java.util.Date;
import java.util.List;

//@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tour", catalog = "mock2303")
@Entity

public class Tour {

    @Id
    @Column(name = "tour_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tour_name", length = 255, nullable = false)
    private String tourName;

    @Column(name = "price", nullable = false)
    private float price;

    @Column(name = "rate", nullable = true)
    private int rate;

    @Column(name = "information", length = 8000, nullable = false)
    private String information;

    @Column(name = "image", length = 255, nullable = false)
    private String image;

    @Column(name = "departure_point", length = 100, nullable = false)
    private String departurePoint;

    @Column(name = "point_of_depature", length = 100, nullable = false)
    private String pointOfDepature;

    @Column(name = "date_tour", length = 100, nullable = false)
    private String dateTour;

    @OneToMany(mappedBy = "tourId")
    private List<TourLocation> tourLocations;

    @OneToMany(mappedBy = "tourId")
    private List<Oder> oders;

    @OneToMany(mappedBy = "tourId")
    private List<FavoriteTour> favoriteTours;

//    @Override
//    public String toString() {
//        return "Tour{" +
//                "id=" + id +
//                ", tourName='" + tourName + '\'' +
//                ", price=" + price +
//                ", rate=" + rate +
//                ", information='" + information + '\'' +
//                ", image='" + image + '\'' +
//                ", departurePoint='" + departurePoint + '\'' +
//                ", pointOfDepature='" + pointOfDepature + '\'' +
//                ", dateTour='" + dateTour + '\'' +
//                '}';
//    }
}
