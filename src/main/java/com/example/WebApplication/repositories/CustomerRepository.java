package com.example.WebApplication.repositories;

import com.example.WebApplication.domain.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository  extends CrudRepository<Customer, Integer> {
}
