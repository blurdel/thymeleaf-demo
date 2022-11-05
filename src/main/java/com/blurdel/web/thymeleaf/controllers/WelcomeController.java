package com.blurdel.web.thymeleaf.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WelcomeController {

	@Value("${welcome.message}")
	private String message;
	
	private List<String> tasks = Arrays.asList("one", "two", "three", "four", "five");
	
	@GetMapping("/hello")
	public String main(Model model, @RequestParam(name="name", required=false, defaultValue="") String name) 
	{
		model.addAttribute("message", name.length() > 0 ? name : message);
		model.addAttribute("tasks", tasks);
		return "welcome";		
	}
	
}
