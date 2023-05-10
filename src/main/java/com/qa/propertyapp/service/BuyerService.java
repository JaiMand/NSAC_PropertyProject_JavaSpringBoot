package com.qa.propertyapp.service;

import com.qa.propertyapp.model.Buyers;
import com.qa.propertyapp.model.Properties;
import com.qa.propertyapp.repo.BuyerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Buyers getBuyer(Long id) {
        return this.repo.findById(id).get();
    }

    public Buyers createBuyer (Buyers dep){
        return this.repo.save(dep);
    }

    public Buyers deleteBuyer (long Id){
        Buyers removed = this.getBuyer(Id);
        this.repo.deleteById(Id);
        return removed;
    }

    public Buyers updateSeller (long Id, String first_name, String surname, String email, String address, String postcode, Integer phone_number)
    {

        Buyers toUpdate = this.getBuyer(Id);
        if (first_name!=null) toUpdate.setFirst_name(first_name);
        if (surname!=null) toUpdate.setSurname(surname);
        if (email!=null) toUpdate.setEmail(email);
        if (address!=null) toUpdate.setAddress(email);
        if (phone_number!=null) toUpdate.setPhone_number(phone_number);
        if (postcode!=null) toUpdate.setEmail(email);

        return this.repo.save(toUpdate);

    }
}