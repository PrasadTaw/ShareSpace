package com.app.service;

import java.util.List;

import com.app.dto.ApiResponse;
import com.app.dto.BookingRequestDto;
import com.app.dto.BookingResponseDto;
import com.app.dto.BookingUpdateDto;

public interface BookingService {

	List<BookingResponseDto> getAllBookings();

	BookingResponseDto getBookingById(Long id);

	ApiResponse createBooking(BookingRequestDto booking);

	ApiResponse updateBooking(Long id, BookingUpdateDto updatedBooking);

	ApiResponse deleteBooking(Long id);

}
