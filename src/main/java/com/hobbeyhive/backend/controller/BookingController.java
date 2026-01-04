package com.hobbeyhive.backend.controller;

import com.hobbeyhive.backend.entity.Booking;
import com.hobbeyhive.backend.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = "http://localhost:4200") // allow Angular
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    // 1️⃣ Create a new booking
    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
        Booking saved = bookingRepository.save(booking);
        return ResponseEntity.ok(saved);
    }

    // 2️⃣ Get all bookings
    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings() {
        List<Booking> bookings = bookingRepository.findAll();
        return ResponseEntity.ok(bookings);
    }

    // 3️⃣ Get a booking by ID
    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBooking(@PathVariable Long id) {
        Optional<Booking> booking = bookingRepository.findById(id);
        return booking.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }

    // 4️⃣ (Optional) Delete a booking
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
        if (bookingRepository.existsById(id)) {
            bookingRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // 5️⃣ (Optional) Update a booking
    @PutMapping("/{id}")
    public ResponseEntity<Booking> updateBooking(@PathVariable Long id, @RequestBody Booking updatedBooking) {
        return bookingRepository.findById(id)
                .map(booking -> {
                    booking.setUserName(updatedBooking.getUserName());
                    booking.setWorkshopId(updatedBooking.getWorkshopId());
                    booking.setPrice(updatedBooking.getPrice());
                    Booking saved = bookingRepository.save(booking);
                    return ResponseEntity.ok(saved);
                }).orElse(ResponseEntity.notFound().build());
    }
}
