package com.kh.springDB.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.springDB.mapper.ProductCommentMapper;
import com.kh.springDB.model.ProductComment;

@Service
public class ProductCommentService {

	@Autowired
	private ProductCommentMapper pcm;
	
	public List<ProductComment> getAllProductComment(){
		return pcm.getAllProductComment();
	}
	
}
