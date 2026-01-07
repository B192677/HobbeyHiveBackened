//package com.hobbeyhive.backend.repository;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import com.hobbeyhive.backend.entity.Booking;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public interface BookingRepository extends JpaRepository<Booking, Long> {
//}
package com.hobbeyhive.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hobbeyhive.backend.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    // ✅ Fetch bookings for a specific user
    List<Booking> findByUserEmail(String userEmail);

    // ✅ Fetch booking by id (safe)
    Optional<Booking> findById(Long id);
}
