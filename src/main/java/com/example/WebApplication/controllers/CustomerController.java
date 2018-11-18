package com.example.WebApplication.controllers;

import com.example.WebApplication.domain.Customer;
import com.example.WebApplication.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService service;
    @Autowired
    public void setService(CustomerService service) {
        this.service = service;
    }

    @RequestMapping("/{id}")
    public String showUser(
            @PathVariable Integer id,
    Model model) {
        Customer customer = service.getOne(id);
        model.addAttribute("customer", customer);
        return "customer";
    }
    @RequestMapping("/all")
    public String allCustomers(Model model) {
        List<Customer> all = service.getAll();
        model.addAttribute("customers", all);
        return "customersList";
    }
    @RequestMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Integer id) {
        service.delete(id);
        return "redirect:/customer/all";
    }
    @RequestMapping("/update/{id}")
    public String editCustomer(@PathVariable Integer id, Model model) {
        Customer customer = service.getOne(id);
        model.addAttribute("title", "Edition");
        model.addAttribute("button", "Update");
        model.addAttribute(customer);

        return "customerEdit";
    }
    @PostMapping("/update")
    public String saveCustomer(Customer customer) {
        Customer update;
        if(customer.getId() != null) {

           update = service.update(customer);
        } else {
            update = service.add(customer);;
        }
        return "redirect:/customer/"+ update.getId();
    }
    @GetMapping("/new")
    public String newCustomer(Model model){
        model.addAttribute("customer", new Customer());
        model.addAttribute("title", "Creation");
        model.addAttribute("button", "Create");
        return "customerEdit";
    }

}
