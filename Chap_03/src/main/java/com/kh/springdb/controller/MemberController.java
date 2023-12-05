package com.kh.springdb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.springdb.model.vo.MemberVO;
import com.kh.springdb.service.Memberservice;

@Controller
@RequestMapping("member")
public class MemberController {

	@Autowired
	Memberservice ms;
	
	@GetMapping("/search")
	public String selectUser(Model model) {
		List<MemberVO> memberList = new ArrayList<>();
		model.addAttribute("member", model);
		return "member";
	}
	
	@GetMapping("/create")
	public String displayCreateForm(Model model) {
		model.addAttribute("member", new MemberVO());
		return "memberForm";
	}
	
	@PostMapping("/save")
	public String insertMember(@ModelAttribute MemberVO member){
		ms.insertMember(member);
		return "redirect:/member";
		
	}
	

}
