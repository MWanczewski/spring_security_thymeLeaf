package com.example.WebApplication.services;

import com.example.WebApplication.domain.Customer;

import java.util.List;

public interface CustomerService {
    //CRUD create read update delete
    void save(Customer customer);//C
    Customer getOne(Integer id);//R
    List<Customer> getAll();
    Customer update(Customer customer);//U
    void delete(Integer id); //D
    Customer add(Customer customer);
}
