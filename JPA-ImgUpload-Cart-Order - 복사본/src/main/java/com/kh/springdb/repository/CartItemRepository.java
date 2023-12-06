package com.kh.springdb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.springdb.model.vo.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem,Integer>{

	//CartId itemId로 Cart
	CartItem findByCartIdAndItemID(int cartId, int itemid);
	CartItem findCartItemById(int id);
	List<CartItem> fingCartItemByItemID(int id);
}
