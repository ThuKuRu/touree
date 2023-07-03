package com.example.nhom2mock2303.controller;

import com.example.nhom2mock2303.form.CreateFormLocation;
import com.example.nhom2mock2303.form.UpdateFormLocation;
import com.example.nhom2mock2303.service.ILocationService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Data
@RequestMapping("location")
@CrossOrigin("*")
public class LocationController {

    @Autowired
     private  ILocationService locationService;

    @GetMapping("getlocationpage")
    public ResponseEntity<?> getpage(Pageable pageable) {
        return new ResponseEntity<>(locationService.getPageLocations(pageable), HttpStatus.OK);
    }

    @GetMapping("getlocationbyid/{id}")
    public ResponseEntity<?> getLocationById(@PathVariable Integer id) {
        return new ResponseEntity<>(locationService.getLocationbyId(id), HttpStatus.OK);
    }

    @PostMapping("addlocation")
    public ResponseEntity<?> addlocation(@RequestBody CreateFormLocation createFormLocation) {
        return new ResponseEntity<>( locationService.addLocation(createFormLocation), HttpStatus.OK);
    }

    @DeleteMapping("deletelocation/{id}")
    public ResponseEntity<?> deleteLocation(@PathVariable Integer id) {
        return new ResponseEntity<>( locationService.deletelocation(id), HttpStatus.OK);
    }

    @PutMapping("updatelocation/{id}")
    public ResponseEntity<?> updateLocation(@PathVariable Integer id, @RequestBody UpdateFormLocation updateFormLocation){
        return new ResponseEntity<>(locationService.updateLocation(id,updateFormLocation), HttpStatus.OK);
    }

    @GetMapping("searchlocation")
    public ResponseEntity<?> searchlocation(@RequestParam String data, Pageable pageable) {
        return new ResponseEntity<>(locationService.searchLocations(data,pageable), HttpStatus.OK);
    }
}
