package com.kh.springdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.springdb.model.vo.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem,int>{

}
