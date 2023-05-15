package com.qa.propertyapp.controller;

import com.qa.propertyapp.model.Bookings;
import com.qa.propertyapp.repo.BookingRepo;
import com.qa.propertyapp.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*") //usually you put the address rather than allowing everyone access http://localhost:3000/
@RestController
@RequestMapping("/booking")
public class BookingController {

        @Autowired
        BookingRepo mRepo;

        @Autowired
        BookingService service;

        @GetMapping("/read")
        public List<Bookings> read() {
            return service.getAll();
        }

        @GetMapping("/read/{Id}")
        public Bookings readOne(@PathVariable long Id ) {
            return service.getBooking(Id);
        }

        @PostMapping("/add")
        public Bookings add(@RequestBody Bookings booking){
            return service.createBooking(booking);
        }

        @DeleteMapping("/delete/{Id}")
        public void delete(@PathVariable long Id ) {
            service.deleteBooking(Id);
        }

        @PutMapping("/update/{Id}")
        public void update(@RequestBody Bookings newBooking, @PathVariable ("Id") long Id) {
            service.updateBooking(newBooking, Id);
        }

//        @PatchMapping("/update/{Id}")
//        public void update(@RequestBody Bookings newBooking, @PathVariable ("Id") long Id) {
//            service.updateBooking(newBooking, Id);
//        }

    }