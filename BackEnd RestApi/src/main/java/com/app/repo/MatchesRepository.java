package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Matches;

public interface MatchesRepository extends JpaRepository<Matches, Long> {

}
