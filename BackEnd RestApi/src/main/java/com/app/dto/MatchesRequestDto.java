package com.app.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MatchesRequestDto {

	@NotNull(message = "Lister id not provided")
	private Long listerId;
	
	@NotNull(message = "Seeker id not provided")
    private Long seekerId;
	
	@NotNull(message = "Property id not provided")
    private Long propertyId;
}
