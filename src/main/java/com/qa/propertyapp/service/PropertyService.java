package com.qa.propertyapp.service;

//import com.qa.propertyapp.model.Buyers;
//import com.qa.propertyapp.model.Sellers;
import com.qa.propertyapp.model.Buyers;
import com.qa.propertyapp.model.Properties;
import com.qa.propertyapp.model.Sellers;
import com.qa.propertyapp.repo.BuyerRepo;
import com.qa.propertyapp.repo.PropertyRepo;
import com.qa.propertyapp.repo.SellerRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepo propertyRepo;
    @Autowired
    private SellerRepo sellerRepo;
    @Autowired
    private BuyerRepo buyerRepo;


    public PropertyService(PropertyRepo propertyRepo, SellerRepo sellerRepo, BuyerRepo buyerRepo){
        this.propertyRepo = propertyRepo;
        this.sellerRepo = sellerRepo;
        this.buyerRepo = buyerRepo;
    }
    public PropertyService(){
    }

    public List<Properties> getAll() {
        return this.propertyRepo.findAll();
    }

    public Properties getProperties(long Id) {
        Optional<Properties> property = this.propertyRepo.findById(Id);
        if (property.isPresent()){
            return property.get();
        }
        throw new EntityNotFoundException("Property With Id " + Id + " Not Found");
//        return this.repo.findById(id).get();
    }

    public Properties createProperties (Properties property){
        if (property.getSellers() == null) {
            throw new RuntimeException("Cannot Creat A New Property Without A Seller");
        }

        Optional<Sellers> seller = this.sellerRepo.findById(property.getSellers().getId());
        if (!seller.isPresent()){
            throw new EntityNotFoundException("Cannot Create Property, Seller With id " + property.getSellers().getId() + " Is Not Found");
        }
        else property.setSellers(seller.get());

        if (property.getBuyers() != null){
            Optional<Buyers> buyer = this.buyerRepo.findById(property.getBuyers().getId());
            if (!buyer.isPresent()){
                throw new EntityNotFoundException("Cannot Create Property, Buyer With id " + property.getBuyers().getId() + " Is Not Found");
            }
            else property.setBuyers(buyer.get());
        }

        return this.propertyRepo.save(property);
    }

    public Properties deleteProperties (long Id){
        Properties removed = this.getProperties(Id);
        this.propertyRepo.deleteById(Id);
        return removed;
    }

    public Properties updateProperties (Properties newProperty, long Id)
    {
        Properties toUpdate = this.getProperties(Id);
        if (newProperty.getAddress()!=null) toUpdate.setAddress(newProperty.getAddress());
        if (newProperty.getPostcode()!=null) toUpdate.setPostcode(newProperty.getPostcode());
        if (newProperty.getType()!=null) toUpdate.setType(newProperty.getType());
        if (newProperty.getPrice()!=0) toUpdate.setPrice(newProperty.getPrice());
        if (newProperty.getBedrooms()!=0) toUpdate.setBedrooms(newProperty.getBedrooms());
        if (newProperty.getBathrooms()!=0) toUpdate.setBathrooms(newProperty.getBathrooms());
        if (newProperty.getGarden()!=false) toUpdate.setGarden(newProperty.getGarden());
        if (newProperty.getSellers()!=null) toUpdate.setSellers(newProperty.getSellers());
        if (newProperty.getBuyers()!=null) toUpdate.setBuyers(newProperty.getBuyers());
        return this.propertyRepo.save(toUpdate);
    }

    public Properties changeProperties (Properties newProperty, long Id)
    {
        Properties toUpdate = this.getProperties(Id);
        if (newProperty.getStatus()!=null) toUpdate.setStatus(newProperty.getStatus());
        return this.propertyRepo.save(toUpdate);
    }
}