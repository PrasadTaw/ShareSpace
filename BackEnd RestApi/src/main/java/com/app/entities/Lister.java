package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Lister extends BaseUser{
	
	@OneToMany(mappedBy = "lister")
    private List<Property> properties = new ArrayList<>();
	
	@OneToMany(mappedBy = "lister")
    private List<Matches> matches = new ArrayList<>();
	

}
