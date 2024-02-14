package com.booking.booking.repo;

import com.booking.booking.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface BookingRepo extends JpaRepository<Booking,Integer> {

//    List<Booking> findByRoomId(int roomId);
    List<Booking> findByBookingType(String bookingType);

    List<Booking> findByBookingDescriptionContaining(String keyword);


    List<Booking>  findByid(int id);


 }
