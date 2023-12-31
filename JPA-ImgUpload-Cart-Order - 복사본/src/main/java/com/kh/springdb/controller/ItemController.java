package com.kh.springdb.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;


import com.kh.springdb.model.vo.Item;
import com.kh.springdb.service.ItemService;



@Controller
@RequiredArgsConstructor
//@notnull로 표시된 필드를 사용해서 생성자를 생성
public class ItemController {

	//@Autowired
	private final ItemService itemservice;
	
	@GetMapping("/")
	public String mainPage(Model model) {
		List<Item> items = itemservice.allItemList();
		model.addAttribute("items", items);
		return "/index";
	}
	/*
	@GetMapping()
	public String itemList(Model model) {
		List<Item> items = service.allItemList();
		model.addAttribute("items", items);
		return "itemList";
	}
	*/
//	@GetMapping("/new.list")
//	public String itemList(Model model, @PageableDefault(size=12) Pageable pageable,@RequestParam(name="keyword", required=false)String keyword) {
//		Page<item> items = ItemService.getItemByPage(pageable);
//		
//		//검색을 하지 않고 페이징 처리할 경우
//		return "itemList";
//	}
	
	//추가할 거 작성
	@GetMapping("/new")
	public String addItem(Model model) {
		return "addItemForm";
	}
	
	//저장
	@PostMapping("/save")
	public String saveItem(Item item, MultipartFile photoFile) throws Exception {
		itemservice.addItem(item, photoFile);
		return "redirect:/itemList";
	}
	
	//상세
	@GetMapping("/view/{id}")
	public String viewItem(Model model, @PathVariable("id") Integer id) {
		model.addAttribute("item", itemservice.getItemById(id));
		return "viewItem";
	}
	
	//수정
	
	
	//삭제
	@GetMapping("/delete/{id}")
	public String deleteItem(@PathVariable("id") Integer id) {
		itemservice.itemDelete(id);
		return "redirect:/itemList";
	}
}



/*
@RequireArgsConstuctor : 이 어노테이션이 적용된 클래스는 필수로 초기화해야하는
final 필드나 @NotNull로 표시된 필드를 사용하는 생성자를 자동으로 생성해준다.

	[예제] -----------------------------------------|
	|                                               |
	| @RequireArgsConstuctor
	| public class Student(){
	|	private final String name;
		private String address;
		
		name과 grade는 생성자에 포함되지만 
		adress는 생성자에 포함되지 않음
		
		나중에 Student 객체를 다른데서 불러올 때 Student st = new Student("이름",5);
		address는 넣어주지 않음 final이나 notnull 붙은 것만 생성자 만드니까 adress는 생성자가 생성되지 않았기 때뭉~~
	}
*/
