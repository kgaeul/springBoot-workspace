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
public class ItemController {

    private final ItemService itemService;

    // 메인 페이지 html 하나로 통일
    // 메인 페이지 (로그인 안 한 유저) /localhost:8080
    @GetMapping("/index")
    public String mainPageNoneLogin(Model model) {
        // 로그인을 안 한 경우
        List<Item> items = itemService.allItemView();
        model.addAttribute("items", items);
        return "index";
    }

    // 상품 등록 페이지 - 판매자만 가능
    @GetMapping("/item/new")
    public String itemSaveForm(Model model) {
            return "additemForm";
      
    }

    // 상품 등록 (POST) - 판매자만 가능
    @PostMapping("/item/new")
    public String itemSave(Item item, MultipartFile imgFile) throws Exception {
     
            itemService.saveItem(item, imgFile);
            return "redirect:/main";
       
    }



    // 상품 리스트 페이지 - 로그인 안 한 유저
    @GetMapping("/nonlogin/item/list")
    public String itemList(Model model, Item items) {
        model.addAttribute("items", items);
        return "itemList";
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
