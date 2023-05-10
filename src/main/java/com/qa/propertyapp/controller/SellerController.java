package com.qa.propertyapp.controller;

import com.qa.propertyapp.model.Sellers;
import com.qa.propertyapp.repo.SellerRepo;
import com.qa.propertyapp.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seller")
public class SellerController {

        @Autowired
        SellerRepo mRepo;

        @Autowired
        SellerService service;

        @GetMapping("/read")
        public List<Sellers> read() {
            return service.getAll();
        }

        @GetMapping("/read/{id}")
        public Sellers readOne(@PathVariable long id ) {
            return service.getSeller(id);
        }

        @PostMapping("/add")
        public Sellers add(@RequestBody Sellers newEmp){
            return service.createSeller(newEmp);
        }

        @DeleteMapping("/delete/{id}")
        public void delete(@PathVariable long id ) {
            service.deleteSeller(id);
        }

    }