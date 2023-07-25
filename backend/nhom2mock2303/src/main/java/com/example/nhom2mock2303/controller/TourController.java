package com.example.nhom2mock2303.controller;


import com.example.nhom2mock2303.dto.TourDTO;
import com.example.nhom2mock2303.entity.Tour;
import com.example.nhom2mock2303.form.create.TourFormForCreating;
import com.example.nhom2mock2303.form.update.TourFormForUpdateting;
import com.example.nhom2mock2303.service.IFavoriteTourService;
import com.example.nhom2mock2303.service.IOderService;
import com.example.nhom2mock2303.service.ITourLocationService;
import com.example.nhom2mock2303.service.ITourService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@RestController
@RequestMapping(value = "tour")
@CrossOrigin("*")
public class TourController {
	
	@Autowired
	private ITourService tourService;
	@Autowired
	private IFavoriteTourService favoriteTourService;
	@Autowired
	private IOderService oderService;
	@Autowired
	private ITourLocationService tourLocationService;
	
	@Autowired
	private ModelMapper mapper;
	
	@GetMapping("search")
	public ResponseEntity<?> getTourByTourName(@RequestParam(name = "tourName") String tourname) {
		List<Tour> tours = tourService.getTourByTourName(tourname);
		if (tours != null) {
			List<TourDTO> tourDTOs = mapper.map(tours, new TypeToken<List<TourDTO>>() {
			}.getType());
			return new ResponseEntity<>(tourDTOs, HttpStatus.OK);
		}
		return new ResponseEntity<>("nullnable", HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getTourById(@PathVariable(name = "id") Integer id) {
		Optional<Tour> tour = tourService.getTourById(id);
		return new ResponseEntity<>(tour, HttpStatus.OK);
	}
	// Delete Tour By ID
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> deleteTourByID(@PathVariable(name = "id") Integer id) {
		tourService.deleteTourByID(id);
		return new ResponseEntity<>("Delete Tour Succes", HttpStatus.OK);
	}
	
	// Update Tour By ID
	@PutMapping("update/{id}")
	public ResponseEntity<?> updateTour(@PathVariable(name = "id") Integer id,
	                                    @RequestBody TourFormForUpdateting tourFormForUpdateting) {
		Tour tour = tourService.getAllTourByID(id);
		tourService.createTour(tour);
		return new ResponseEntity<>("update succes", HttpStatus.OK);
	}

	// Create New Tour
	@PostMapping("create")
	public ResponseEntity<?> createDepartment(@RequestBody TourFormForCreating tourFormForCreating) {
		tourService.createNewTour(tourFormForCreating);
		return new ResponseEntity<>("Craete New Tour Succes", HttpStatus.OK);
	}

	//Create New Tour By Model Mapper
	@PostMapping("/createNewTour")
	public ResponseEntity<?> createNewTour(@RequestBody TourFormForCreating tourFormForCreating) {
		Tour tour = mapper.map(tourFormForCreating, Tour.class);
//		tour.setFavoriteTours((List<FavoriteTour>) favoriteTourService.getFavoriteTourByID(tourFormForCreating.getTourLocationID()));
//		tour.setOders((List<Oder>) oderService.getOderByID(tourFormForCreating.getOderID()));
//		tour.setTourLocations((List<TourLocation>) tourLocationService.getTourLocationByID(tourFormForCreating.getTourLocationID()));
		tourService.createTour(tour);
		return new ResponseEntity<>("create tour succes", HttpStatus.OK);
	}
	
	// Get All Tour Model Mapper
	@GetMapping("/getAllTour")
	public ResponseEntity<?> getAllTour() {
		List<Tour> ls = tourService.getListAll();
		List<TourDTO> tourDTOs = new ArrayList<>();
		for (Tour tour : ls) {
			TourDTO tourDTO = mapper.map(tour, TourDTO.class);
			tourDTOs.add(tourDTO);
		}
		return new ResponseEntity<>(tourDTOs, HttpStatus.OK);
	}
	
	// Get All Tour By PageaBle
	@GetMapping("/getAllTourPageable")
	public ResponseEntity<?> getAllTourPage(Pageable pageable, @RequestParam(required = false) String search) {
		// Lấy dữ liệu theo phân trang
		Page<Tour> ls_Page = tourService.getAllTour(pageable, search);
		Page<TourDTO> tourDTOs = ls_Page.map(new Function<Tour, TourDTO>() {
			@Override
			public TourDTO apply(Tour tour) {
				TourDTO tourDTO = mapper.map(tour, TourDTO.class);
//				tourDTO.setFavoriteTours(tour.getFavoriteTours().get);
//				tourDTO.set(account.getPosition().getName().toString());
				return tourDTO;
			}
		});
		return new ResponseEntity<>(tourDTOs, HttpStatus.OK);
	}
	
	// Get All Thuần
	@GetMapping("/getListTour")
	public ResponseEntity<?> getAll() {
		List<Tour> tourListList = tourService.getListAll();
		return new ResponseEntity<>(tourListList, HttpStatus.OK);
	}
	
	@GetMapping("search/findByDeparturePoint")
	public ResponseEntity<?> findByDeparturePoint(@RequestParam(name = "departurePoint") String departurePoint) {
		List<Tour> tours = tourService.findByDeparturePoint(departurePoint);
		if (tours !=null) {
			List<TourDTO> tourDTOs = mapper.map(tours, new TypeToken<List<TourDTO>>() {
			}.getType());
			return new ResponseEntity<>(tourDTOs, HttpStatus.OK);
		}
		return new ResponseEntity<>("nullnable", HttpStatus.OK);
	}
	
	@GetMapping("search/findByPointOfDepature")
	public ResponseEntity<?> findByPointOfDepature(@RequestParam(name = "pointOfDepature") String pointOfDepature) {
		List<Tour> tours = tourService.findByPointOfDepature(pointOfDepature);
		if (tours !=null) {
			List<TourDTO> tourDTOs = mapper.map(tours, new TypeToken<List<TourDTO>>() {
			}.getType());
			return new ResponseEntity<>(tourDTOs, HttpStatus.OK);
		}
		return new ResponseEntity<>("nullnable", HttpStatus.OK);
	}
	
	@GetMapping("search/findByDateTour")
	public ResponseEntity<?> findByDateTour(@RequestParam(name = "dateTour") String dateTour) {
		List<Tour> tours = tourService.findByDateTour(dateTour);
		if (tours !=null) {
			List<TourDTO> tourDTOs = mapper.map(tours, new TypeToken<List<TourDTO>>() {
			}.getType());
			return new ResponseEntity<>(tourDTOs, HttpStatus.OK);
		}
		return new ResponseEntity<>("nullnable", HttpStatus.OK);
	}
	
	@GetMapping("search/findByRate")
	public ResponseEntity<?> findByRate(@RequestParam(name = "rate") Integer rate) {
		List<Tour> tours = tourService.findByRate(rate);
		if (tours !=null) {
			List<TourDTO> tourDTOs = mapper.map(tours, new TypeToken<List<TourDTO>>() {
			}.getType());
			return new ResponseEntity<>(tourDTOs, HttpStatus.OK);
		}
		return new ResponseEntity<>("nullnable", HttpStatus.OK);
	}
}
