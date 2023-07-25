package com.example.nhom2mock2303.repository;

import com.example.nhom2mock2303.entity.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.nhom2mock2303.entity.Locations;
import com.example.nhom2mock2303.entity.TourLocation;

import java.util.List;

@Repository
public interface ITourLocationRepository extends JpaRepository<TourLocation, Integer>{

//    List<TourLocation> findByLocationId(Locations location);

    @Query(value = "SELECT * FROM tour_location a WHERE a.location_id = :id", nativeQuery=true)
    List<TourLocation> findByLocationId(@Param("id")Integer lid);

    @Query(value = "SELECT * FROM tour_location a WHERE a.tour_id = :tourId", nativeQuery=true)
    List<TourLocation> findByTourId(@Param("tourId")Integer tourId);


}
