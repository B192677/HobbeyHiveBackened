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

    public Booking saveBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    // ✅ Fetch all bookings
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
}
