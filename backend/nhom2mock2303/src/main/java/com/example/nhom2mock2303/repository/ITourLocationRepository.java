package com.example.nhom2mock2303.repository;


import com.example.nhom2mock2303.entity.TourLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ITourLocationRepository extends JpaRepository<TourLocation, Integer> {

    @Query(value = "SELECT * FROM tour_location a WHERE a.location_id = :id", nativeQuery=true)
    List<TourLocation> findByLocationId(@Param("id")Integer lid);

    @Query(value = "SELECT * FROM tour_location a WHERE a.tour_id = :tourId", nativeQuery=true)
    List<TourLocation> findByTourId(@Param("tourId")Integer tourId);
}
