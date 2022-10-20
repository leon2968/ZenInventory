package com.zheng.zeninventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.zheng.zeninventory.model.Customer;
import com.zheng.zeninventory.model.CustomerOrder;
import com.zheng.zeninventory.model.Product;
import com.zheng.zeninventory.model.Customer;
import com.zheng.zeninventory.service.CustomerOrderServices;
import com.zheng.zeninventory.service.CustomerServices;
import com.zheng.zeninventory.service.ProductServices;
import com.zheng.zeninventory.service.VendorOrderServices;

import lombok.extern.slf4j.Slf4j;

import com.zheng.zeninventory.service.CustomerServices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
@RequestMapping("/")
public class OrdersController {
	
	@Autowired
	private CustomerOrderServices customerOrderServices;
	
	@Autowired
	private VendorOrderServices vendorOrderServices;
	
	@Autowired
	private CustomerServices customerServices;
	
	@Autowired
	private ProductServices productServices;
	
    @GetMapping("/registerCustomerOrder")
    public String showForm(Model model) {
        CustomerOrder newOrder = new CustomerOrder();
    	List<Customer> listCustomers = customerServices.getAllCustomers();
        List<Product> listProducts = productServices.getAllProducts();
        model.addAttribute("listCustomers",listCustomers);
        model.addAttribute("listProducts",listProducts);
        model.addAttribute("customerOrder", newOrder);
        
        return "customerorder_form";
    }
    
    @PostMapping("/saveOrUpdateCustomerOrder")
    public String submitForm(@ModelAttribute("customerOrder") CustomerOrder customerOrder, Model model) {
    	
    	//update or create new customer order based on database search result
    	long id = customerOrder.getOrderId();
    	Optional<CustomerOrder> existingCustomerOrder = customerOrderServices.getCustomerOrderById(customerOrder.getOrderId());
    	
    	if(existingCustomerOrder.isPresent()) {
    		System.out.println("Existing customerOrder");
    		customerOrderServices.updateCustomerOrder(id, customerOrder);
    	} else {
    		System.out.println("New customerOrder");
    		customerOrderServices.createCustomerOrder(customerOrder);
    	}
    	
    	//use (unknown) to replace names if they are null
    	Optional<Customer> customer = Optional.ofNullable(customerOrder.getCustomer());
    	String customerName = customer.isPresent()? customer.get().getCustomerName() : "(unknown)";
    	
    	Optional<Product> product = Optional.ofNullable(customerOrder.getProduct());
    	String productName = product.isPresent()? product.get().getProductName() : "(unknown)";
    	
    	model.addAttribute(customerOrder);
    	model.addAttribute("customerName", customerName);
    	model.addAttribute("productName", productName);
        return "register_customerOrder_success";
    }
    
    @GetMapping("/updateCustomerOrder/{id}")
    public String showUpdateForm(@PathVariable(value = "id") long id, Model model) {
        Optional<CustomerOrder> customerOrder = customerOrderServices.getCustomerOrderById(id);
        model.addAttribute("customerOrder", customerOrder);
        
    	List<Customer> listCustomers = customerServices.getAllCustomers();
        List<Product> listProducts = productServices.getAllProducts();
        model.addAttribute("listCustomers",listCustomers);
        model.addAttribute("listProducts",listProducts); 
        
        model.addAttribute("updateForm","updateForm");
        return "customerorder_form";
    }
    
//    @PostMapping("/updateCustomerOrder")
//    public String submitUpdateForm(@ModelAttribute("customerOrder") CustomerOrder customerOrder, Model model) {
//        //System.out.println(customer);
//    	long id = customerOrder.getOrderId();
//    	System.out.println(customerOrder.toString());
//        customerOrderServices.updateCustomerOrder(id,customerOrder);
//        return "redirect:/customerOrders";
//    }
    
    @GetMapping("/customerOrders")
    public String showOrders(Model model) {
    	List<CustomerOrder> listCustomerOrders = customerOrderServices.getAllCustomerOrders();
    	model.addAttribute("listCustomerOrders",listCustomerOrders);
    	log.trace(listCustomerOrders.get(0).toString());
    	//System.out.println("***************customer order*************\n" + listCustomerOrders.get(0).toString());
        return "customerorders";
    }    
    
    @GetMapping("/deleteCustomerOrder/{id}")
    public String deleteOrders(@PathVariable(value = "id") long id) {
    	this.customerOrderServices.deleteCustomerOrder(id);
        return "redirect:/customerOrders";
    }
    
    @GetMapping("/vendorOrders")
    public String showVendorOrders(Model model) {

        return "orders";
    }   
}


