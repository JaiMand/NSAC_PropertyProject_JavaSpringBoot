package com.qa.propertyapp.controller;

import com.qa.propertyapp.model.Buyers;
import com.qa.propertyapp.repo.BuyerRepo;
import com.qa.propertyapp.service.BuyerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/buyer")
public class BuyerController {

    @Autowired
    BuyerRepo mRepo;
    @Autowired
    BuyerService service;

    @GetMapping("/read")
    public List<Buyers> read() {
        return service.getAll();
    }

    @GetMapping("/read/{id}")
    public Buyers readOne(@PathVariable long id ) {
        return service.getBuyer(id);
    }

    @PostMapping("/add")
    public Buyers add(@Valid @RequestBody Buyers buyer){
        return service.createBuyer(buyer);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id ) {
        service.deleteBuyer(id);
    }

    @PutMapping("/update/{id}")
    public void update(@Valid @RequestBody Buyers newBuyer, @PathVariable ("id") long id) {
        service.updateBuyers(newBuyer, id);
    }

//    @PatchMapping ("/update/{id}")
//    public Buyers updateBuyer (@PathVariable long id,
//                                @RequestParam(required = false) String first_name,
//                                @RequestParam(required = false) String surname,
//                                @RequestParam(required = false) String email,
//                                @RequestParam(required = false) String address,
//                                @RequestParam(required = false) String postcode,
//                                @RequestParam(required = false) Integer phone_number){
//        return this.service.updateBuyers(id, first_name, surname, email, address, postcode, phone_number);
//    }

}