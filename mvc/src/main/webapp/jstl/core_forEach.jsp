<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>Core - 반복 처리 태그</h1>
	<hr>
	<%-- forEach 태그: 태그내용을 반복적으로 포함하기 위한 태그 --%>
	<%-- var 속성: 스코프 객체에 저장된 속성값(객체)의 속성명을 속성값으로 설정 --%>
	<%-- begin 속성: 스코프 객체에 저장될 시작값(Integer)을 속성값으로 설정 --%>
	<%-- end 속성: 스코프 객체에 저장될 종료값(Integer)을 속성값으로 설정 --%>
	<%-- step 속성: 스코프 객체에 저장될 증가값(Integer)을 속성값으로 설정 --%>
	<c:forEach var="i" begin="1" end="5" step="1">
		<p>${i }번째 출력되는 내용입니다.</p>		
	</c:forEach>
	<hr>
	
	<%-- 1~100 범위의 정수들의 합계를 계산하여 출력 --%>
	<c:forEach var="i" begin="1" end="100" step="1">
		<c:set var="sum" value="${sum + i }"/>
	</c:forEach>
	<p>1~100 범위의 정수들의 합계 = ${sum }</p>
	<hr>
	
	<%-- 구구단을 표(Table) 형식으로 출력 --%>
	<table>
		<c:forEach var="i" begin="1" end="9" step="1">
			<tr>
			<c:forEach var="j" begin="2" end="9" step="1">
				<td width="100">${j } * ${i } = ${j * i }</td>
			</c:forEach>
			</tr>
		</c:forEach>
	</table>
</body>
</html>