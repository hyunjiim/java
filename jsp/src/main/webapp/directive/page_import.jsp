<%-- <%@page import="java.util.ArrayList, java.util.List"%> --%>
<%-- page 디렉티브의 import 속성과 속성값은 자동 완성 기능 사용 --%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	//java.util.List<String> nameList=new java.util.ArrayList<>(); - import를 사용하지 않았을 경우
	List<String> nameList=new ArrayList<>();
	nameList.add("홍길동");
	nameList.add("임꺽정");
	nameList.add("전우치");
	nameList.add("일지매");
	nameList.add("장길산");
%>    
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<h1>page Directive - import 속성</h1>
	<hr>
	<p>page Directive의 import 속성에는 JSP 문서에서 사용할 클래스 또는 인터페이스를 속성값으로
	설정 - 클래스 또는 인터페이스를 패키지로 명확하게 표현하여 제공하기 위해 사용</p>
	<hr>
	<ul>
	<% for(String name: nameList){ %>
		<li><%=name %></li>
	<% } %>
	</ul>
</body>
</html>