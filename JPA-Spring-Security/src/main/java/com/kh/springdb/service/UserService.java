package com.kh.springdb.service;

import org.springframework.stereotype.Service;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.kh.springdb.model.SecurityUser;
import com.kh.springdb.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService{

	private final UserRepository userrepository;
	private final PasswordEncoder passwordEncoder;
	
	//회원가입을 할 경우 비밀번호를 암호화해서 DB에 저장할 수 있도록 구현
	public SecurityUser create(String username, String email,String password) {
	SecurityUser user = new SecurityUser();
	user.setEmail(email);
	user.setUsername(username);
	user.setPassword(passwordEncoder.encode(password));
	
	this.userrepository.save(user);
	return user;
	}
}       