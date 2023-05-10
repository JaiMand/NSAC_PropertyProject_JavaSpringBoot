package com.qa.propertyapp.repo;


import com.qa.propertyapp.model.Properties;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PropertyRepo extends CrudRepository<Properties,Long> {
    List<Properties> findAll();
}