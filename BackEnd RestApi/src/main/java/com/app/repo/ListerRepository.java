package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Lister;

public interface ListerRepository extends JpaRepository<Lister, Long> {

}
