package com.example.nhom2mock2303.security;
import com.example.nhom2mock2303.dto.LocationsDto;
import com.example.nhom2mock2303.entity.Locations;
import com.example.nhom2mock2303.form.CreateFormLocation;
import com.example.nhom2mock2303.form.UpdateFormLocation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ILocationService {

    Page<LocationsDto> getPageLocations(Pageable pageable);

    LocationsDto getLocationbyId(Integer id);

    String addLocation(CreateFormLocation createFormLocation);

    String deletelocation(Integer id);

    String updateLocation(Integer id,UpdateFormLocation updateFormLocation);

    Page<LocationsDto> searchLocations(String data, Pageable pageable);


}
