package com.kh.springdb.model.vo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder //모든 필드값을 파라미터로 받을 수 있는 생성자 만들어줌
@AllArgsConstructor//파라미터가 없는 기본 생성자 만들기 Admin ad = new Admin(Admin 클래스 안에 있는 필드 모두 생성)
@NoArgsConstructor//없는것도 쓸수 있게 만들어줌 Admin ad = new Admin();를 대체하는 기능임~,~
@Getter
@Setter
@Entity
public class User {

	@Id
	@GeneratedValue()
	private int id;
	
	@Column(unique=true)
	private String username;
	
	private String password;
	private String name;
	private String email;
	private String address;
	private String phone;
	private String role;
	
	private int pay;
	
	
	/**구매자를 위한 필드**/
	//장바구니
	private Cart cart;
	
	//주문
	private List<Order> order = new ArrayList<>();
	
	//주문 상품 리스트
	private List<order> orderItem = new ArrayList<>();
	
	//구매자 상품 리스트
	private List<판매상품 아이템> 판매상품 변수명 = new ArrayList<>();
	
	//구매자 리스트
	private List<판매> 판매에 대한 변수명;
	
	
	/**판매자를 위한 필드**/
	//판매자 상품 리스트
	private List<판매상품 아이템> 판매상품 변수명 = new ArrayList<>();
	
	//판매 리스트
	private List<판매> 판매에 대한 변수명;
	
	
	/**구매자와 판매자를 위한 필드**/
	//주문 날짜와 판매날짜
	@DateTimeFormat(pattern="yyyy-mm-dd")
	private LocalDate createDate;
}
