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
public class CustomerController {

	@Autowired
	private CustomerServices customerServices;
	
	@Autowired
	private ProductServices productServices;
	
    @GetMapping("/registerCustomer")
    public String showForm(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
         
        return "customer_form";
    }
    
    @PostMapping("/registerCustomer")
    public String submitForm(@ModelAttribute("customer") Customer customer) {
        System.out.println(customer);
        customerServices.addCustomer(customer);
        return "register_customer_success";
    }

}


