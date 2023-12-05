package com.kh.springdb.model.vo;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.User;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.*;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Cart {

	//손님의 장바구니 
	//손님 테이블~,~
	
	@Id
	private int id;
	
	@OneToOne()//fetch와 간련된 타입 작성
	@JoinColumn(name="user_id")
	User user;//구매자의 장바구니
	
	@OneToMany(mappedBy="cart")
	//장바구니 안에 상품들이 담길 예정이기 때문 장바구니는 하나지만 상품은 여러개
	private List<CartItem> cart_items = new ArrayList<>();
}
