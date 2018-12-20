package com.example.WebApplication.services;

import com.example.WebApplication.domain.Product;

import java.util.List;

public interface ProductService {
    void save(Product product);
    Product update(Product product);
    void delete(Integer id);
    Product add(Product product);
    List<Product> getAll();
    Product getOne (Integer id);

}
