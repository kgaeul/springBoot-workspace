package com.kh.springdb.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kh.springdb.model.Item;
import com.kh.springdb.repository.ItemRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;
	
	//모든 상품 리스트 불러오기
	public List<Item> AllItemView(){
		return itemRepository.findAll();
	}
	
	
	//상품을 등록할 수 있는 메서드
	//이미지를 넣어주기 위해서 파일을 파라미터에 받겠다 작성해줄것
	public void saveItem(Item item, MultipartFile imgFile) throws IllegalStateException, IOException {
		
		//파일 원본 이름
		String originName = imgFile.getOriginalFilename();
		
		//이미지 파일 경로
		String projectPath = System.getProperty("user.dir")+"/src/main/resources/static/img/";
		
		//파일 객체 생성
		File saveFile = new File(projectPath,originName);
		imgFile.transferTo(saveFile);
		
		item.setImgName(projectPath);
		item.setImgPath("/img/"+originName);
		
		
		itemRepository.save(item);
		
	}
	
	//아이템 상세보기나 수정하기를 할 수 있는 메서드 작성
	public Item getItemById(int id){
		return itemRepository.findItemById(id);
		
	}
	
}
