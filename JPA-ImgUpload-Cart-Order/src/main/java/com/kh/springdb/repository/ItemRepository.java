package com.kh.springdb.repository;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.springdb.model.vo.Cart;
import com.kh.springdb.model.vo.CartItem;
import com.kh.springdb.model.vo.item;

public interface ItemRepository extends JpaRepository<Item,Long>{


}

