package com.sohail.fitnessapp.controller;


import com.sohail.fitnessapp.persistence.entity.Booking;
import com.sohail.fitnessapp.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/classes")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/{classId}/book")
    public ResponseEntity<Booking> bookClass(@PathVariable Long classId, @RequestParam String userId) {
        return ResponseEntity.ok(bookingService.bookSlot(classId, userId));
    }

    @DeleteMapping("/cancel/{bookingId}")
    public ResponseEntity<Void> cancelBooking(@PathVariable Long bookingId) {
        bookingService.cancelBooking(bookingId);
        return ResponseEntity.noContent().build();
    }

    // TODO Additional APIs for filtering, sorting, and pagination
}