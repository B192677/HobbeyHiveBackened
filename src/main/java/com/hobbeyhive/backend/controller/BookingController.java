//package com.hobbeyhive.backend.controller;
//
//import com.hobbeyhive.backend.entity.Booking;
//import com.hobbeyhive.backend.repository.BookingRepository;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.http.ResponseEntity;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/bookings")
//@CrossOrigin(origins = "http://localhost:4200")
//public class BookingController {
//
//    @Autowired
//    private BookingRepository bookingRepository;
//
//    // 1️⃣ Create booking
//    @PostMapping
//    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
//        Booking savedBooking = bookingRepository.save(booking);
//        return ResponseEntity.ok(savedBooking);
//    }
//
//    // 2️⃣ Get all bookings
//    @GetMapping
//    public ResponseEntity<List<Booking>> getAllBookings() {
//        return ResponseEntity.ok(bookingRepository.findAll());
//    }
//
//    // 3️⃣ Get booking by ID
//    @GetMapping("/{id}")
//    public ResponseEntity<Booking> getBooking(@PathVariable Long id) {
//        Optional<Booking> booking = bookingRepository.findById(id);
//        return booking.map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    // 4️⃣ Delete booking
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
//        if (bookingRepository.existsById(id)) {
//            bookingRepository.deleteById(id);
//            return ResponseEntity.noContent().build();
//        }
//        return ResponseEntity.notFound().build();
//    }
//
//    // 5️⃣ Update booking
//    @PutMapping("/{id}")
//    public ResponseEntity<Booking> updateBooking(
//            @PathVariable Long id,
//            @RequestBody Booking updatedBooking
//    ) {
//        return bookingRepository.findById(id)
//                .map(booking -> {
//                    booking.setWorkshopId(updatedBooking.getWorkshopId());
//                    booking.setTitle(updatedBooking.getTitle());
//                    booking.setPrice(updatedBooking.getPrice());
//                    booking.setUserName(updatedBooking.getUserName());
//                    booking.setUserEmail(updatedBooking.getUserEmail());
//
//                    return ResponseEntity.ok(bookingRepository.save(booking));
//                })
//                .orElse(ResponseEntity.notFound().build());
//    }
//}
package com.hobbeyhive.backend.controller;

import com.hobbeyhive.backend.entity.Booking;
import com.hobbeyhive.backend.service.BookingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = "http://localhost:4200")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    // 1️⃣ Create booking
    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
        Booking savedBooking = bookingService.saveBooking(booking);
        return ResponseEntity.ok(savedBooking);
    }

    // 2️⃣ Get all bookings (ADMIN / DEBUG)
    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings() {
        return ResponseEntity.ok(bookingService.getAllBookings());
    }

    // 3️⃣ Get booking by ID (Confirmation Page)
    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBooking(@PathVariable Long id) {
        try {
            Booking booking = bookingService.getBookingById(id);
            return ResponseEntity.ok(booking);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // 🔥 4️⃣ Get bookings of logged-in user (MY BOOKINGS)
    @GetMapping("/user/{email}")
    public ResponseEntity<List<Booking>> getBookingsByUser(
            @PathVariable String email
    ) {
        List<Booking> bookings = bookingService.getBookingsByUserEmail(email);
        return ResponseEntity.ok(bookings);
    }

    // 5️⃣ Delete booking
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
        try {
            bookingService.deleteBooking(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // 6️⃣ Update booking
    @PutMapping("/{id}")
    public ResponseEntity<Booking> updateBooking(
            @PathVariable Long id,
            @RequestBody Booking updatedBooking
    ) {
        try {
            Booking booking = bookingService.updateBooking(id, updatedBooking);
            return ResponseEntity.ok(booking);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}

