package com.zheng.zeninventory.controller;

import java.util.List;

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
public class AuthController {
	
	private UserServices userService;

    public AuthController(UserServices userService) {
        this.userService = userService;
    }
	
    // handler method to handle login request
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    
    // handler method to handle user registration form request
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
    	//model object to store form data
    	User user = new User();
    	model.addAttribute("user",user);
    	return "user_form";
    }
    
    //handler method to handle user registration form submit request
    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") User userDto, BindingResult result, Model model) {
    	User existingUser = userService.findUserByEmail(userDto.getEmail());
    	//register user if email is registered/null/empty, return a warning message
    	if(existingUser != null && existingUser.getEmail()!= null && !existingUser.getEmail().isEmpty()) {
    		result.rejectValue("email", null, "There is already an account registered with same email");
    	}
    	
    	if(result.hasErrors()) {
    		model.addAttribute("user",userDto);
    		return "/register";
    	}
    	
    	userService.saveUser(userDto);
    	return "redirect:/register?success";
    }
    
//    @GetMapping("/users")
//    public String users(Model model) {
//    	List<User> users = userService.findAllUsers();
//    	
//    	model.addAttribute("users", users);
//    	return "users";
//    }
}