package com.app.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;

import com.app.entities.Shortlist;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddressRequestDto {

	@NotBlank(message = "Address line 1 cannot be blank")
	private String line1;
	
	@NotBlank(message = "City cannot be blank")
	private String city;
	
	@NotBlank(message = "State cannot be blank")
    private String state;
	
	@NotBlank(message = "Pincode cannot be blank")
    private String pincode;
}
