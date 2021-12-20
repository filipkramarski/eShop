package com.example.eshop.repository;

import com.example.eshop.bootstrap.DataHolder;
import com.example.eshop.model.Manufacturer;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryManufacturerRepository {

    public List<Manufacturer> findAll(){
        return DataHolder.manufacturers;
    }

    public Optional<Manufacturer> findById(Long id) {
        return DataHolder.manufacturers.stream().filter(i -> i.getId().equals(id)).findFirst();
    }
}
