package com.qa.propertyapp.controller;

import com.qa.propertyapp.model.Buyers;
import com.qa.propertyapp.repo.BuyerRepo;
import com.qa.propertyapp.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/buyer")
public class BuyerController {

    @Autowired
    BuyerService service;

    @Autowired
    BuyerRepo mRepo;

    @GetMapping("/read")
    public List<Buyers> read() {
        return service.getAll();
    }

    @GetMapping("/read/{id}")
    public Buyers readOne(@PathVariable long id ) {
        return service.getBuyer(id);
    }

    @PostMapping("/add")
    public Buyers add(@RequestBody Buyers newDep){
        return service.createBuyer(newDep);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id ) {
        service.deleteBuyer(id);
    }

}