package com.kh.springDB.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kh.springDB.mapper.ProductMapper;
import com.kh.springDB.model.Product;

@Service
public class ProductService {

	@Autowired
	private ProductMapper productMapper;
	
	public List<Product> getAllProducts(){
		return productMapper.getAllProducts();
	}
}
