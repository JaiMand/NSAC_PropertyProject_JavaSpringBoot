package com.qa.propertyapp.service;

import com.qa.propertyapp.model.Properties;
import com.qa.propertyapp.repo.PropertyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepo repo;

    public PropertyService(PropertyRepo repo){
        this.repo = repo;
    }
    public PropertyService(){

    }

    public List<Properties> getAll() {
        return this.repo.findAll();
    }


    public Properties getAddress(Long id) {

        return this.repo.findById(id).get();

    }


    public Properties createAddress (Properties addr){

        return this.repo.save(addr);

    }

    public Properties deleteAddress (long id){
        Properties removed = this.getAddress(id);
        this.repo.deleteById(id);
        return removed;

    }


}