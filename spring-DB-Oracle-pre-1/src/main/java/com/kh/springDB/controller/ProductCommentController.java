package com.kh.springDB.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kh.springDB.service.ProductCommentService;

@Controller
public class ProductCommentController {

	@Autowired
	private ProductCommentService pcs;
	
	@GetMapping("ProductCommentList")
	public String displayProductCommentList(Model model) {
		model.addAttribute("ProductComment",pcs.getAllProductComment());
		return "ProductCommentList";
	}
	
}
