package com.kh.springdb.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.kh.springdb.model.Item;
import com.kh.springdb.service.ItemService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ItemController {

	@Autowired
	private final ItemService itemService;
	
	@GetMapping("/")
	public String mainPage(Model model) {
		List<Item> Items=itemService.AllItemView();
		model.addAttribute("Items", Items);
		return "index";
	}
	
	@GetMapping("/item/details/{id}")
	public String detailPage(@PathVariable("id") Integer id,Model model) {
		Item item = itemService.getByItem(id);
		model.addAttribute("items", item);
		return "details";
	}
	
	//상품 전체 목록 페이지로 이동하기 위한 GetMapping
	@GetMapping("/item/list")
	public String itemList(Model model) {
		List<Item> items = itemService.AllItemView();
		model.addAttribute("items", items);
		return "itemList";
		
		
	}
	//상품 등록 페이지로 이동만 하는 애
	@GetMapping("/item/new")
	public String itemSaveForm(Model model) {
		return "addItemForm";
	}
	
	//실제로 DB에 등록하는 애
	@PostMapping("/item/new")
	public String itemSave(Item item, MultipartFile imgFile) throws IllegalStateException, IOException {
		itemService.saveItem(item, imgFile);
		return "redirect:/item/list";
	}

	
}
