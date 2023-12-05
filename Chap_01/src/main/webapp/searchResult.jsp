<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import= "com.kh.model.vo.dao.DAO"%>
     <%@ page import= "com.kh.model.vo.DTO" %>
     <%@ page import="java.util.*" %>
     
     <%
     List<DTO> userList = (List<DTO>) request.getAttribute("userList");
     %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성공페이지</title>
</head>
<body>
	<h1>성공했습니다</h1>
		<table border="1">
			<tr>
				<th>번호</th>
				<th>아이디</th>
				<th>이름</th>
				<th>나이</th>
			</tr>
		
	<%
			for(DTO u : userList){
			%>
			<tr>
			<td><%=u.getUser_number()%></td>
			<td><%=u.getUser_id()%></td>
			<td><%=u.getUser_name()%></td>
			<td><%=u.getUser_age()%></td>
			</tr>
			<%
			}
			%>
		</table>
</body>
</html>