package com.app.dto;

import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BookingUpdateDto {

	private LocalDate bookingDate;

	@FutureOrPresent(message = "check in date cannot be a past date")
	private LocalDate checkInDate;

	@Future(message = "check out date cannot be a past date")
	private LocalDate checkOutDate;
}
