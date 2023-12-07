package com.kh.springdb.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class Item {
	
	//id name text price count stock isSoldout
	
	//상품 아이디
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="item_seq")
	@SequenceGenerator(name="item_seq",sequenceName="item_seq", allocationSize=1)
	private int id;
	
	//상품명
	private String name;
	
	//상품 설명
	private String text;
	
	//상품 주문 개수
	private int count;
	
	private String price;
	
	//재고
	private int stock;
	
	//상품 품절 유무
	private boolean isSoldout;
	
	//이미지 업로드를 위한 파일명, 이미지 경로, 상품 등록 날짜
	private String imgName;
	private String imgPath;
	
	@DateTimeFormat(pattern="yyyy-mm-dd")
	private LocalDate createDate;
	
	//DB에 값을 넣을 때 자동으로 생성된 날짜가 들어감..!!내가 찾던거!!!
	@PrePersist
	public void createDate() {
		this.createDate = LocalDate.now();
	}
	
	//판매자가 누구인 지 장바구니에 어떤 아이템이 들어가져 있는지 아직 안적음 어쩌라고

}
