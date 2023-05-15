package com.qa.propertyapp.service;

import com.qa.propertyapp.model.Sellers;
import com.qa.propertyapp.repo.SellerRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    private SellerRepo repo;

    public BookingService(SellerRepo repo){
        this.repo = repo;
    }
    public BookingService(){

    }

    public List<Sellers> getAll() {
        return this.repo.findAll();
    }

    public Sellers getSeller(Long id) {
        Optional<Sellers> seller = this.repo.findById(id);
        if (seller.isPresent()){
            return seller.get();
        }
        throw new EntityNotFoundException("Seller With id " + id + " Not Found");
    }

    public Sellers createSeller (Sellers seller){
        return this.repo.save(seller);
    }

    public Sellers deleteSeller (long id){
        Sellers removed = this.getSeller(id);
        this.repo.deleteById(id);
        return removed;
    }

    public Sellers updateSeller (Sellers newSeller, long Id)
    {

        Sellers toUpdate = this.getSeller(Id);
        if (newSeller.getFirst_name()!=null) toUpdate.setFirst_name(newSeller.getFirst_name());;
        if (newSeller.getSurname()!=null) toUpdate.setSurname(newSeller.getSurname());
        if (newSeller.getEmail()!=null) toUpdate.setEmail(newSeller.getEmail());
        if (newSeller.getAddress()!=null) toUpdate.setAddress(newSeller.getAddress());
        if (newSeller.getPhone_number()!=null) toUpdate.setPhone_number(newSeller.getPhone_number());
        if (newSeller.getPostcode()!=null) toUpdate.setEmail(newSeller.getPostcode());

        return this.repo.save(toUpdate);

    }
}