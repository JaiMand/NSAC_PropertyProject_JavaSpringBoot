package com.qa.propertyapp.service;

import com.qa.propertyapp.model.Buyers;
import com.qa.propertyapp.repo.BuyerRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;

import java.util.List;
import java.util.Optional;

@Service
public class BuyerService {
    @Autowired
    private BuyerRepo repo;

    public BuyerService(BuyerRepo repo){
        this.repo = repo;
    }
    public BuyerService(){
    }

    public List<Buyers> getAll() {
        return this.repo.findAll();
    }

    public Buyers getBuyer(long id) {
        Optional<Buyers> buyer = this.repo.findById(id);
        if (buyer.isPresent()){
            return buyer.get();
        }
        throw new EntityNotFoundException("Buyer With id " + id + " Not Found");
//        throw new RuntimeException("Buyer With id " + id + " Not Found");
    }

    public Buyers createBuyer (Buyers dep){
        return this.repo.save(dep);
    }

    public Buyers deleteBuyer (long id){
        Buyers removed = this.getBuyer(id);
        this.repo.deleteById(id);
        return removed;
    }

    public Buyers updateBuyers (Buyers newBuyer, long id)
    {
        Buyers toUpdate = this.getBuyer(id);
        if (newBuyer.getFirst_name()!=null) toUpdate.setFirst_name(newBuyer.getFirst_name());
        if (newBuyer.getSurname()!=null) toUpdate.setSurname(newBuyer.getSurname());
        if (newBuyer.getEmail()!=null) toUpdate.setEmail(newBuyer.getEmail());
        if (newBuyer.getAddress()!=null) toUpdate.setAddress(newBuyer.getAddress());
        if (newBuyer.getPostcode()!=null) toUpdate.setPostcode(newBuyer.getPostcode());
        if (newBuyer.getPhone_number()!=null) toUpdate.setPhone_number(newBuyer.getPhone_number());
        return this.repo.save(toUpdate);

//        Optional<Buyers> buyer = repo.findById(id);
//        Buyers.setFirst_name(newBuyer.getFirst_name());
//        Buyers.setSurname(newBuyer.getSurname());
//        Buyers.setEmail(newBuyer.getEmail());
//
//        return this.repo.save(Buyers.get());
    }
}