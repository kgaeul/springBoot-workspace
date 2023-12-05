package com.kh.springdb.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.springdb.service.stmemberService;
import com.kh.springdb.vo.STMEMBER;

@Controller
@RequestMapping("/members")
public class stmemberController {

	@Autowired
	private stmemberService s;
	
	@GetMapping
	public String getAllMember(Model model) {
		model.addAttribute("member", s.getAllmember());
		return "memberList";
	}
	
	public String newMember(Model model) {
		model.addAttribute("member",new STMEMBER());
		return "memberform";
	}
	
	@PostMapping("/save")
	public String saveMember(@ModelAttribute STMEMBER sm) {
		s.saveMember(sm);
		return "redirect:/members";
	}
	
	@GetMapping("/update/{memberId}")
	public String updateMember(@PathVariable Long id,Model model) {
		Optional<STMEMBER> member = s.updatemember(id);
		member.ifPresent(value -> model.addAttribute("member",member));
		return "memberform";
	}
	
	@GetMapping("delete/{memberId}")
	public String deleteMember(@PathVariable Long id) {
		s.deleteMemberById(id);
		return "redirect:/members";
	}
	
}
