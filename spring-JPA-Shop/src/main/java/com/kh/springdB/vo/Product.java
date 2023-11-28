package com.kh.springdB.vo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
//model대신 vo사용


@Getter
@Setter
@Entity
@Table(name="Products")


public class Product {
	
//	@GeneratedValue(strategy=GenerationType.SEQUENCE , generator="sequence_name")
//	@SequenceGenerator(name="product_sequence",
//						sequenceName="product_seq",
//						allocationSize=1)
	//MySQL에서 사용하는 방법 -> 
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//@Column(name="product_id")
	private Long product_id;
	
	//@Column(nullable=false, length=50)
	private String product_name;
	
	//@Column(nullable=false, length=50)
	private String category;
	
	//@Column(name="price")
	private String price;
	
	private int stock_quantity;
}

//테이블이 없으면 테이블을 생성해줌 개꿀!!!!
/*

@Table : 테이블 이름을 지정
@Id : 해당필드가 엔터티의 Primary Key임을 나타내는 것!!!
@Column : 해당 필드가 데이터 베이스 테이블의 컬럼에 매핑되는 것을 확인함
	nullable : 해당 컬럼이 null 값을 허용하는 지 여부를 나타냄
	length : 문자열 컬럼의 최대길이를 지정
	String으로 시작되는 필드값의 경우 String으로 지정된 이름으로 명시되기 때문에 따로 name을 지정해주지 않아도 되지만 String 이외 값은 name을 지정해주어 Column명을 지정해주는 것이 원칙
	
	
	시퀀스를 사용해서 기본키 값을 생성할 수 있도록 지원
	시퀀스는 데이터베이스에서 중복되는 값이 아닌 각 레코드가 고유한 숫자번호를 가질 수 있도록 자동으로 값을 생성해줌!
	@SequenceGenerator : GeneratedValue와 연결할 이름을 지정해주고 시퀀스의 이름과 크기를 지정할 수 있음
	@GeneratedValue : jpa에서 엔터티의 기본 키 값을 자동으로 생성하는 방법을 지정하는 데 사용하는 어노테이션
	
	
	@GeneratedValue(strategy=GenerationType.SEQUENCE , generator="sequence_name")
	@SequenceGenerator(name="product_sequence",
						sequenceName="product_seq",
						allocationSize=1)
						
	데이터베이스 자체에서 자동으로 값이 증가할 수 있도록 자동생성이 들어있는 경우 아래 어노테이션 방식을 사용
	새로운 레코드가 삽입될 때마다 데이터베이스가 자동으로 기본키의 값을 증가시킴
	//MySQL에서 사용하는 방법 -> @GeneratedValue(strategy=GenerationType.IDENTITY)
	
*/

