package com.zheng.zeninventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.zheng.zeninventory.model.Customer;
import com.zheng.zeninventory.model.Product;
import com.zheng.zeninventory.model.Customer;
import com.zheng.zeninventory.service.CustomerServices;
import com.zheng.zeninventory.service.ProductServices;
import com.zheng.zeninventory.service.CustomerServices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
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
        System.out.println(product);
        productServices.registerProduct(product);
        return "register_product_success";
    }

}


