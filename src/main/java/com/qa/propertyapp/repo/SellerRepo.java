package com.qa.propertyapp.repo;

import com.qa.propertyapp.model.Sellers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SellerRepo extends CrudRepository<Sellers, Long> {
    List<Sellers> findAll();
}