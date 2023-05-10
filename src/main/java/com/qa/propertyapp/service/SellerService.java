package com.qa.propertyapp.service;

import com.qa.propertyapp.model.Sellers;
import com.qa.propertyapp.repo.SellerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerService {
    @Autowired
    private SellerRepo repo;

    public SellerService(SellerRepo repo){
        this.repo = repo;
    }
    public SellerService(){

    }

    public List<Sellers> getAll() {
        return this.repo.findAll();
    }

    public Sellers getSeller(Long id) {
        return this.repo.findById(id).get();
    }

    public Sellers createSeller (Sellers emp){
        return this.repo.save(emp);
    }

    public Sellers deleteSeller (long id){
        Sellers removed = this.getSeller(id);
        this.repo.deleteById(id);
        return removed;
    }



    public Sellers updateSeller (long Id, String first_name, String surname, String email, String address, String postcode, Integer phone_number)
    {

        Sellers toUpdate = this.getSeller(Id);
        if (first_name!=null) toUpdate.setFirst_name(first_name);;
        if (surname!=null) toUpdate.setSurname(surname);
        if (email!=null) toUpdate.setEmail(email);
        if (address!=null) toUpdate.setAddress(email);
        if (phone_number!=null) toUpdate.setPhone_number(phone_number);
        if (postcode!=null) toUpdate.setEmail(email);

        return this.repo.save(toUpdate);

    }
}