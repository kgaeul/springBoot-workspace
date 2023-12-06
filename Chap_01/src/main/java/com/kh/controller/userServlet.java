package com.kh.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.model.vo.DTO;
import com.kh.model.vo.dao.DAO;

@WebServlet("/selectUser")
public class userServlet extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//사용자로부터 입력받은 데이터 처리 및 DAO 호출 작업을 수행
			try {
				List<DTO> user = DAO.selectUser(request.getParameter("search_user_name"));
				List<DTO> userList = DAO.selectAllUsers();
				
				//1.값이 일치할 경우
				if(user !=null && !user.isEmpty()) {
						request.setAttribute("userList", user);
						request.getRequestDispatcher("/searchResult.jsp").forward(request, response);
						
				// 2. 전체조회		
				}else {
					request.setAttribute("userList", userList);
					request.getRequestDispatcher("/searchResult.jsp").forward(request, response);
				}
				
			} catch (SQLException e) {
				response.sendRedirect(request.getContextPath()+"/searchError.jsp");
				e.printStackTrace();
	
		}
	}
}
