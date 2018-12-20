package com.example.WebApplication.controllers;

import com.example.WebApplication.domain.Product;
import com.example.WebApplication.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    private ProductService service;
    @Autowired
    public void serService(ProductService service) {
        this.service = service;
    }
    @RequestMapping("/{id}")
    public String showProduct(@PathVariable Integer id, Model model) {
        Product product = service.getOne(id);
        return "product";
    }
    @RequestMapping("/all")
    public String allProducts(Model model){
        List<Product> all = service.getAll();
        model.addAttribute("products", all);
        return "productList";
    }
    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        service.delete(id);
        return "redirect:/customer/all";
    }
    @RequestMapping("/update/{id}")
    public String editProduct(@PathVariable Integer id, Model model) {
        Product product = service.getOne(id);
        model.addAttribute("title", "Edition");
        model.addAttribute("button", "Update");
        model.addAttribute(product);

        return "productEdit";
    }
    @RequestMapping("/addToBucket/{id}")
    public String addToBucket(@PathVariable Integer id, Model model) {
        Product product = service.getOne(id);
        model.addAttribute("title", "Your Products");
        model.addAttribute(product);

        return "bucket";
    }
}
