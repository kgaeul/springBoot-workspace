package com.kh.springdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.springdb.model.vo.MemberVO;

public interface memberRepository extends JpaRepository <MemberVO,Long> {

}
