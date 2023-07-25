package com.example.nhom2mock2303.repository;


import com.example.nhom2mock2303.entity.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ITourRepository extends JpaRepository<Tour, Integer>, JpaSpecificationExecutor<Tour> {
	List<Tour> findByTourName(String tourName);
	
	// điểm bắt đầu Tour
	List<Tour> findByDeparturePoint(String departurePoint);
	
	// điểm kết thúc Tour
	List<Tour> findByPointOfDepature(String pointOfDepature);
	
	// tìm kiếm theo thời gian tour
	List<Tour> findByDateTour(String date);
	
	List<Tour> findByPrice (Integer price);
	
	List<Tour> findByRate (Integer price);
	


//	List<Tour> findByTour(String tourName);
}
