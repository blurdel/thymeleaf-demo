package com.blurdel.web.thymeleaf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@GetMapping("/demo")
	public String index(Model model) {

		model.addAttribute("message", "Thank you for visiting.");
		return "index";
	}
	
}
