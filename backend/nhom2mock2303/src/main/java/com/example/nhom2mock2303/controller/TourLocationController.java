package com.example.nhom2mock2303.controller;

import com.example.nhom2mock2303.form.create.CreateFormTourLocation;
import com.example.nhom2mock2303.form.update.UpdateFormTourLocation;
import com.example.nhom2mock2303.service.ITourLocationService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Data
@RequestMapping("tourlocation")
@CrossOrigin("*")
public class TourLocationController {
    @Autowired
    private ITourLocationService tourLocationService;

    @GetMapping("getalltourlocation")
    public ResponseEntity<?> getAllTourLoation() {
        return new ResponseEntity<>(tourLocationService.getAllTourLocations(), HttpStatus.OK);
    }

    @GetMapping("getpagetourlocation")
    public ResponseEntity<?> getPageTourLocation(Pageable pageable) {
        return new ResponseEntity<>(tourLocationService.getPageTourLocations(pageable), HttpStatus.OK);
    }

    @GetMapping("gettoursbylocation/{id}")
    public ResponseEntity<?> getToursByLocation(@PathVariable Integer id) {
        return new ResponseEntity<>(tourLocationService.getToursByLocation(id), HttpStatus.OK);
    }

    @DeleteMapping("deletetourlocation/{id}")
    public ResponseEntity<?> deleteTourLocation(@PathVariable Integer id) {
        return new ResponseEntity<>( tourLocationService.deleteTourLocation(id), HttpStatus.OK);
    }

    @PostMapping("addtourlocation")
    public ResponseEntity<?> addTourLocation(@RequestBody CreateFormTourLocation createFormTourLocation) {
        return new ResponseEntity<>( tourLocationService.addTourLocation(createFormTourLocation), HttpStatus.OK);
    }

    @PutMapping("updatetourlocation/{id}")
    public ResponseEntity<?> updateTourLocation(@PathVariable Integer id, @RequestBody UpdateFormTourLocation updateFormTourLocation){
        return new ResponseEntity<>(tourLocationService.updateTourLocation(id, updateFormTourLocation), HttpStatus.OK);
    }
}
