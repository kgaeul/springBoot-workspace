package com.kh.springdb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.springdb.vo.Usermodel;

public interface UserRepository extends JpaRepository <Usermodel,Long>{

	
	
}
