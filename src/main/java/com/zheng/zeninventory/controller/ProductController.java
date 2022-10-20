	package com.zheng.zeninventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.zheng.zeninventory.model.Product;
import com.zheng.zeninventory.model.Supplier;
import com.zheng.zeninventory.service.ProductServices;

import lombok.extern.slf4j.Slf4j;

import com.zheng.zeninventory.service.CustomerServices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
@RequestMapping("/")
public class ProductController {

	@Autowired
	private ProductServices productServices;
	
    @GetMapping("/registerProduct")
    public String showForm(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
         
        return "product_form";
    }
    
    @PostMapping("/registerProduct")
    public String submitForm(@ModelAttribute("product") Product product) {
        productServices.registerProduct(product);
        return "register_product_success";
    }
    
    @GetMapping("/products")
    public String showProducts(Model model) {
    	model.addAttribute("listProducts", productServices.getAllProducts());
        return "products";
    }
    
    @GetMapping("/updateProduct/{id}")
    public String showUpdateForm(@PathVariable(value = "id") long id, Model model) {
        Optional<Product> product = productServices.getProductById(id);
        model.addAttribute("product", product);
        return "product_update_form";
    }
    
    @PostMapping("/updateProduct")
    public String submitUpdateForm(@ModelAttribute("product") Product product, Model model) {
    	long id = product.getProductId();
    	productServices.updateProduct(id,product);
        return showProducts(model);
    }
    
    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable(value = "id") long id) {
    	productServices.deleteProduct(id);
        return "redirect:/products";
    }  
}


