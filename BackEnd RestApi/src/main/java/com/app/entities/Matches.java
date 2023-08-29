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
public class Matches extends BaseEntity {

	@ManyToOne
    @JoinColumn(name = "lister_id")
    private Lister lister;
    
    @ManyToOne
    @JoinColumn(name = "seeker_id")
    private Seeker seeker;

    // Other attributes
    
    @ManyToOne
    @JoinColumn(name = "property_id")
    private Property property;
}
