package com.kh.model.vo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.common.JDBCTeplate;
import com.kh.model.vo.DTO;

public class DAO {
	
	
	//사용자를 조회하는 메서드
	public static List<DTO> selectAllUsers() throws SQLException{
		///커넥션 연결하기 위한 getConnention()
		Connection con = JDBCTeplate.getConnection();
		PreparedStatement ps =null;
		ResultSet rs = null;
		
		//List로 담을 수 있는 배열 생성
		List<DTO> userList = new ArrayList<>();
		
			try {
			String query = "select * from test_user ";
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			
				while (rs.next()) {
					DTO user = new DTO();
					user.setUser_age(rs.getInt("user_number"));
					user.setUser_id(rs.getString("user_id"));
					user.setUser_name(rs.getString("user_name"));
					user.setUser_age(rs.getInt("user_age"));
					
					userList.add(user);
				}
			}finally {
				
			}
		return userList;
	}
	
	
	
	public static List<DTO> selectUser(String search_user_name) throws SQLException{
		///커넥션 연결하기 위한 getConnention()
		Connection con = JDBCTeplate.getConnection();
		PreparedStatement ps =null;
		ResultSet rs = null;
		
		//List로 담을 수 있는 배열 생성
		List<DTO> userList = new ArrayList<>();
		try {
		String query = "select * from test_user where user_name=? ";
		
		ps= con.prepareStatement(query);
		ps.setString(1, search_user_name);
		rs=ps.executeQuery();
		
		while (rs.next()) {
			DTO user = new DTO();
			user.setUser_age(rs.getInt("user_number"));
			user.setUser_id(rs.getString("user_id"));
			user.setUser_name(rs.getString("user_name"));
			user.setUser_age(rs.getInt("user_age"));
			
			userList.add(user);
		}
	} finally {
		
	}
		return userList;
	}
}
