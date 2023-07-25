
package com.example.nhom2mock2303.service;
import com.example.nhom2mock2303.dto.LocationsDto;


import com.example.nhom2mock2303.form.create.CreateFormLocation;
import com.example.nhom2mock2303.form.update.UpdateFormLocation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Component;

@Component


public interface ILocationService {

    Page<LocationsDto> getPageLocations(Pageable pageable);

    LocationsDto getLocationbyId(Integer id);

    String addLocation(CreateFormLocation createFormLocation);

    String deletelocation(Integer id);

    String updateLocation(Integer id,UpdateFormLocation updateFormLocation);

    Page<LocationsDto> searchLocations(String data, Pageable pageable);


}
