package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Seeker;

public interface SeekerRepository extends JpaRepository<Seeker, Long> {

}
