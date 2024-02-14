package com.booking.booking.controller;
import com.booking.booking.entity.Booking;
import com.booking.booking.Services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/create")
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
        Booking savedBooking = bookingService.saveBooking(booking);
        return new ResponseEntity<>(savedBooking, HttpStatus.CREATED);
    }

    @GetMapping("/{bookingId}")
    public ResponseEntity<Booking> getBookingById(@PathVariable int bookingId) {
        Optional<Booking> booking = bookingService.getBookingById(bookingId);
        return booking.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Booking>> getAllBookings() {
        List<Booking> bookings = bookingService.getAllBookings();
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }

    @DeleteMapping("/{bookingId}")
    public ResponseEntity<Void> deleteBooking(@PathVariable int bookingId) {
        bookingService.deleteBooking(bookingId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/type/{bookingType}")
    public ResponseEntity<List<Booking>> getBookingsByType(@PathVariable String bookingType) {
        List<Booking> bookings = bookingService.getBookingsByType(bookingType);
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }

    @GetMapping("/description")
    public ResponseEntity<List<Booking>> getBookingsWithDescriptionContaining(@RequestParam String keyword) {
        List<Booking> bookings = bookingService.getBookingsWithDescriptionContaining(keyword);
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }

//    public List<Booking>  getBookingbyUserid(int id){
//
//
//        return bookingService.findByid(id);
//
//    }

    @GetMapping("/bookings/{id}")
    public List<Booking> qetBookingByuser(@PathVariable int id) {
        return bookingService.findByid(id);
    }
}
