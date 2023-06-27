<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//전달값이 없는 경우 
	if(request.getAttribute("hewon")==null){
		response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		return;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<h1>회원정보확인</h1>
	<hr>
	<jsp:useBean id="hewon" class="xyz.itwill.bean.Hewon" scope="request"/>
	<%--
		Hewon hewon=(Hewon)request.getAttribute("hewon");
	--%>
	<p>이름 = <jsp:getProperty name="hewon" property="name"/></p>
	<p>전화번호 = <jsp:getProperty name="hewon" property="phone"/></p>
	<p>주소 = <jsp:getProperty name="hewon" property="address"/></p>
	
</body>
</html>