package com.kh.springdb.model.vo;

import java.util.List;
import org.apache.catalina.User;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
public class CartItem {

	@Id
	private int id;
	
	//카트테이블 가져오기
	@ManyToOne
	@JoinColumn(name="cart_id")
	private Cart cart;
	
	//아이템 테이블 가져오기
	@JoinColumn(name="item_id")
	private Item item;
	
	//카트에 담긴 상품 갯수
	private int cartCount;
	
}
