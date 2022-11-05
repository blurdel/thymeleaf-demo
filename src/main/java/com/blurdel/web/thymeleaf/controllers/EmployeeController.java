package com.blurdel.web.thymeleaf.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blurdel.web.thymeleaf.model.Employee;
import com.blurdel.web.thymeleaf.repositories.EmployeeRepository;


@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeRepository repo;

	@GetMapping
	public String viewHomePage(Model model) {
		model.addAttribute("allemplist", repo.findAll());
		return "employees/index";
	}

	@GetMapping("/addnew")
	public String addNewEmployee(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "employees/newemployee";
	}

	@PostMapping("/save")
	public String saveEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult result) {
		if (result.hasErrors()) {
			return "employees/newemployee";
		}
		repo.save(employee);
		return "redirect:/employee";
	}

	@GetMapping("/update/{id}")
	public String updateForm(@PathVariable(value = "id") int id, Model model) {
		Optional<Employee> employee = repo.findById(id);
		model.addAttribute("employee", employee);
		return "employees/newemployee";
	}

	@GetMapping("/delete/{id}")
    public String deleteThroughId(@PathVariable int id) {
		repo.deleteById(id);
        return "redirect:/employee"; 
    }
	
}
