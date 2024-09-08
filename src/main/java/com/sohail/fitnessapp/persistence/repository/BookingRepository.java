package com.sohail.fitnessapp.persistence.repository;

import com.sohail.fitnessapp.persistence.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByUserIdAndIsWaitingListFalse(String userId);
//    Optional<Booking> findFirstByFitnessClassAndIsWaitingListTrue(FitnessClass fitnessClass);
}