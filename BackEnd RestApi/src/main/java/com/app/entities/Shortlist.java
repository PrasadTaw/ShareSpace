package com.app.entities;

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
public class Shortlist extends BaseEntity{

	@ManyToOne
    @JoinColumn(name = "seeker_id")
    private Seeker seeker;
	
	@ManyToOne
    @JoinColumn(name = "property_id")
    private Property property;
}
