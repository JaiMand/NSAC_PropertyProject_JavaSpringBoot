package com.qa.propertyapp.repo;

import com.qa.propertyapp.model.Bookings;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepo extends CrudRepository<Bookings, Long> {
    List<Bookings> findAll();
}