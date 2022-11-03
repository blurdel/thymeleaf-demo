package com.blurdel.web.thymeleaf.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blurdel.web.thymeleaf.entities.UserInfo;
import com.blurdel.web.thymeleaf.entities.UserListDto;
import com.blurdel.web.thymeleaf.services.UserService;


@Controller
@RequestMapping("/users")
public class UserController {

	private final UserService userService;

	
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	public String getAllUsers(Model model) {
		List<UserInfo> users = userService.getUsers();
		model.addAttribute("userList", users);
		model.addAttribute("userInfo", new UserInfo());
		return "/users/users";
	}

	@PostMapping
	public String addUser(@ModelAttribute UserInfo userInfo) {
		UserInfo user = userService.saveUser(userInfo);
		if (user == null) {
			throw new RuntimeException("WTF!");
		}
		return "redirect:/users";
	}
	
	
	@GetMapping("/editall")
	public String showEditUsers(Model model) {
		List<UserInfo> users = userService.getUsers();
		System.out.println("users.size() = " + users.size());
		model.addAttribute("form", new UserListDto(users));
		return "/users/list";
	}
	
	@PostMapping("/save")
	public String updateAllUsers(@Valid @ModelAttribute UserListDto form, BindingResult result) {
		if (result.hasErrors()) {
			return "/users/editall";
		}
		userService.saveAll(form.getUserList());
		return "redirect:/users";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable Integer id) {
		userService.delete(id);
		return "redirect:/users";
	}

}
