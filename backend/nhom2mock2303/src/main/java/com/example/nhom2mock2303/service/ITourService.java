package com.example.nhom2mock2303.service;

import com.example.nhom2mock2303.entity.Tour;
import com.example.nhom2mock2303.form.create.TourFormForCreating;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ITourService {
	Page<Tour> getAllTour(Pageable pageable, String search);
	Optional<Tour> getTourById(Integer id);
	List<Tour> getListAll();
	
	Tour getAllTourByID(Integer id);
	
	List<Tour> getTourByTourName(String tourname);
	
	void deleteTourByID(Integer id);
	
	void createTour(Tour tour);
	
	void createNewTour(TourFormForCreating tourFormForCreating);
	// tìm kiếm tour điểm đi
	List<Tour> findByDeparturePoint(String departurePoint);
	// tím kiếm tour điểm đến
	List<Tour> findByPointOfDepature(String pointOfDepature);
	// tìm kiếm theo thời gian tour
	List<Tour> findByDateTour(String date);
	
	List<Tour> findByPrice (Integer price);
	
	List<Tour> findByRate (Integer price);
	
//	List<Tour> findByBetweenPrice (Integer price1, Integer price2 );
//	List<Tour> findByTourName(String name);
}
