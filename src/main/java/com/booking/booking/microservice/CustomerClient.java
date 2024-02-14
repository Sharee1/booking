package com.booking.booking.microservice;


import com.booking.booking.entity.Customer;
import com.booking.booking.entity.Room;
import jakarta.persistence.GeneratedValue;
import org.apache.catalina.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "customer-service", url = "http://localhost:8080")
public interface CustomerClient {

@GetMapping("/booking/user/{id]")
    List<Customer>  qetBookingByuser(@PathVariable int id);

//@GetMapping("/booking/room/user/{id]")
//      List<Room> getBookedRoomByUser(@PathVariable int id);








}
