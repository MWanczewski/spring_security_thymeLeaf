package com.example.WebApplication.repositories;

import com.example.WebApplication.domain.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository  extends CrudRepository<Customer, Integer> {
}
