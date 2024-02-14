package com.booking.booking.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;
    private  String bookingDescription;
    private String bookingType;

    private int id;

//    private int roomId;


    @Transient
    private List<Customer>  customers;

    @Transient
    private List<Room> rooms;


}
