package com.example.WebApplication.services.imp;

import com.example.WebApplication.domain.Product;
import com.example.WebApplication.repositories.ProductRepository;
import com.example.WebApplication.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Service
public class ProductServiceImp implements ProductService {
  @Autowired
   ProductRepository repo;
    @Override
    public void save(Product product) {

    }

    @Override
    public Product update(Product product) {
        Product one = repo.findById(product.getId()).get();
        repo.save(one);
        return one;
    }

    @Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public Product add(Product product) {
        return repo.save(product);

    }

    @Override
    public List<Product> getAll() {
        Iterable<Product> iterable = repo.findAll();
        List<Product> all = new LinkedList<>();
        for(Product product : iterable) {
            all.add(product);
        }
        return all;
    }

    @Override
    public Product getOne(Integer id) {
        return repo.findById(id).get();
    }

}
