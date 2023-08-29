package com.app.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BookingResponseDto {

	private Long id;

	private Long listerId;

	private Long seekerId;

	private Long propertyId;

	private LocalDate bookingDate;

	private LocalDate checkInDate;

	private LocalDate checkOutDate;
}
