package com.example.nhom2mock2303.entity;

import javax.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Table(name = "oder" , catalog = "mock2303")
@Entity
public class Oder {
    @Id
    @Column(name = "oder_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
//    @MapsId("tour_id")
    @JoinColumn(name = "tour_id")
    private Tour tourId;

    @ManyToOne
    @MapsId("user_id")
    @JoinColumn(name = "user_id")
    private User userId;

    @Column(name = "oder_price", nullable = false)
    private float oderPrice;

    @Column(name = "date_oder")
    private Date dateOder;
}
