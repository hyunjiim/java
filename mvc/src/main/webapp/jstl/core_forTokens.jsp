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
	<h1>Core - 흐름 제어 태그</h1>
	<hr>
	<c:set var="phone" value="010-1234-5678"/>
	<p>전화번호 = ${phone }</p>
	<hr>
	
	<%-- forTokens 태그: 스코프 객체에 저장된 속성값(문자열)을 특정 문자열로 분리하여 반복 처리하는 태그 --%>
	<%-- items 속성: 분리 처리하기 위한 문자열을 속성값으로 설정 --%>
	<%-- => EL을 사용하여 스코프 객체의 속성값을 문자열(String 객체)로 제공받아 사용 가능 --%>
	<%-- delims 속성: 문자열을 분리하기 위한 구분자(문자열)을 속성값으로 설정 --%>
	<%-- var 속성: 분리된 문자열을 하나씩 얻어와 스코프 객체의 속성값으로 저장하기 위한 속성명을 속성값으로 설정 --%>
	<c:forTokens items="${phone }" delims="-" var="num">
		<div>${num }</div>
	</c:forTokens>
<body>

</body>
</html>