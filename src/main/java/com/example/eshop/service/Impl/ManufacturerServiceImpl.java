package com.example.eshop.service.Impl;

import com.example.eshop.model.Manufacturer;
import com.example.eshop.repository.impl.InMemoryManufacturerRepository;
import com.example.eshop.repository.jpa.ManufacturerRepository;
import com.example.eshop.service.ManufacturerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    private final ManufacturerRepository manufacturerRepository;

    public ManufacturerServiceImpl (ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public List<Manufacturer> findAll () {
        return this.manufacturerRepository.findAll();
    }

    @Override
    public Optional<Manufacturer> findById (Long id) {
        return this.manufacturerRepository.findById(id);
    }

    @Override
    public Optional<Manufacturer> save (String name, String address) {
        return Optional.of(this.manufacturerRepository.save(new Manufacturer(name, address)));
    }

    @Override
    public void deleteById (Long id) {
        this.manufacturerRepository.deleteById(id);
    }


}
