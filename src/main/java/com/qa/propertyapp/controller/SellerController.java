package com.qa.propertyapp.controller;

import com.qa.propertyapp.model.Properties;
import com.qa.propertyapp.model.Sellers;
import com.qa.propertyapp.repo.SellerRepo;
import com.qa.propertyapp.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("*") //usually you put the address rather than allowing everyone access http://localhost:3000/
@RestController
@RequestMapping("/seller")
public class SellerController {

        @Autowired
        SellerRepo mRepo;

        @Autowired
        SellerService service;

        @GetMapping("/read")
        @CrossOrigin("*") //usually you put the address rather than allowing everyone access http://localhost:3000/
        public List<Sellers> read() {
            return service.getAll();
        }

        @GetMapping("/read/{Id}")
        @CrossOrigin("*") //usually you put the address rather than allowing everyone access http://localhost:3000/
        public Sellers readOne(@PathVariable long Id ) {
            return service.getSeller(Id);
        }

        @PostMapping("/add")
        @CrossOrigin("*") //usually you put the address rather than allowing everyone access http://localhost:3000/
        public Sellers add(@RequestBody Sellers seller){
            return service.createSeller(seller);
        }

        @DeleteMapping("/delete/{Id}")
        @CrossOrigin("*")
        public void delete(@PathVariable long Id ) {
            service.deleteSeller(Id);
        }

        @PutMapping("/update/{Id}")
        @CrossOrigin("*") //usually you put the address rather than allowing everyone access http://localhost:3000/
        public void update(@RequestBody Sellers newSeller, @PathVariable ("Id") long Id) {
            service.updateSeller(newSeller, Id);
        }

//        @PatchMapping("/update/{Id}")
//        public void update(@RequestBody Sellers newSeller, @PathVariable ("Id") long Id) {
//            service.updateSeller(newSeller, Id);
//        }

    }