package com.kh.springDB.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.springDB.mapper.BoardMapper;
import com.kh.springDB.model.Board;

@Service
public class BoardService {

	@Autowired
	private BoardMapper boardMapper;
	
	public List<Board> getAllBoard(){
		return boardMapper.getAllBoard();
	}
	
}
