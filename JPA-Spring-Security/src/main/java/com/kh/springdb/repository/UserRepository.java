package com.kh.springdb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.springdb.model.SecurityUser;

public interface UserRepository extends JpaRepository<SecurityUser,Long>{

	//로그인을 위한 옵션 활용 생성
	Optional<SecurityUser> findByusername(String username);
	
}
