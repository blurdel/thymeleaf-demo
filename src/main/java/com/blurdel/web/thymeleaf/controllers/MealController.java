package com.blurdel.web.thymeleaf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MealController {

	@GetMapping("/order")
	public String get(Model model, @RequestParam(required = false) String meal) {
		model.addAttribute("meal", meal);
		return "meals/index";
	}
}
