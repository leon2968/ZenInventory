package com.zheng.zeninventory.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.zheng.zeninventory.model.User;
import com.zheng.zeninventory.service.UserServices;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
/*
 * Controller for Spring security login
 */
public class AuthController {
	
	private UserServices userService;

    public AuthController(UserServices userService) {
        this.userService = userService;
    }
	
    /*
     * default login page
     */
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    
    /*
     * default register page
     */
    @GetMapping("/registerUser")
    public String showRegistrationForm(Model model) {
    	//model object to store form data
    	User user = new User();
    	model.addAttribute("user",user);
    	return "user_form";
    }
    
    /*
     * controller to handle user registration request
     */
    @PostMapping("/registerUser")
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
    	User existingUser = userService.findUserByEmail(user.getEmail());
    	//register user if email is registered/null/empty, return a warning message
    	if(existingUser != null && existingUser.getEmail()!= null && !existingUser.getEmail().isEmpty()) {
    		log.trace(user.toString());
    		result.rejectValue("email", null, "This email is already registered by another account.");
    	}
    	
    	if(result.hasErrors()) {
    		model.addAttribute("user",user );
    		return "user_form";
    	}
    	
    	userService.saveUser(user);
    	return "redirect:/registerUser?success";
    }
   
}