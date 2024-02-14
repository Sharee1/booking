package com.booking.booking.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.Role;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Customer")
public class Customer {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private String userName;

    @Enumerated (EnumType.STRING)
     Role role;

}
