package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {

}
