package com.example.starterweb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/hola")
	public String hello() {
		return "Hola a todos!";
	}
	
}
