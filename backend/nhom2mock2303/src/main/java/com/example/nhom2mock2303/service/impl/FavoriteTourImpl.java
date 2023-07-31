package com.example.nhom2mock2303.service.impl;

import com.example.nhom2mock2303.entity.FavoriteTour;

import com.example.nhom2mock2303.repository.IFavoriteTourRepository;
import com.example.nhom2mock2303.service.IFavoriteTourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class
FavoriteTourImpl implements IFavoriteTourService {
	
	@Autowired
	private IFavoriteTourRepository favoriteTourRepo;
	
	@Override
	public FavoriteTour getFavoriteTourByID(Integer id) {
		return favoriteTourRepo.findById(id).get();
	}
}
