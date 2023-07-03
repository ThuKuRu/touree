package com.example.nhom2mock2303.repository;


import com.example.nhom2mock2303.entity.Locations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILocationRepository extends JpaRepository<Locations,Integer> {

//    @Query("FROM Locations WHERE locationName LIKE %:searchData%")
//    Page<Locations> searchLocations(String searchData, Pageable pageable);
    Page<Locations> findAllByLocationName(String locationName, Pageable pageable);
}
