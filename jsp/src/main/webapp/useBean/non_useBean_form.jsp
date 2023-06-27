<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- useBean Tag 사용 이유: JSP 문서의 간결성을 위해 스클립틀릿 같은 Java 코드를 최소화하는 방법 --%>
<%-- useBean을 사용하지 않고 작성하는 방법 --%>
<%-- 사용자로부터 회원정보를 입력받기 위한 JSP 문서 --%>
<%-- => [회원등록] 태그를 클릭한 경우 [non_useBean_action.jsp] 문서를 요청하여 이동 - 입력값(회원정보) 전달 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP_useBean</title>
</head>
<body>
	<h1>회원정보등록</h1>
	<hr>
	<form action="non_useBean_action.jsp" method="post">
	<table>
		<tr>
			<td>이름</td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td><input type="text" name="phone"></td>
		</tr>
		<tr>
			<td>주소</td>
			<td><input type="text" name="address"></td>
		</tr>
		<tr>
			<td colspan="2"><button type="submit">회원등록</button></td>
		</tr>
	</table>
	</form>
</body>
</html>