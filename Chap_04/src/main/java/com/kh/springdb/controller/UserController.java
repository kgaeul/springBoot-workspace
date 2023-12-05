package com.kh.springdb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.springdb.service.UserService;
import com.kh.springdb.vo.Usermodel;

@EnableJpaAuditing
@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService us;
	
	@GetMapping
	public String UserList(Model model) {
		List<Usermodel> userList = us.userList();
		model.addAttribute("userList", userList);
		return "user";
	}
	
	@GetMapping("/create")
	public String NewUser(Model model) {
		model.addAttribute("userList", new Usermodel());
		return "user-form";
	}
	
	@PostMapping("/save")
	public String saveUser(@ModelAttribute Usermodel u) {
		us.InsertUser(u);
		return "redirect:/user";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable Long id) {
		us.deleteUser(id);
		return "redirect:/user";
	}
	
	@GetMapping("/detail/{id}")
	public String searchUser(@PathVariable Long id, Model model){
		Optional<Usermodel> searchUser=us.OneUser(id);
		searchUser.ifPresent(value-> model.addAttribute("user", value));
		return "detail";
	}
	
}
