package com.kh.springdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.springdb.model.user;

public interface UserRepository extends JpaRepository<user,Integer>{

}
