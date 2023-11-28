package com.kh.springDB.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.kh.springDB.mapper.UserMapper;
import com.kh.springDB.model.User;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	public List<User> getAllUsers(){
		return userMapper.getAllUsers();
	}
	
	public User getUserById(int id) {
		return userMapper.getUserById(id);
	}
}
