package com.kh.springdb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.springdb.model.Comment;
import com.kh.springdb.model.product;
import com.kh.springdb.repository.ProductRepository;
import com.kh.springdb.repository.commentRepository;

@Service
public class CommentService {

	@Autowired
	private commentRepository commentrepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	public Comment addComment(int productId, String content) {
		product p = productRepository.findById(productId).orElse(null);
		
		if(p==null) {
			throw new RuntimeException("찾는 상품은 존재하지 않습니다");
			//RuntimeException 클래스들은 주로 프로그래머의 실수에 의해서 발생할 수 있는 예외들로서 자바의 프로그래밍 요소와 관계가 깊다.--> 프로그래머의 실수로 발생하는 예외
		}
		
		Comment comment = new Comment();
		comment.setProduct(p);
		comment.setContent(content);
		return commentrepository.save(comment);
	}
	
	public void deleteComment(int id) {
		commentrepository.deleteById(id);
	}
	
}
