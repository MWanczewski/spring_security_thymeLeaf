package com.example.WebApplication.services.imp;

import com.example.WebApplication.domain.Customer;
import com.example.WebApplication.repositories.CustomerRepository;
import com.example.WebApplication.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerServiceImp implements CustomerService {
    private Map<Integer, Customer> customers;

    @Autowired
    private CustomerRepository repo;
    public CustomerServiceImp() {
        customers = new HashMap<>();
        for(int i = 2; i < 52; i++) {
            Customer customer = new Customer();
            customer.setFirstName("Mark" + i);
            customer.setLastName("Ros" + i);
            customer.setAddressLine("Street" + i);
            customer.setCity("Eastworld " + i);
            customer.setId(i);
            customer.setEmail(i + "@gmail.com");
            customer.setZipCode("12-" + i);
            customer.setPhoneNumber("403 304 12" + i);
            customers.put(i, customer);
        }
    }

    @Override
    public void save(Customer customer) {

    }

    @Override
    public Customer getOne(Integer id) {
        return repo.findById(id).get();
    }

    @Override
    public List<Customer> getAll() {
        Iterable<Customer> all = repo.findAll();

        List<Customer> list =  new LinkedList<>();
        for (Customer c: all) {
            list.add(c);
        }
        return list;
    }

    @Override
    public Customer update(Customer customer) {
        Customer one = getOne(customer.getId());
        customer.setId(one.getId());
        repo.save(customer);
        return customer;
    }

    @Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public Customer add(Customer customer) {
        repo.save(customer);
        return customer;
    }
    private Integer generatorIdKey() {
        return Collections.max(customers.keySet()) + 1;
    }

}
