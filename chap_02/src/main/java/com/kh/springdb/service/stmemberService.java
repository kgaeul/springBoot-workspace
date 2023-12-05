package com.kh.springdb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.kh.springdb.repository.stmemberRepository;
import com.kh.springdb.vo.STMEMBER;

import jakarta.transaction.Transactional;

public class stmemberService {

	
	private final stmemberRepository r;
	
	@Autowired
	public stmemberService(stmemberRepository r) {
		this.r=r;
	}
	
	
	//전체 조회
	public List<STMEMBER> getAllmember(){
		return r.findAll();
	}
	
	//값 저장
	@Transactional //자동으로 값 저장 웬만하면 써주는게 더 좋음
	public STMEMBER saveMember(STMEMBER sm) {
		return r.save(sm);
	}

	//삭제
	public void deleteMemberById(Long id) {
		r.deleteById(id);
	}
	
	public Optional<STMEMBER> updatemember(Long id){
		return r.findById(id);
	}
}

