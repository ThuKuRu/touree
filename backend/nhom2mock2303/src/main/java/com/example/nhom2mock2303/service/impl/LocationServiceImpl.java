
package com.example.nhom2mock2303.service.impl;


import com.example.nhom2mock2303.dto.LocationsDto;
import com.example.nhom2mock2303.entity.Locations;
import com.example.nhom2mock2303.form.create.CreateFormLocation;
import com.example.nhom2mock2303.form.update.UpdateFormLocation;
import com.example.nhom2mock2303.repository.ILocationRepository;
import com.example.nhom2mock2303.service.ILocationService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LocationServiceImpl implements ILocationService {

    @Autowired
    private ILocationRepository locationRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Page<LocationsDto> getPageLocations(Pageable pageable) {
        Page<Locations> locationsList = locationRepo.findAll(pageable);
        List<LocationsDto> locationsDtoList = modelMapper.map(locationsList.getContent(), new TypeToken<List<LocationsDto>>(){}.getType());
        Page<LocationsDto> dtoPages = new PageImpl<>(locationsDtoList, pageable, locationsList.getTotalElements());
        return dtoPages;
    }

    @Override
    public LocationsDto getLocationbyId(Integer id) {
        if (!locationRepo.findById(id).isPresent()){
            return null;
        }
        Locations locations = locationRepo.findById(id).get();
        LocationsDto locationsDto = new LocationsDto();
        locationsDto.setId(locations.getId());
        locationsDto.setLocationName(locations.getLocationName());
        locationsDto.setInformation(locations.getInformation());
        locationsDto.setImage(locations.getImage());
        return locationsDto;
    }

    @Override
    public String addLocation(CreateFormLocation createFormLocation) {
        Locations location = new Locations();
        location.setLocationName(createFormLocation.getLocationName());
        location.setInformation(createFormLocation.getInformation());
        location.setImage(createFormLocation.getImage());
        locationRepo.save(location);
        return "Tạo mới location thành công!";
    }

    @Override
    public String deletelocation(Integer id) {
        if (!locationRepo.findById(id).isPresent()){
            return "Xoá không thành công id:"+ id;
        }
        locationRepo.deleteById(id);
        return "Xoá thành công id:"+ id;
    }

    @Override
    public String updateLocation(Integer id,UpdateFormLocation updateFormLocation) {
        if (!locationRepo.findById(id).isPresent()){
            return "Cập nhập thất bại, id " +id+ " này không tồn tại";
        }
        Locations locations = locationRepo.findById(id).get();
        locations.setLocationName(updateFormLocation.getLocationName());
        locations.setInformation(updateFormLocation.getInformation());
        locations.setImage(updateFormLocation.getImage());
        locationRepo.save(locations);
        return "Cập nhập thành công id "+id;
    }

    @Override
    public Page<LocationsDto> searchLocations(String data, Pageable pageable) {

//        Page<Locations> locationsList = locationRepo.searchLocations(data,pageable);
        Page<Locations> locationsList = locationRepo.findAllByLocationName(data,pageable);
//        Page<Locations> locationsList = locationRepo.searchLocations(data,pageable);
        List<LocationsDto> locationsDtoList = modelMapper.map(locationsList.getContent(), new TypeToken<List<LocationsDto>>(){}.getType());
        Page<LocationsDto> dtoPages = new PageImpl<>(locationsDtoList, pageable, locationsList.getTotalElements());
        return dtoPages;
    }
}
