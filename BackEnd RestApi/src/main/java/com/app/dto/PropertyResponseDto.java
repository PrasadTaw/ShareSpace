package com.app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PropertyResponseDto {

	private Long id;
	private String propertyName;
	private double propertyArea;
	private double rent;
	private AddressResponseDto address;
	private PropertyFeaturesResponseDto propertyFeatures;
	private Long listerId;
}
