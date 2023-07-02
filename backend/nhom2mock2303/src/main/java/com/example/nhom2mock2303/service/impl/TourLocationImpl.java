package com.example.nhom2mock2303.service.impl;

import com.example.nhom2mock2303.entity.TourLocation;
import com.example.nhom2mock2303.repository.ITourLocationRepository;
import com.example.nhom2mock2303.service.ITourLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TourLocationImpl implements ITourLocationService {
	
	@Autowired
	private ITourLocationRepository tourLocationRepo;
	
	@Override
	public TourLocation getTourLocationByID(Integer id) {
		return tourLocationRepo.findById(id).get();
	}
}
