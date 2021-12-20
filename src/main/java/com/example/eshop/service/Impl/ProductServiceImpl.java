package com.example.eshop.service.Impl;

import com.example.eshop.model.Category;
import com.example.eshop.model.Manufacturer;
import com.example.eshop.model.Product;
import com.example.eshop.model.exceptions.CategoryNotFoundException;
import com.example.eshop.model.exceptions.ManufacturerNotFoundException;
import com.example.eshop.repository.InMemoryCategoryRepository;
import com.example.eshop.repository.InMemoryManufacturerRepository;
import com.example.eshop.repository.InMemoryProductRepository;
import com.example.eshop.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final InMemoryProductRepository productRepository;
    private final InMemoryCategoryRepository categoryRepository;
    private final InMemoryManufacturerRepository manufacturerRepository;

    public ProductServiceImpl (InMemoryProductRepository productRepository, InMemoryCategoryRepository categoryRepository, InMemoryManufacturerRepository manufacturerRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public List<Product> findAll () {
        return this.productRepository.findAll();
    }

    @Override
    public Optional<Product> findById (Long id) {
        return this.productRepository.findById(id);
    }

    @Override
    public Optional<Product> findByName (String name) {
        return this.productRepository.findByName(name);
    }

    @Override
    public Optional<Product> save (String name, Double price, Integer quantity, Long categoryId, Long manufacturerId) {
        Category category = this.categoryRepository.findById(categoryId).orElseThrow(() -> new CategoryNotFoundException(categoryId));
        Manufacturer manufacturer = this.manufacturerRepository.findById(categoryId).orElseThrow(() -> new ManufacturerNotFoundException(manufacturerId));
        return this.productRepository.save(name,price,quantity,category,manufacturer);
    }

    @Override
    public void deleteById (Long id) {
        this.productRepository.deleteById(id);
    }
}
