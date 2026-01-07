package com.hobbeyhive.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hobbeyhive.backend.entity.Booking;
import com.hobbeyhive.backend.repository.BookingRepository;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    // ✅ Save booking
    public Booking saveBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    //   Get booking by ID (Confirmation page)
    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
    }

   // Get bookings of logged-in user (MY BOOKINGS)
    public List<Booking> getBookingsByUserEmail(String email) {
        return bookingRepository.findByUserEmail(email);
    }

    // ✅ Get all bookings (Admin / Debug)
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    // ✅ Delete booking
    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }

    public Booking updateBooking(Long id, Booking updated) {
        Booking booking = getBookingById(id);
        booking.setTitle(updated.getTitle());
        booking.setPrice(updated.getPrice());
        booking.setUserName(updated.getUserName());
        booking.setUserEmail(updated.getUserEmail());
        return bookingRepository.save(booking);
    }

}
