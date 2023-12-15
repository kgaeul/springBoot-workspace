package com.kh.springdb.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kh.springdb.model.product;
import com.kh.springdb.service.CommentService;
import com.kh.springdb.service.ProductService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class ProductController {

	@Autowired
	ProductService pService;
	
	@Autowired
	private CommentService commentService;
	
//	@GetMapping("/product")
//	public String AllProduct(Model model, product p) {
//		List<product> products = pService.ProductList();
//		model.addAttribute("products", products);
//		return "productList";
//	}
	
	//상품 클릭했을 때 상세보기 메서드
	@GetMapping("/product/details/{id}")
	public String ProductDetail(@PathVariable int id,Model model) {
		//상세보기를 검색할 조건
		product p = pService.ProductDetail(id);
		//하나의 아이디 값을 가지고 와서 그 아이디가 속해있는 데이터를 product안에 저장한다는 의미
		model.addAttribute("products",p);
		return "details";
	}
	
	
	//새로운 상품 추가하기
	@GetMapping("/product/new")
	public String productSaveForm(Model model) {
		return "addProductForm";
	}
	
	//새로운 상품 저장하기
	@PostMapping("/product/new")
	public String productSave(product p, MultipartFile imgFile) throws Exception, IOException {
		pService.CreateProduct(p, imgFile);
		return "index";
	}
	
	//상품 정보 수정하기
	@GetMapping("/product/new/{id}")
	public String updateProduct(@PathVariable int productId) {
		return "addProductForm";
	}
	
	
	//페이징 처리
	@GetMapping("/product")
	public String pageList(Model model, @RequestParam(value="page",defaultValue="0")int page){
		//첫페이지를 0으로 설정해서 null방지 우리눈에는 1로 보여도 코드 안에서는 0으로 시작하는 것으로 표기
		//"page"라는 이름으로 받기로 결정
		//@RequestParam-> 어떤 값을 가지고 요청을 할 지 지정하기 위해 이용하는 것!
		
		Page<product> paging = pService.getList(page);
		model.addAttribute("paging", paging);
		return "productList";
	}
	
	//댓글 추가
	@PostMapping("/addComment")
	public String addComment(@RequestParam int productId, @RequestParam String content,@RequestParam int commentId) {
		commentService.addComment(productId, content,commentId);
		return "redirect:/product/details/"+productId;
	}

	//댓글 삭제
	@GetMapping("/deleteComment/{id}")
	public String deleteComment(@PathVariable int id) {
		commentService.deleteComment(id);
		return "redirect:/product";
	}
	
	//좋아요
	@PostMapping("/addLike")
	public String addLike(@RequestParam int productId,@RequestParam int commentId) {
		commentService.addLike(productId,commentId);
		return "redirect:/product";		
	}
}