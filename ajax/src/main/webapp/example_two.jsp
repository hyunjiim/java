<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//get 방식은 쿼리스트링을 사용하여 값 전달
	String id=request.getParameter("id");
	String name=request.getParameter("name");     
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX</title>
</head>
<body>
	<%=name %>[<%=id %>]님, 안녕하세요.
</body>
</html> 