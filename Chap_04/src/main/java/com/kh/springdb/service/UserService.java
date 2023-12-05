package com.kh.springdb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.springdb.repository.UserRepository;
import com.kh.springdb.vo.Usermodel;

@Service
public class UserService {

	@Autowired
	private UserRepository ur;
	
	//전체 조회
	public List<Usermodel> userList(){
		return ur.findAll();
	}
	
	public Optional<Usermodel> OneUser(Long id){
		return ur.findById(id);
	}
	
	//회원추가
	public Usermodel InsertUser(Usermodel u) {
		return ur.save(u);
	}
	
	//유저 삭제
	public void deleteUser(Long id){
		ur.deleteById(id);
	}
}
