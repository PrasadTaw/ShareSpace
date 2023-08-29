package com.app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddressUpdateDto {

	private String line1;
	private String city;
    private String state;
    private String pincode;
}
