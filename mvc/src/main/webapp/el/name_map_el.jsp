<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>EL - Map</h1>
	<hr>
	<%-- . 연산자는 첫번째 표현식과 두번째 표현식을 연결할 때 사용 --%>
	<%-- 스코프 객체의 속성값이 Map 객체인 경우 맵키를 사용하여 맵값을 제공받아 출력 처리 --%>
	<%-- => EL 표현식으로 사용하기 부적절한 문자가 포함된 맵키인 경우 . 연산자로 제공받아 출력 불가능 --%>
	<%-- <p>이름 = ${nameMap.first.name } ${nameMap.second.name }</p> --%>
	
	<%-- Map인 경우에만! --%>
	<%-- 스코프 객체의 속성값이 Map 객체인 경우 EL 표현식으로 사용하기 부적절한 문자가 포함된
	맵키는 EL 표현식에서 . 연산자 대신 [] 연산자를 사용하여 맵값을 제공받아 출력 처리 가능 --%>
	<p>이름 = ${nameMap["first.name"] } ${nameMap["second.name"] }</p>
</body>
</html>