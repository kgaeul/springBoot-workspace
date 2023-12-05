package com.kh.springdb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.springdb.model.vo.MemberVO;
import com.kh.springdb.vo.dao.MemberDAO;

@Service
public class Memberservice {

	@Autowired
	private MemberDAO dao;
	
	public void insertMember(MemberVO memberId) {
	}
	
}
