package com.sohail.fitnessapp.persistence.entity;

import com.sohail.fitnessapp.dto.BookingClassType;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "slot_booking")
public class Booking {


    @Id
    @Column(name = "booking_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Booked user Data
    private String userId;

    @Column(name = "class_type")
    @Enumerated(EnumType.STRING)
    private BookingClassType type;


    //Slot Details
    private int totalSlots;
    private int emptySlots;
}