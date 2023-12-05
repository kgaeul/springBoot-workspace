package com.kh.springdb.model.vo;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class item {

	//상품 아이디
	private int id;
	
	//상품 이름
	private String name;
	
	//설명
	private String description;
	
	//재고
	private int stock_quantity;
	
	//판매개수
	private int count;
	
	//상품상태
	private boolean isSale;
	
	
	@ManyToOne//판매자 한명이 여러개를 팔수도 있어서(판매자 1 : 상품 N)
	@JoinColumn(name="admin_id")
	//private Admin admin;
	
	//상품 사진
	private String photo;
	
	//상품명 
	private String photoName;
	
	//상품 이미지 위치
	private String photoPath;
	
	
	private List<CartItem> cart_items = new ArrayList<>();
}
