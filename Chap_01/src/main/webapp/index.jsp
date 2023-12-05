<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import= "com.kh.model.vo.dao.DAO" %>
     <%@ page import= "com.kh.model.vo.DTO"%>
     <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유저 조회</title>
</head>
	<body>
	
		<h1>사용자 조회</h1>
		
			
			<form action="selectUser" method="get">
			<label>사용자 아이디 : </label>
			<input type="text" name="search_user_name">
			
			<input type="submit" name="searchUser" value="검색하기"></input>
			</form>
			
			
	</body>
	
</html>