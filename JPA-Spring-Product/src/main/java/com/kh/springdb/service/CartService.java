package com.kh.springdb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.springdb.model.cart;
import com.kh.springdb.repository.CartRepository;

@Service
public class CartService {

	@Autowired
	private CartRepository crepository;
	
	public List<cart> findAllcart(){
		return crepository.findAll();
	}
	
	public void addCart(cart c) {
		crepository.save(c);
	}
	
}
