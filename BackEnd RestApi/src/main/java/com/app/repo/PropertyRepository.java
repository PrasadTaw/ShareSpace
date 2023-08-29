package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Property;

public interface PropertyRepository extends JpaRepository<Property, Long> {

}
