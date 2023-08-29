package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.BookingRequestDto;
import com.app.dto.BookingResponseDto;
import com.app.service.BookingService;

@RestController
@RequestMapping("/booking")
public class BookingController {

	@Autowired
    private BookingService bookingService;
	
	@GetMapping
    public ResponseEntity<?> getAllBookings() {
			
		return ResponseEntity.status(HttpStatus.OK).body(bookingService.getAllBookings());
	}

    @PostMapping
    public ResponseEntity<?> createBooking(@RequestBody @Valid BookingRequestDto bookingRequestDto,
                                                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body("Validation errors occurred.");
        }

        
        return ResponseEntity.status(HttpStatus.CREATED).body(bookingService.createBooking(bookingRequestDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBookingById(@PathVariable Long id) {
        
    	return ResponseEntity.status(HttpStatus.OK).body(bookingService.getBookingById(id));
    			
    }

//    @GetMapping("/seeker/{seekerId}")
//    public ResponseEntity<List<BookingResponseDto>> getSeekerBookings(@PathVariable Long seekerId) {
//        List<BookingResponseDto> bookings = bookingService.getSeekerBookings(seekerId);
//        return ResponseEntity.ok(bookings);
//    }
//
//    @GetMapping("/lister/{listerId}")
//    public ResponseEntity<List<BookingResponseDto>> getListerBookings(@PathVariable Long listerId) {
//        List<BookingResponseDto> bookings = bookingService.getListerBookings(listerId);
//        return ResponseEntity.ok(bookings);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBooking(@PathVariable Long id) {
        
    	return ResponseEntity.status(HttpStatus.OK).body(bookingService.deleteBooking(id));
    }

    

}
