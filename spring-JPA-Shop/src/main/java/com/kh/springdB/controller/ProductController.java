package com.kh.springdB.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.springdB.service.ProductService;
import com.kh.springdB.vo.Product;

@Controller//리턴이 html 파일 @RestContoller는 html로 안감
@RequestMapping("/product_list")
public class ProductController {

	
	private final ProductService productService;
	
	@Autowired
	public ProductController(ProductService productService) {
		this.productService=productService;
	}
	
	//모든 제품 보기
	@GetMapping("/list")
	public String getAllProduct(Model model) {
		List<Product> p = productService.getAllProduct();
		model.addAttribute("products",p);
		return "product_list";
	}
	
	//하나의 제품 상세보기
	@GetMapping("/detail/{id}")
	public String getProductById(@PathVariable Long id,Model model){
		 Optional<Product> p=productService.getProductById(id);
		 p.ifPresent(value -> model.addAttribute("product",value));
		return "product_detail";
	}
	
	//작성한 내용을 저장
	@GetMapping("/new")
	public String showProductForm(Model model) {
		model.addAttribute("product",new Product());
		return "product_form";
	}
	
	//추가하기
	@PostMapping("/save")
	public String saveProduct(@ModelAttribute Product product ) {
		productService.saveProduct(product );
		return "redirect:/products";
	}
	
	//삭제하기
	@GetMapping("/delete{id}")
	public String deleteProduct(@PathVariable Long id) {
		productService.deleteProductById(id);
		return "redirect:/products";
	}
}
