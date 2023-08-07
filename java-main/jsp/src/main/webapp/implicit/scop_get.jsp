<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		String pageName=(String)pageContext.getAttribute("pageName");
		String requestName=(String)request.getAttribute("requestName");
		//브라우저를 종료하면 세션이 소멸되고, 다시 실행하면 새로운 세션과 바인딩 처리되어 기존의 sessionName이 사라짐
		String sessionName=(String)session.getAttribute("sessionName"); 
		//웹 어플리케이션(WAS)를 종료하면 application 객체가 소멸되어 WAS를 재시작(restart)하면 null 문자열이 출력
		String applicationName=(String)application.getAttribute("applicationName"); 
	%>
	<p>pageName =<%=pageName %></p> <!-- 출력안됨 -->
	<p>requestName =<%=requestName %></p> <!-- 출력안됨 -->
	<p>sessionName =<%=sessionName %></p> <!-- 출력 -->
	<p>applicationName =<%=applicationName %></p> <!-- 출력 -->
</body>
</html>