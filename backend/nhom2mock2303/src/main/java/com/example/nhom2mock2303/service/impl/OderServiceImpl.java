package com.example.nhom2mock2303.service.impl;

import com.example.nhom2mock2303.entity.Oder;
import com.example.nhom2mock2303.repository.IOderRepository;
import com.example.nhom2mock2303.service.IOderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OderServiceImpl  implements IOderService {
	
	@Autowired
	private IOderRepository oderRepo;
	
	@Override
	public Oder getOderByID(Integer id) {
		return oderRepo.findById(id).get();
	}
}
