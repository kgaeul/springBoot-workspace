package com.kh.springdb.model.vo;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "orderItem_seq")
	@SequenceGenerator(name="orderItem_seq", sequenceName="orderItem_seq", allocationSize=1)
	private int id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="order_id")
	private Order order;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="user_id")
	private User user;
	
	//상품 주문번호
	private int itemid;
	
	//주문 상품 이름
	private String itemName;
	
	//주문 상품 가격
	private int itemPrice;
	
	//주문 상품 수량
	private int itemCount;
	
	//가격 * 수량 = 총 가격
	private int itemTotalPrice;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="saleItem_id")
	private SaleItem saleItem;
	//장바구니 상품 하나씩 개별 주문

	//주문 취소 여부 1:주문취소 0: 주문 완료
	private int isCancel;
	
	//장바구니 상품 하나씩 개별 주문
	public static OrderItem createOrderItem (int itemId,User user,Item item,int count,Order order,SaleItem saleitem) {

	OrderItem oi = new OrderItem();
	oi.setItemid(itemId);
	oi.setUser(user);
	oi.setOrder(order);
	oi.setItemName(item.getName());
	oi.setItemPrice(item.getPrice());
	
	//최종적으로 몇개를 구매할 것인지에 대한 카운트가 필요함
	oi.setItemCount(count);
	oi.setItemTotalPrice(itemId);
	oi.setSaleItem(saleitem);
	
	return oi;
	
	
		
	}
	
	//장바구니 전체 주문
	public static OrderItem createOrderItem(int itemId,User user,CartItem cartitem,SaleItem saleitem) {
		OrderItem oi = new OrderItem();
		oi.setItemid(itemId);
		oi.setUser(user);
		oi.setItemName(cartitem.getItem().getName());
		oi.setItemPrice(cartitem.getItem().getPrice());
		oi.setItemCount(cartitem.getCount());
		oi.setItemTotalPrice(cartitem.getItem().getPrice()*cartitem.getCount());
		oi.setSaleItem(saleitem);
		
		return oi;
	}
	
}
