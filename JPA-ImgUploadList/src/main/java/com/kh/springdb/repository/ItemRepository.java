package com.kh.springdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.springdb.model.Item;

public interface ItemRepository extends JpaRepository<Item,Integer>{

	Item findItemById(Integer id);
}
