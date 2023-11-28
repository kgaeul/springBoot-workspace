package com.kh.springDB.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.springDB.model.User;

@Mapper
public interface UserMapper {

	//모든 유저 조회
	List<User> getAllUsers();
	
	//유저 한명 조회
	User getUserById(int id);
	
}
