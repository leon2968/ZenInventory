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

/*
 * Controller to handle order related requests
 */
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
	
	/*
	 * Method to show a customer order form along with list of customers and products
	 */
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
    
    /*
     * Method to save or update customer order based on conditions,
     * it returns a successful save/update page
     */
    @PostMapping("/saveOrUpdateCustomerOrder")
    public String submitForm(@ModelAttribute("customerOrder") CustomerOrder customerOrder, Model model) {
    	
    	long id = customerOrder.getOrderId();
    	Optional<CustomerOrder> existingCustomerOrder = customerOrderServices.getCustomerOrderById(customerOrder.getOrderId());
    	
    	//use (unknown) to replace customer/product names if they are null
    	Optional<Customer> customer = Optional.ofNullable(customerOrder.getCustomer());
    	String customerName = customer.isPresent()? customer.get().getCustomerName() : "(unknown)";
    	Optional<Product> product = Optional.ofNullable(customerOrder.getProduct());
    	String productName = product.isPresent()? product.get().getProductName() : "(unknown)";
    	
    	//update product quantity
    	int oldPurchaseQuantity = existingCustomerOrder.isPresent()? existingCustomerOrder.get().getPurchaseQuantity():0;
    	updateProductQty(product.get(),oldPurchaseQuantity,customerOrder.getPurchaseQuantity());
    	

    	//update or create new customer order based on database search result
    	if(existingCustomerOrder.isPresent()) {
    		customerOrderServices.updateCustomerOrder(id, customerOrder);
    	} else {
    		System.out.println("New customerOrder");
    		customerOrderServices.createCustomerOrder(customerOrder);
    	}
    	
    	model.addAttribute(customerOrder);
    	model.addAttribute("customerName", customerName);
    	model.addAttribute("productName", productName);
        return "register_customerOrder_success";
    }
    
    /*
     * Method to return the customer order update form along with the customer order id
     */
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
    
    /*
     * Method to return a page of all customer orders
     */
    @GetMapping("/customerOrders")
    public String showOrders(Model model) {
    	List<CustomerOrder> listCustomerOrders = customerOrderServices.getAllCustomerOrders();
    	model.addAttribute("listCustomerOrders",listCustomerOrders);
    	log.trace(listCustomerOrders.get(0).toString());
    	//System.out.println("***************customer order*************\n" + listCustomerOrders.get(0).toString());
        return "customerorders";
    }    
    
    /*
     * Method to return a page of all customer orders
     */
    @GetMapping("/customerOrders/missingInfo")
    public String showOrdersWithMissingInfo(Model model) {
    	List<CustomerOrder> listCustomerOrders = customerOrderServices.getAllCustomerOrdersWithMissingInfo();
    	model.addAttribute("listCustomerOrders",listCustomerOrders);
        return "customerorders";
    } 
    
    
    /*
     * Method to handle customer order delete request and redirects to customer orders page
     */
    @GetMapping("/deleteCustomerOrder/{id}")
    public String deleteOrders(@PathVariable(value = "id") long id) {
    	this.customerOrderServices.deleteCustomerOrder(id);
        return "redirect:/customerOrders";
    }
    
    /*
     * Method is not implemented yet, this is for vendor orders
     */
    @GetMapping("/vendorOrders")
    public String showVendorOrders(Model model) {

        return "orders";
    }   
    
    /*
     * Method to update product quantity
     */
    private void updateProductQty(Product product, int oldPurchaseQty, int newPurchaseQty) {
    	
    	if(product!=null) {
    		int originalQty = product.getProductQuantity();
    		int updatedQty = originalQty - newPurchaseQty +oldPurchaseQty;
    		productServices.updateProductQty(product.getProductId(),updatedQty);
    	}
    }  
}


