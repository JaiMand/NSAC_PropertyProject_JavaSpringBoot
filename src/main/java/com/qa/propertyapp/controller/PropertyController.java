package com.qa.propertyapp.controller;

import com.qa.propertyapp.model.Buyers;
import com.qa.propertyapp.model.Properties;
import com.qa.propertyapp.repo.PropertyRepo;
import com.qa.propertyapp.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/property")
public class PropertyController {

    @Autowired
    PropertyRepo mRepo;

    @Autowired
    PropertyService service;

    public PropertyController(PropertyService service){
        this.service = service;
    }

        @GetMapping("/read")
        @CrossOrigin("*")
        public List<Properties> read() {
            return service.getAll();
        }

        @GetMapping("/read/{Id}")
        @CrossOrigin("*")
        public Properties readOne(@PathVariable long id ) {
            return service.getProperties(id);
        }

        @PostMapping("/add")
        @CrossOrigin("*")
        public Properties add(@RequestBody Properties property){
            return this.service.createProperties(property);
        }

        @DeleteMapping("/delete/{Id}")
        @CrossOrigin("*")
        public void delete(@PathVariable long Id ) {
            service.deleteProperties(Id);
        }

        @PutMapping("/update/{Id}")
        @CrossOrigin("*")
        public void update(@RequestBody Properties newProperty, @PathVariable ("Id") long Id) {
            service.updateProperties(newProperty, Id);
        }
        @PatchMapping("/change/{Id}")
        @CrossOrigin("*")
        public void change(@RequestBody Properties newProperty, @PathVariable ("Id") long Id) {
            service.changeProperties(newProperty, Id);
        }

//    @PatchMapping ("/update/{Id}")
//    public Buyers updateProperties (@PathVariable long Id,
//                               @RequestParam(required = false) String first_name,
//                               @RequestParam(required = false) String surname,
//                               @RequestParam(required = false) String email,
//                               @RequestParam(required = false) String address,
//                               @RequestParam(required = false) String postcode,
//                               @RequestParam(required = false) Integer phone_number){
//        return this.service.updateProperties(Id, first_name, surname, email, address, postcode, phone_number);
//    }
}