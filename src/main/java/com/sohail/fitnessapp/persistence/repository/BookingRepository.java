package com.sohail.fitnessapp.persistence.repository;

import com.sohail.fitnessapp.persistence.entity.Booking;
import com.sohail.fitnessapp.persistence.entity.Fitness;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByUserIdAndIsWaitingListFalse(String userId);
    Booking findFirstByFitnessAndIsWaitingListTrue(Fitness fitness);
    long countByFitnessAndIsWaitingListFalse(Fitness fitness);
}