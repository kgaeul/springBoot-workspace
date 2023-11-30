package com.kh.cafe.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kh.cafe.repository.repository;
import com.kh.cafe.vo.cafe;

@Service
public class service {

	
	@Autowired
	private repository r;
	
	public cafe InsertCafe(cafe c){
		return r.save(c);
	}
	
	public List<cafe> selectCafe(){
		return r.findAll();
	}
	
	public Optional<cafe> selectOneCafe(Long id){
		return r.findById(id);
	}
	
	public Optional<cafe> updateCafe(Long id){
		return r.findById(id);
	}
	
	public void  deleteCafe(Long id){
		r.deleteById(id);
	}
	
	public List<cafe> searchCafe(String word){
		return r.findCafe(word);
	}
	
	public void alldelete() {
		r.deleteAll();
	}
}
