package com.kh.springdb.vo.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.springdb.model.vo.MemberVO;
import com.kh.springdb.repository.memberRepository;

@Mapper
public interface MemberDAO {

	public static final memberRepository mr = null;
	
	//전체 조회
	public static void selectUser(MemberVO model) {
		mr.findAll();
	}
	
	//DB 삽입
	static void insertMember(MemberVO memberId) {
		mr.save(memberId);
	}
		
	
	//수정
	static void uodateMember() {
		mr.findAll();
	}
	
	//삭제
	static void deleteMember(Long Id) {
		mr.deleteById(Id);
	}

}
