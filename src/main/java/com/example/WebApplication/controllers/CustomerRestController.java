package com.example.WebApplication.controllers;

import com.example.WebApplication.domain.Customer;
import com.example.WebApplication.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
public class CustomerRestController {

    private CustomerService service;
    @Autowired
    public void setService(CustomerService service) {
        this.service = service;
    }

//    @RequestMapping("/{id}")
//    public String showUser(
//            @PathVariable Integer id,
//            Model model) {
//        Customer customer = service.getOne(id);
//        model.addAttribute("customer", customer);
//        return "customer";
//    }
    @RequestMapping("/all")
   public List<Customer> getCustomers(){
        return service.getAll();
    }
    @RequestMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Integer id) {
        service.delete(id);
        return "redirect:/customer/all";
   }
//    @RequestMapping("/update/{id}")
//    public String editCustomer(@PathVariable Integer id, Model model) {
//        Customer customer = service.getOne(id);
//        model.addAttribute("title", "Edition");
//        model.addAttribute("button", "Update");
//        model.addAttribute(customer);
//
//        return "customerEdit";
//    }
//    @PostMapping("/update")
//    public String saveCustomer(Customer customer) {
//        Customer update;
//        if(customer.getId() != null) {
//
//            update = service.update(customer);
//        } else {
//            update = service.add(customer);
//        }
//        return "redirect:/customer/"+ update.getId();
//    }
//    @GetMapping("/new")
//    public String newCustomer(Model model){
//        model.addAttribute("customer", new Customer());
//        model.addAttribute("title", "Creation");
//        model.addAttribute("button", "Create");
//        return "customerEdit";
//    }

}