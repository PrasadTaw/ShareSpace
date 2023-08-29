package com.app.dto;

import java.util.List;
import java.util.Set;

import com.app.entities.Amenity;
import com.app.entities.FurnishingStatus;
import com.app.entities.Shortlist;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PropertyFeaturesUpdateDto {

	private boolean alcoholAllowed;
    private boolean nonVegAllowed;
    private Set<Amenity> amenities;
    private FurnishingStatus furnishingStatus;
}
