package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Shortlist;

public interface ShortlistRepository extends JpaRepository<Shortlist, Long> {

}
