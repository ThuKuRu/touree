package com.example.nhom2mock2303.service.impl;

import com.example.nhom2mock2303.dto.TourDTO;
import com.example.nhom2mock2303.dto.TourLocationDTO;
import com.example.nhom2mock2303.entity.Locations;
import com.example.nhom2mock2303.entity.Tour;
import com.example.nhom2mock2303.entity.TourLocation;
import com.example.nhom2mock2303.form.create.CreateFormTourLocation;
import com.example.nhom2mock2303.form.update.UpdateFormTourLocation;
import com.example.nhom2mock2303.repository.ILocationRepository;
import com.example.nhom2mock2303.repository.ITourLocationRepository;
import com.example.nhom2mock2303.repository.ITourRepository;
import com.example.nhom2mock2303.service.ITourLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TourLocationImpl implements ITourLocationService {
	
	@Autowired
	private ITourLocationRepository tourLocationRepo;

	@Autowired
	private ILocationRepository locationRepo;

	@Autowired
	private ITourRepository tourRepo;
	
	@Override
	public TourLocation getTourLocationByID(Integer id) {
		return tourLocationRepo.findById(id).get();
	}
	@Override
	public List<TourLocationDTO> getAllTourLocations() {
		List<TourLocation> tourLocations = tourLocationRepo.findAll();
		List<TourLocationDTO> dto = new ArrayList<>();
		for (int i = 0; i < tourLocations.size(); i++) {
			TourLocationDTO tourLocationDTO = new TourLocationDTO();
			tourLocationDTO.setId(tourLocations.get(i).getId());
			tourLocationDTO.setLocationId(tourLocations.get(i).getLocationId());
			tourLocationDTO.setTourId(tourLocations.get(i).getTourId());
			dto.add(tourLocationDTO);
		}
		return dto;
	}

	@Override
	public Page<TourLocationDTO> getPageTourLocations(Pageable pageable) {
		List<TourLocation> tourLocations = tourLocationRepo.findAll();
		List<TourLocationDTO> tourLocationDTOS = new ArrayList<>();
		for (int i = 0; i < tourLocations.size(); i++) {
			TourLocationDTO tourLocationDTO = new TourLocationDTO();
			tourLocationDTO.setId(tourLocations.get(i).getId());
			tourLocationDTO.setLocationId(tourLocations.get(i).getLocationId());
			tourLocationDTO.setTourId(tourLocations.get(i).getTourId());
			tourLocationDTOS.add(tourLocationDTO);
		}

		// convert list to page
		final int start = (int)pageable.getOffset();
		final int end = Math.min((start + pageable.getPageSize()), tourLocationDTOS.size());
		Page<TourLocationDTO> dtoPages = new PageImpl<>(tourLocationDTOS.subList(start, end), pageable, tourLocationDTOS.size());
		return dtoPages;
	}

	@Override
	public String deleteTourLocation(Integer id) {
		if (!tourLocationRepo.findById(id).isPresent()){
			return "Xoá không thành công id:"+ id;
		}
		tourLocationRepo.deleteById(id);
		return "Xoá thành công id:"+ id;
	}
	@Override
	public List<TourDTO>  getToursByLocation(Integer locationId) {

		List<TourLocation> listtl = tourLocationRepo.findByLocationId(locationId);
		List<TourDTO> listTourLocations = new ArrayList<>();
		for (int i = 0; i < listtl.size(); i++) {
			TourDTO dto = new TourDTO();
			dto.setId(listtl.get(i).getTourId().getId());
			dto.setTourName(listtl.get(i).getTourId().getTourName());
			dto.setPrice(listtl.get(i).getTourId().getPrice());
			dto.setRate(listtl.get(i).getTourId().getRate());
			dto.setInformation(listtl.get(i).getTourId().getInformation());
			dto.setImage(listtl.get(i).getTourId().getImage());
			dto.setDeparturePoint(listtl.get(i).getTourId().getDeparturePoint());
			dto.setPointOfDepature(listtl.get(i).getTourId().getPointOfDepature());
			dto.setDateTour(listtl.get(i).getTourId().getDateTour());
			listTourLocations.add(dto);
		}

		return listTourLocations;
	}
	@Override
	public String updateTourLocation(Integer id, UpdateFormTourLocation updateFormTourLocation) {
		Locations location = locationRepo.findById(updateFormTourLocation.getLocationId()).get();
		Tour tour = tourRepo.findById(updateFormTourLocation.getTourId()).get();

		TourLocation tourLocation = tourLocationRepo.findById(id).get();
		System.out.println(tourLocation);
		tourLocation.setLocationId(location);
		tourLocation.setTourId(tour);
		tourLocationRepo.save(tourLocation);
		System.out.println(tourLocation);
		return "Cập nhập thành công";
	}
	@Override
	public String addTourLocation(CreateFormTourLocation createFormTourLocation) {
		Locations location = locationRepo.findById(createFormTourLocation.getLocationId()).get();
		Tour tour = tourRepo.findById(createFormTourLocation.getTourId()).get();
		TourLocation tl = new TourLocation();
		tl.setLocationId(location);
		tl.setTourId(tour);
		tourLocationRepo.save(tl);
		return "";
	}
}
