package com.booking.booking.Services;
import com.booking.booking.entity.Booking;
import com.booking.booking.entity.Customer;
import com.booking.booking.microservice.CustomerClient;
import com.booking.booking.repo.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class BookingService {



    @Autowired
    private BookingRepo bookingRepo;

    @Autowired
    private CustomerClient customerClient;


    public Booking saveBooking(Booking booking) {


        return bookingRepo.save(booking);
    }




    public Optional<Booking> getBookingById(int bookingId) {
        return bookingRepo.findById(bookingId);
    }

    public List<Booking> getAllBookings() {
        List<Booking> bookings = bookingRepo.findAll();

        bookings.forEach(booking -> {

            List<Customer> customers = customerClient.qetBookingByuser(booking.getId());
            booking.setCustomers(customers);
        });

        return bookings;
    }

    public void deleteBooking(int bookingId) {
        bookingRepo.deleteById(bookingId);
    }

    public List<Booking> getBookingsByType(String bookingType) {
        return bookingRepo.findByBookingType(bookingType);
    }



    public List<Booking> getBookingsWithDescriptionContaining(String keyword) {
        return bookingRepo.findByBookingDescriptionContaining(keyword);
    }


    public List<Booking>  findByid(int id){


        return bookingRepo.findByid(id);
    }

//    public List<Booking> findByRoomId(int roomId){
//
//        return bookingRepo.findByRoomId(roomId);
//
//
//    }


}
