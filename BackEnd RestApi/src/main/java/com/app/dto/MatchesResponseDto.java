package com.app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MatchesResponseDto {

	private Long id;

	private Long listerId;

	private Long seekerId;

	private Long propertyId;
}
