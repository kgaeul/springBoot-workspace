package com.kh.springdb.model.vo;

import jakarta.persistence.*;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="cartItem_seq")
	@SequenceGenerator(name = "cartItem_seq", sequenceName="cartItem_seq",allocationSize=1)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="cart_id")
    private Cart cart;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="item_id")
    private Item item;

    private int count; // 상품 개수

    public static CartItem createCartItem(Cart cart, Item item, int amount) {
        CartItem cartItem = new CartItem();
        cartItem.setCart(cart);
        cartItem.setItem(item);
        cartItem.setCount(amount);
        return cartItem;
    }

    // 이미 담겨있는 물건 또 담을 경우 수량 증가
    public void addCount(int count) {
        this.count += count;
    }

}