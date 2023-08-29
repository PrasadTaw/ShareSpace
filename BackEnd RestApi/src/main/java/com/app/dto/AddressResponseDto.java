package com.app.dto;

import java.util.List;

import com.app.entities.Shortlist;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddressResponseDto {

	private String line1;
	private String city;
    private String state;
    private String pincode;
}
