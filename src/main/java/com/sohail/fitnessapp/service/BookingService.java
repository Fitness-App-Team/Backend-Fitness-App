package com.sohail.fitnessapp.service;

import com.sohail.fitnessapp.persistence.entity.Booking;
import com.sohail.fitnessapp.persistence.entity.Fitness;
import com.sohail.fitnessapp.persistence.repository.BookingRepository;
import com.sohail.fitnessapp.persistence.repository.FitnessRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BookingService {

    @Autowired
    private FitnessRepository fitnessRepo;

    @Autowired
    private BookingRepository bookingRepo;

    public Booking bookSlot(Long fitnessId, String userId) {
        Fitness fitness = fitnessRepo.findById(fitnessId)
                .orElseThrow(() -> new ResourceNotFoundException("Class not found"));

        long bookedCount = bookingRepo.countByFitnessAndIsWaitingListFalse(fitness);

        if (bookedCount < fitness.getCapacity()) {
            Booking booking = new Booking();
            booking.setUserId(userId);
            booking.setFitnessId(fitness);
            return bookingRepo.save(booking);
        } else {
            // Add to waiting list
            Booking waitingListBooking = new Booking();
            waitingListBooking.setUserId(userId);
            waitingListBooking.setFitnessId(fitness);
            waitingListBooking.setWaitingList(true);
            return bookingRepo.save(waitingListBooking);
        }
    }

    public void cancelBooking(Long bookingId) {
        Booking booking = bookingRepo.findById(bookingId)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found"));

        bookingRepo.delete(booking);

        // Assign slot to first in the waiting list
        Booking waitlistBooking = bookingRepo.findFirstByFitnessAndIsWaitingListTrue(booking.getFitnessId());
        if (waitlistBooking != null) {
            waitlistBooking.setWaitingList(false);
            bookingRepo.save(waitlistBooking);
        }
    }
}
