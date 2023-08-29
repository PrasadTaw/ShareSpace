package com.app.dto;

import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BookingRequestDto {

	@NotNull(message = "Lister id not provided")
	private Long listerId;
	
	@NotNull(message = "Lister id not provided")
    private Long seekerId;
	
	@NotNull(message = "Lister id not provided")
    private Long propertyId;
	
	@NotNull(message = "Lister id not provided")
    private LocalDate bookingDate;
	
	@NotNull(message = "check in date not provided")
	@FutureOrPresent(message = "check in date cannot be a past date")
    private LocalDate checkInDate;
	
	@Future(message = "check out date cannot be a past date")
    private LocalDate checkOutDate;
}
