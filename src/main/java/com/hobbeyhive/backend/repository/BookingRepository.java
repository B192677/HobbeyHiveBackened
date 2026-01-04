package com.hobbeyhive.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hobbeyhive.backend.entity.Booking;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
}
