package com.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // (1)@Controller
public class RootController { 

    @GetMapping("/") // (2)@GetMapping
    public String root() {
    	return "redirect:index";
    }
    
    @GetMapping("/index") // (2)@GetMapping
    public String index() {
    	return "index";
    }
}
