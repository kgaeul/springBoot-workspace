package com.kh.springdb.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class CartItem {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cartItem_seq")
	@SequenceGenerator(name="cartItem_seq", sequenceName="cartItem_seq", allocationSize=1)
	private int id;
	
	//어떤 아이템인지 알기 위해 Item 클래스를 가지고옴
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="item_id")
	private Item item;
	
	//장바구니에 담아야하기 때문에 장바구니 클래스도 가지고 옴
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="cart_id")
	private Cart cart;
	
	//상품 갯수
	private int count;
	
	public static CartItem createCartItem(/*Cart cart,*/Item item,int amount) {
		CartItem cartitem = new CartItem();
		//cartitem.setCart(cart);
		cartitem.setItem(item);
		cartitem.setCount(amount);
		return cartitem;
	}
	
	//이미 담겨있는 물건이나 또는 담을 물건이 있을 경우 추가
	public void addCount(int count) {
		this.count+=count;
	}
}


/*
카트와 카트아이템의 차이점
사용자가 담거나 주문한 상품들을 담아주는 역할
현재->User연결을 해주지 않아서 큰 의미는 없지만
추후 User와 연결하게 되면 User - Cart와 연관관계가 생길 예정

 
 카트아이템 : 카트에 담긴 각 상품의 정보를 포함. 개별 상품들을 나타냄
 장바구니 역할
 */


