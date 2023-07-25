package com.example.nhom2mock2303.service;

import com.example.nhom2mock2303.dto.LocationsDto;
import com.example.nhom2mock2303.dto.TourDTO;
import com.example.nhom2mock2303.dto.TourLocationDTO;
import com.example.nhom2mock2303.entity.TourLocation;
import com.example.nhom2mock2303.form.CreateFormTourLocation;
import com.example.nhom2mock2303.form.UpdateFormTourLocation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ITourLocationService {
	
	List<TourLocationDTO> getAllTourLocations();

	Page<TourLocationDTO> getPageTourLocations(Pageable pageable);

	String deleteTourLocation(Integer id);

	String updateTourLocation(Integer id, UpdateFormTourLocation updateFormTourLocation);

	String addTourLocation( CreateFormTourLocation createFormTourLocation);

	List<TourDTO>  getToursByLocation (Integer locationId);
}
