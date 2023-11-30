package com.kh.cafe.controller;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.cafe.service.service;
import com.kh.cafe.vo.cafe;

@Controller
@RequestMapping("cafe")
public class controller {

	@Autowired
	private service s;
	
	//존재하지 않는다면 그냥 모든 카페내용을 보여주겠다~~
	/*
	 
	 @PathVariable과 @RequestParam의 차이
	 @PathVariable : URL 경로에서 변수 값을 추출
	 @RequestParam
	  */
	@GetMapping
	public String selectCafe(Model model,@RequestParam(required=false)String word){
		List<cafe> cafes;
		if(word !=null && !word.isEmpty()) {
			cafes = s.searchCafe(word);
		}else {
			cafes= s.selectCafe();
		}
		model.addAttribute("cafes",cafes);
		return "cafe";
	}
	
	//추가할거 작성하기
	@GetMapping("/save")
	public String insertCafe(Model model){
		model.addAttribute("cafe",new cafe());
		return "cafesave";
	}
	
	//추가하기
	@PostMapping("/insert")
	public String savecafe(@ModelAttribute cafe c) {
		s.InsertCafe(c);
		return "redirect:/cafe";
	}
	
	//상세페이지 조회
	@GetMapping("/details/{id}")
	public String selectOneCafe(@PathVariable Long id, Model model) {
		Optional<cafe> onecafe = s.selectOneCafe(id);
		onecafe.ifPresent(value -> model.addAttribute("cafe",value));
		return "details";
	}
	
	//수정하기
	@GetMapping("/update/{id}")
	public String updateCafe(@PathVariable Long id, Model model) {
		Optional<cafe> cafeupdate = s.updateCafe(id);
		model.addAttribute("cafe",cafeupdate);
		return "cafesave";
	}
	
	//삭제하기
	@GetMapping("/delete/{id}")
	public String deleteCafe(@PathVariable Long id, Model model) {
		s.deleteCafe(id);
		return "redirect:/cafe";
	}
	
	//검색하기
	@GetMapping("/search")
	public String searchCafe(@RequestParam String word, Model model) {
		List<cafe> searchResult = s.searchCafe(word);
		model.addAttribute("result", searchResult);
		return "searchresult";
	}
	
	@GetMapping ("/deleteAll")
	public String deleteAllCafe() {
		s.alldelete();
		return "redirect:/cafe";
	}
}
