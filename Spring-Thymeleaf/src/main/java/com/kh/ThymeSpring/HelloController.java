package com.kh.ThymeSpring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

	@GetMapping
	public String hello(Model model) {
		model.addAttribute("message","MAVER");
		model.addAttribute("message2","집가고 싶은 사람들의 모임");
		
		model.addAttribute("message3","집가서 전기장판 위에서 귤까먹고 싶다");
		return "hello";
	}
	
}
