package com.kh.springdb.model.vo;

import java.time.LocalDate;
import java.util.*;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Item {

	//상품 아이디
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "item_seq")
	@SequenceGenerator(name="item_seq", sequenceName="item_seq", allocationSize=1)
	private int id;
	
	//상품 이름
	private String name;
	
	//설명
	private String text;
	
	//재고
	private int stock;
	
	private int price;
	
	//판매개수
	private int count;
	
	//상품상태
	private int isSoldout;
	
	
//	@ManyToOne//판매자 한명이 여러개를 팔수도 있어서(판매자 1 : 상품 N)
//	@JoinColumn(name="admin_id")
	//private Admin admin;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "seller_id")
	private User seller;
	
	@OneToMany(mappedBy="item")
	private List<CartItem> cartItems = new ArrayList<>();
	
	
	//상품 사진
	//private String photo;
	
	//상품명 
	private String imgName;
	
	//상품 이미지 위치
	private String imgPath;
	
	
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private LocalDate createDate;
	
	@PrePersist
	public void createDate() {
		this.createDate = LocalDate.now();
	}
}
