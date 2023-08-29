package com.app.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PropertyFeatures {

	private boolean alcoholAllowed;
    private boolean nonVegAllowed;
    
    @ElementCollection
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "property_amenities", joinColumns = @JoinColumn(name = "property_id"))
    @Column(name = "amenity")
    private Set<Amenity> amenities = new HashSet<>();
    
    @Enumerated(EnumType.STRING)
    private FurnishingStatus furnishingStatus;
}
