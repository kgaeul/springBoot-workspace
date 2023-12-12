package com.kh.springdb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kh.springdb.model.cart;
import com.kh.springdb.service.CartService;

@Controller
public class CartController {

	@Autowired
	private CartService cService;
	
	@GetMapping("/cart")
	public String getAllCart(Model model){
		List<cart> cart = cService.findAllcart();
			model.addAttribute("carts", cart);
			return "cartList";
 	}
	
	@GetMapping("/cart/add")
	public String addCart(cart c) {
		cService.addCart(c);
		return "index";
	}
}
