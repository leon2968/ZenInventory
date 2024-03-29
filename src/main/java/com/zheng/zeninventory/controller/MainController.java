package com.zheng.zeninventory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

/*
 * Controller to handle index, about and contact pages
 */
@Controller
@Slf4j
@RequestMapping("/")
public class MainController {
	
	@GetMapping({"/","/home","index"})
    public String showWelcomePage(Model model) {
        return "index";
    } 
	
	@GetMapping("/about")
    public String showAboutPage(Model model) {
        return "about";
    } 
	
	@GetMapping("/contact")
    public String showContactPage(Model model) {
        return "about";
    } 
}
