package com.kh.springDB.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.kh.springDB.model.User;
import com.kh.springDB.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/users-infomation")
	public String getAllUsers(Model model){
		List<User> users = userService.getAllUsers();
		model.addAttribute("users",users);
		return "users-infomation";
	}
	
	@GetMapping("/user-infomation")
	public String getUserByID(@PathVariable int id, Model model) {
		User user =userService.getUserById(id);
		model.addAttribute("user",user);
		return "user-infomation";
	}
	
}
