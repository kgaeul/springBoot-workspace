package com.kh.springdB.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.kh.springdB.repository.ProductRepository;
import com.kh.springdB.vo.Product;

@Service
public class ProductService {
	
	//final 선언돼서 변경 불가능
	//레퍼지토리를 나타내는 필드
	//인터페이스 사용해서 데이터베이스와 상호작용
	private final ProductRepository productRepository;
	
	@Autowired//생성자를 위한 어노테이션. ProductRepository 타입의 빈을 찾아서 주입
	public ProductService(ProductRepository productRepository) {
		this.productRepository=productRepository;
	}
	
	//모든 상품을 조회하는 메서드
	//findAll 지정된 메서드를 가지고 와서 사용
	public List<Product> getAllProduct(){
		return productRepository.findAll();
	}
	
	//아이디 하나 조회
	public Optional<Product> getProductById(Long id){
		return productRepository.findById(id);
	}
	
	
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
	
	public void deleteProductById(Long id) {
		productRepository.deleteById(id);
	}
}
