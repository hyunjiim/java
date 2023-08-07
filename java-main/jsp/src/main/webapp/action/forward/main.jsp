<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
<style type="text/css">
h1 {
	text-align: center;
}
</style>
</head>
<body>
	<h1>메인페이지</h1>
	<hr>
	<%-- 
	<a href="login.jsp">로그인</a>&nbsp;&nbsp;
	<a href="join.jsp">회원가입</a>&nbsp;&nbsp;
	<a href="cart.jsp">장바구니</a>&nbsp;&nbsp;
	<a href="review.jsp">리뷰</a>&nbsp;&nbsp;
	--%>
	
	<a href="controller.jsp?pageName=login">로그인</a>&nbsp;&nbsp;
	<a href="controller.jsp?pageName=join">회원가입</a>&nbsp;&nbsp;
	<a href="controller.jsp?pageName=cart">장바구니</a>&nbsp;&nbsp;
	<a href="controller.jsp?pageName=review">리뷰</a>&nbsp;&nbsp;
	
</body>
</html>