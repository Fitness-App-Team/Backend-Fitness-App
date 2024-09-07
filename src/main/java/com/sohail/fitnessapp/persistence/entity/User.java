package com.sohail.fitnessapp.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.NotNull;


@Entity
@Data
@Table(name = "user")
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //User Data
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private int contact;


    private Booking[] allUserBookings;
}
