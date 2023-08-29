package com.app.dto;

import javax.validation.constraints.NotNull;

import com.app.entities.Property;
import com.app.entities.Seeker;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ShortlistRequestDto {

	@NotNull(message = "No User id provided")
	private Long seekerId;
	
	@NotNull(message = "No Property id provided")
    private Long propertyId;
}
