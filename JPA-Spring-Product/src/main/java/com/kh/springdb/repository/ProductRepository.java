package com.kh.springdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.springdb.model.product;

public interface ProductRepository extends JpaRepository<product,Integer>{

	product findProductById(int id);
}
