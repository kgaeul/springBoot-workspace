package com.kh.springdb.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name="comments")
public class Comment {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="comment_seq")
	@SequenceGenerator(name="comment_seq", sequenceName="comment_seq", allocationSize=1)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	private product product;
	
	private String content;
	
	private String name;
}


