package com.example.nhom2mock2303.dto;

import com.example.nhom2mock2303.entity.Locations;
import com.example.nhom2mock2303.entity.Tour;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class TourLocationDTO {

    private Integer id;

    private Locations locationId;

    private Tour tourId;

//    private Integer locationId;
//
//    private String locationName;
//
//    private String locationInformation;
//
//    private String locationImage;
//
//    private Integer tourId;
//
//    private String tourName;
//
//    private float price;
//
//    private int rate;
//
//    private String tourInformation;
//
//    private String tourImage;
//
//    private String departurePoint;
//
//    private String pointOfDepature;

}
