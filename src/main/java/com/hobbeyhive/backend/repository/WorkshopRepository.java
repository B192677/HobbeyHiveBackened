package com.hobbeyhive.backend.repository;


import com.hobbeyhive.backend.entity.Workshop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkshopRepository extends JpaRepository<Workshop, Long> {
}

