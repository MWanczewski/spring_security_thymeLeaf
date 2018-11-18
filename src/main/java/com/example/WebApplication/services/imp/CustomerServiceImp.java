package com.example.WebApplication.services.imp;

import com.example.WebApplication.domain.Customer;
import com.example.WebApplication.services.CustomerService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerServiceImp implements CustomerService {
    private Map<Integer, Customer> customers;

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
        return customers.get(id);
    }

    @Override
    public List<Customer> getAll() {
        return new LinkedList<>(customers.values());
    }

    @Override
    public Customer update(Customer customer) {
        customers.put(customer.getId(), customer);
        return customers.get(customer.getId());
    }

    @Override
    public void delete(Integer id) {
        customers.remove(id);
    }

    @Override
    public Customer add(Customer customer) {
        customer.setId(generatorIdKey());
        customers.put(customer.getId(), customer);
        return customer;
    }
    private Integer generatorIdKey() {
        return Collections.max(customers.keySet()) + 1;
    }

}
