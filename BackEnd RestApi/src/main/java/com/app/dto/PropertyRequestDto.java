package com.app.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PropertyRequestDto {

	@NotBlank(message = "House name cannot be blank")
	private String propertyName;
	
	private double propertyArea;
	
	@NotNull(message = "Rent details cannot be blank")
	private double rent;
	
	@NotNull(message = "Lister id not provided")
	private Long listerId;
	
	@NotNull(message = "Address details cannot be blank")
	private AddressRequestDto address;
	
    private PropertyFeaturesRequestDto propertyFeatures;
	
	
}
