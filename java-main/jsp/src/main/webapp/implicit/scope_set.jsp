<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//내장객체를 이용하여 객체를 속성값으로 저장
	// => 속성명을 이용하여 속성값을 구분 - 내장객체가 다른 경우 같은 이름의 속성명 사용 가능(비권장)
	// => 내장객체에 동일한 속성명이 있는 경우 기존 속성값 대신 새로운 속성값으로 변경 - 덮어쓰기
	
	//page Scope: pageName이라는 String 객체에 홍길동이란 속성값 저장 - 이 JSP 문서에서만 사용
	pageContext.setAttribute("pageName", "홍길동");
	//request Scope - 이 JSP 문서와 스레드가 이동된 JSP 문서에서 사용
	request.setAttribute("requestName", "임꺽정"); 
	//session Scope - 클라이언트가 같으면 모든 JSP 문서에서 사용할 수 있음
	session.setAttribute("sessionName", "전우치"); 
	//application Scope - 클라이언트에 상관없이 모든 JSP 문서에서 사용할 수 있음
	application.setAttribute("applicationName", "일지매"); 

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<h1>객체의 사용범위(Scope)</h1>
	<hr>
	<%
		//내장객체에 저장된 속성값을 속성명으로 구분하여 반환받아 저장
		// => 속성명에 속성값이 없는 경우 null 반환
		// => 속성값을 Object 객체로 반환하므로 반드시 명시전 객체 형변환 사용
		String pageName=(String)pageContext.getAttribute("pageName");
		String requestName=(String)request.getAttribute("requestName");
		String sessionName=(String)session.getAttribute("sessionName");
		String applicationName=(String)application.getAttribute("applicationName");
	%>
	<p>pageName =<%=pageName %></p>
	<p>requestName =<%=requestName %></p>
	<p>sessionName =<%=sessionName %></p>
	<p>applicationName =<%=applicationName %></p>
</body>
</html>