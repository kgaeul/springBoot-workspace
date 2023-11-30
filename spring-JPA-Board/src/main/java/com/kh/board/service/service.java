package com.kh.board.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.board.repository.repository;
import com.kh.board.vo.board;

@Service
public class service {
	
	@Autowired
	private final repository rp;
	
	public service(repository rp) {
		this.rp =rp;
	}
	
	//전체조회
	public List<board> getAllBoard(){
		return rp.findAll();
	}

	//상세조회
	public Optional<board> getBoardBiId(Long id){
		return rp.findById(id);
	}
	
	//검색조회
	public List<board> findBoardByTitle(String keyword){
	return rp.findTitle(keyword);
	}
}
