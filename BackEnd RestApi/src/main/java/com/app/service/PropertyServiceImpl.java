package com.app.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.dto.AddressRequestDto;
import com.app.dto.ApiResponse;
import com.app.dto.PropertyFeaturesRequestDto;
import com.app.dto.PropertyRequestDto;
import com.app.dto.PropertyResponseDto;
import com.app.dto.PropertyUpdateDto;
import com.app.entities.Lister;
import com.app.entities.Property;
import com.app.repo.ListerRepository;
import com.app.repo.PropertyRepository;

@Service
@Transactional
public class PropertyServiceImpl implements PropertyService {

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private ListerRepository listerRepo;

	@Autowired
	private PropertyRepository propertyRepo;

	@Override
	public List<PropertyResponseDto> getAllProperties() {

		List<PropertyResponseDto> dto = new ArrayList<>();
		propertyRepo.findAll().forEach((v) -> {
			System.out.println(v);
			PropertyResponseDto prd = new PropertyResponseDto();
			prd = mapper.map(v, PropertyResponseDto.class);
			prd.setListerId(v.getLister().getId());
			
			dto.add(prd);
		});

		return dto;

	}

	@Override
	public PropertyResponseDto getPropertyById(Long id) {
		Property property = propertyRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No Such property found"));
		PropertyResponseDto prd = mapper.map(property, PropertyResponseDto.class);
		prd.setListerId(property.getLister().getId());
		return prd;

	}

	@Override
	public ApiResponse createProperty(PropertyRequestDto propertyDto) {

		Lister lister = listerRepo.findById(propertyDto.getListerId())
				.orElseThrow(() -> new ResourceNotFoundException("No lister record found"));
		AddressRequestDto address = propertyDto.getAddress();
		PropertyFeaturesRequestDto propertyFeatures = propertyDto.getPropertyFeatures();
		Property property = new Property(propertyDto.getPropertyName(), propertyDto.getPropertyArea(),
				propertyDto.getRent(), null, null, null);
		property = mapper.map(propertyDto, Property.class);
		property.setLister(lister);

		propertyRepo.save(property);

		return new ApiResponse("Property saved successfully");
	}

	@Override
	public ApiResponse updateProperty(Long id, PropertyUpdateDto updatedPropertyDto) {
		Property property = propertyRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No Property record found"));
		property.setPropertyName(updatedPropertyDto.getPropertyName());
		property.setPropertyArea(updatedPropertyDto.getPropertyArea());
		property.setRent(updatedPropertyDto.getRent());
		property.getAddress().setLine1(updatedPropertyDto.getAddress().getLine1());
		property.getAddress().setCity(updatedPropertyDto.getAddress().getCity());
		property.getAddress().setState(updatedPropertyDto.getAddress().getState());
		property.getAddress().setPincode(updatedPropertyDto.getAddress().getPincode());
		property.getPropertyFeatures().setAlcoholAllowed(updatedPropertyDto.getPropertyFeatures().isAlcoholAllowed());
		property.getPropertyFeatures().setNonVegAllowed(updatedPropertyDto.getPropertyFeatures().isNonVegAllowed());
		property.getPropertyFeatures().setAmenities(updatedPropertyDto.getPropertyFeatures().getAmenities());
		property.getPropertyFeatures().setFurnishingStatus(updatedPropertyDto.getPropertyFeatures().getFurnishingStatus());
		
		propertyRepo.save(property);

		return new ApiResponse("Property details updated");

	}

	@Override
	public ApiResponse deleteProperty(Long id) {
		Property property = propertyRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No property record found"));
		propertyRepo.delete(property);

		return new ApiResponse("Property deleted successfully");

	}
}
