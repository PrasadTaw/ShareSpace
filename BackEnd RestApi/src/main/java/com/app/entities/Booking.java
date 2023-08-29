package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Booking extends BaseEntity{

	@ManyToOne
    @JoinColumn(name = "lister_id")
    private Lister lister;
    
    @ManyToOne
    @JoinColumn(name = "seeker_id")
    private Seeker seeker;

    @ManyToOne
    @JoinColumn(name = "property_id")
    private Property property;
    
    @Column(name = "booking_date")
    private LocalDate bookingDate;
    
    @Column(name = "check_in_date")
    private LocalDate checkInDate;
    
    @Column(name = "check_out_date")
    private LocalDate checkOutDate;
    
}
