package com.sohail.fitnessapp.persistence.entity;

import com.sohail.fitnessapp.dto.FitnessClassType;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "slot_booking")
public class Booking {


    @Id
    @Column(name = "booking_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "class_type")
    @Enumerated(EnumType.STRING)
    private FitnessClassType type;

    private String userId;
    private LocalDateTime bookingTime;
    private boolean isWaitingList;

    @ManyToOne
    @JoinColumn(name = "fitness_id")
    private Fitness fitnessId;
}