package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embedded;
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
public class Property extends BaseEntity{

	@Column(name = "property_name")
	private String propertyName;
	
	@Column(name = "property_area")
	private double propertyArea;
	
	@Column(name = "monthly_rent")
	private double rent;
	
	@ManyToOne
    @JoinColumn(name = "lister_id")
    private Lister lister;
    
    @Embedded
    private Address address;
    
    @Embedded
    private PropertyFeatures propertyFeatures;
}
