package com.kh.springdb.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="productPage")
public class product {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="products_seq")
	@SequenceGenerator(name="products_seq",sequenceName="products_seq",allocationSize=1)
	private int id;
	
	//이름
	private String name;
	
	//가격
	private String price;
	
	//재고
	private int stock_quantity;

	//설명
	private String description;
	
	//품절유무
	private boolean isSoldout;
	
	//판매갯수
	private int count;
	
	//이미지 업로드를 위한 파일명, 이미지 경로, 상품 등록 날짜
	private String imgName;
	private String imgPath;
	
	@OneToMany(mappedBy="product", cascade=CascadeType.ALL)
	private List<Comment> comments;
	
	
}
