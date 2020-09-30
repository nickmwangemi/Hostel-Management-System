package com.mwangemi.hostelmanagementsystem.controllers;

import com.mwangemi.hostelmanagementsystem.models.Booking;
import com.mwangemi.hostelmanagementsystem.models.GenericResponse;
import com.mwangemi.hostelmanagementsystem.services.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    // CREATE Booking Record
    @PostMapping("")
    public ResponseEntity create(@RequestBody Booking booking) throws IOException {
        GenericResponse genericResponse = bookingService.save(booking);
        return new ResponseEntity<>(genericResponse, HttpStatus.CREATED);
    }

    // READ ONE Booking Record
    @GetMapping("/{id}")
    public ResponseEntity getBooking(@PathVariable("id") Long id) {
        GenericResponse genericResponse = bookingService.get(id);
        return new ResponseEntity<>(genericResponse, HttpStatus.OK);
    }

    // READ ALL Booking Records
    @GetMapping("")
    public ResponseEntity getBookings(){
        GenericResponse genericResponse = bookingService.listAll();
        return new ResponseEntity<>(genericResponse, HttpStatus.OK);
    }

    // UPDATE Booking Record
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @PathVariable Booking booking){
        GenericResponse genericResponse = bookingService.update(id, booking);
        return new ResponseEntity<>(genericResponse, HttpStatus.OK);
    }

    // DELETE Booking Record
    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable("id") Long id) {
        GenericResponse genericResponse = bookingService.deleteById(id);
        return new ResponseEntity<>(genericResponse, HttpStatus.OK);
    }


}
