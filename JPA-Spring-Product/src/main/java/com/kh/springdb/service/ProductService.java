package com.kh.springdb.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kh.springdb.model.product;
import com.kh.springdb.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository prepository ;
	
	public List<product> ProductList() {
		return prepository.findAll();
	}
	
	public void CreateProduct(product p,MultipartFile imgFile) throws IllegalStateException, IOException {
		String originName = imgFile.getOriginalFilename();
		String projectPath = System.getProperty("user.dir")+"/src/main/resources/static/img/";
		
		File saveFile = new File(projectPath,originName);
		imgFile.transferTo(saveFile);
		
		p.setImgName(projectPath);
		p.setImgPath("/img/"+originName);
		
		prepository.save(p);
	}
	
	
	public product ProductDetail(int id){
		return prepository.findProductById(id);
	}
	
	public Page<product> getList(int page){
		Pageable pageable = PageRequest.of(page,4);
		return prepository.findAll(pageable);
	}
	
}