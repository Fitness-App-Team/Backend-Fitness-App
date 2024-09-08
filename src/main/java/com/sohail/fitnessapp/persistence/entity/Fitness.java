package com.sohail.fitnessapp.persistence.entity;

import com.sohail.fitnessapp.dto.FitnessClassType;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Fitness {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private FitnessClassType type; // yoga, gym, dance
    private int capacity;

    @OneToMany(mappedBy = "fitness")
    private List<Booking> bookings;
}