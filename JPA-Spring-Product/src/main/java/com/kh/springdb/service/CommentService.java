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
		}
		
		Comment comment = new Comment();
		comment.setProduct(p);
		comment.setContent(content);
		return commentrepository.save(comment);
	}
}
