package com.app.service;

import java.util.List;

import com.app.dto.ApiResponse;
import com.app.dto.PropertyRequestDto;
import com.app.dto.PropertyResponseDto;
import com.app.dto.PropertyUpdateDto;

public interface PropertyService {

	List<PropertyResponseDto> getAllProperties();

	PropertyResponseDto getPropertyById(Long id);

	ApiResponse createProperty(PropertyRequestDto property);

	ApiResponse updateProperty(Long id, PropertyUpdateDto updatedProperty);

	ApiResponse deleteProperty(Long id);

}
