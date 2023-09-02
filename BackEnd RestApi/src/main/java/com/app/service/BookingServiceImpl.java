package com.app.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.dto.ApiResponse;
import com.app.dto.BookingRequestDto;
import com.app.dto.BookingResponseDto;
import com.app.dto.BookingUpdateDto;
import com.app.entities.Booking;
import com.app.entities.Lister;
import com.app.entities.Property;
import com.app.entities.Seeker;
import com.app.repo.BookingRepository;
import com.app.repo.ListerRepository;
import com.app.repo.PropertyRepository;
import com.app.repo.SeekerRepository;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private ListerRepository listerRepo;

	@Autowired
	private SeekerRepository seekerRepo;

	@Autowired
	private PropertyRepository propertyRepo;

	@Autowired
	private BookingRepository bookingRepo;

	@Override
	public List<BookingResponseDto> getAllBookings() {

		List<BookingResponseDto> dto = new ArrayList<>();
		bookingRepo.findAll().forEach((v) -> {
			System.out.println(v);
			BookingResponseDto brd = new BookingResponseDto();
			brd = mapper.map(v, BookingResponseDto.class);
			brd.setId(v.getId());
			brd.setListerId(v.getLister().getId());
			brd.setSeekerId(v.getSeeker().getId());
			brd.setPropertyId(v.getProperty().getId());
			
			dto.add(brd);
		});

		return dto;

	}

	@Override
	public BookingResponseDto getBookingById(Long id) {
		Booking booking = bookingRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No Such booking found"));
		BookingResponseDto brd = mapper.map(booking, BookingResponseDto.class);
		brd.setListerId(booking.getLister().getId());
		brd.setSeekerId(booking.getSeeker().getId());
		brd.setPropertyId(booking.getProperty().getId());
		return brd;

	}

	@Override
	public ApiResponse createBooking(BookingRequestDto bookingDto) {
		Lister lister = listerRepo.findById(bookingDto.getListerId())
				.orElseThrow(() -> new ResourceNotFoundException("No lister record found"));
		Seeker seeker = seekerRepo.findById(bookingDto.getSeekerId())
				.orElseThrow(() -> new ResourceNotFoundException("No seeker record found"));
		Property property = propertyRepo.findById(bookingDto.getPropertyId())
				.orElseThrow(() -> new ResourceNotFoundException("No property record found"));

		Booking booking = new Booking(lister, seeker, property, bookingDto.getBookingDate(),
				bookingDto.getCheckInDate(), bookingDto.getCheckOutDate());
		bookingRepo.save(booking);

		return new ApiResponse("Booking saved successfully");
	}

	@Override
	public ApiResponse updateBooking(Long id, BookingUpdateDto updatedBookingDto) {
		Booking booking = bookingRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No Booking record found"));
		booking.setBookingDate(updatedBookingDto.getBookingDate());
		booking.setCheckInDate(updatedBookingDto.getCheckInDate());
		booking.setCheckOutDate(updatedBookingDto.getCheckOutDate());
		bookingRepo.save(booking);

		return new ApiResponse("Booking details updated");

	}

	@Override
	public ApiResponse deleteBooking(Long id) {
		Booking booking = bookingRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No booking record found"));
		bookingRepo.delete(booking);

		return new ApiResponse("Booking deleted successfully");

	}
}
