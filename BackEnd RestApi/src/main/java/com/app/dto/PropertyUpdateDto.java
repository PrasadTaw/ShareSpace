package com.app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PropertyUpdateDto {

	private String propertyName;

	private double propertyArea;

	private double rent;

	private AddressRequestDto address;

	private PropertyFeaturesRequestDto propertyFeatures;
}
