package com.example.nhom2mock2303.service.impl;

import com.example.nhom2mock2303.entity.Tour;
import com.example.nhom2mock2303.entity.TourLocation;
import com.example.nhom2mock2303.form.TourFormForCreating;
import com.example.nhom2mock2303.repository.ITourLocationRepository;
import com.example.nhom2mock2303.repository.ITourRepository;
import com.example.nhom2mock2303.service.ITourService;
import com.example.nhom2mock2303.speccification.TourSpeccification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class TourServiceImpl implements ITourService {
	@Autowired
	private ITourRepository tourRepository;

	@Autowired
	private ITourLocationRepository tourLocationRepo;
	
	@Override
	public Page<Tour> getAllTour(Pageable pageable, String search) {
		Specification<Tour> whereTour = null;
		if (!StringUtils.isEmpty(search)) {
			TourSpeccification tourNameSpeccification = new TourSpeccification("tourName", "LIKE", search);
			TourSpeccification departurePointSpeccification = new TourSpeccification("departurePoint", "LIKE", search);
			TourSpeccification pointOfDepatureSpeccification = new TourSpeccification("pointOfDepature", "LIKE", search);
			whereTour = Specification.where(tourNameSpeccification).or(departurePointSpeccification)
					.or(pointOfDepatureSpeccification);
		}
		return tourRepository.findAll(whereTour, pageable);
	}
	
	@Override
	public List<Tour> getListAll() {
		List<Tour> tourListList = tourRepository.findAll();
		return tourListList;
	}
	
	@Override
	public Tour getAllTourByID(Integer id) {
		return tourRepository.getById(id);
	}
	
	@Override
	public List<Tour> getTourByTourName(String tourname) {
		return tourRepository.findByTourName(tourname);
	}
	
	@Override
	public List<Tour> findByDeparturePoint(String departurePoint) {
		return tourRepository.findByDeparturePoint(departurePoint);
	}
	
	@Override
	public List<Tour> findByPointOfDepature(String pointOfDepature) {
		return tourRepository.findByPointOfDepature(pointOfDepature);
	}
	@Override
	public List<Tour> findByPrice(Integer price) {
		return null;
	}
	
	@Override
	public List<Tour> findByRate(Integer price) {
		return tourRepository.findByRate(price);
	}
	
//	@Override
//	public List<Tour> findByBetweenPrice(Integer price1, Integer price2) {
//		return tourRepository.findByDateTour(price1, price2);
//	}
	
	@Override
	public List<Tour> findByDateTour(String date) {
		return tourRepository.findByDateTour(date);
	}
	
	@Override
	public void deleteTourByID(Integer id) {
		List<TourLocation> listtl = tourLocationRepo.findByTourId(id);
		for (int i = 0; i < listtl.size(); i++){
			tourLocationRepo.deleteById(listtl.get(i).getId());
		}
		tourRepository.deleteById(id);
	}
	
	@Override
	public void createTour(Tour tour) {
		tourRepository.save(tour);
	}
	
	@Override
	public void createNewTour(TourFormForCreating tourFormForCreating) {
		Tour tour = new Tour();
		tour.setTourName(tourFormForCreating.getTourName());
		tour.setDateTour(tourFormForCreating.getDateTour());
		tour.setPrice(tourFormForCreating.getPrice());
		tour.setRate(tourFormForCreating.getRate());
		tour.setInformation(tourFormForCreating.getInformation());
		tour.setImage(tourFormForCreating.getImage());
		tour.setDeparturePoint(tourFormForCreating.getDeparturePoint());
		tour.setDateTour(tourFormForCreating.getDateTour());
		tour.setPointOfDepature(tourFormForCreating.getPointOfDepature());
		tourRepository.save(tour);
	}
	
	
}
