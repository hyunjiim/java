<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%-- 선언문(Declaration): 필드 또는 메소드를 선언하는 명령을 작성하는 영역 제공 --%>
 <%-- => 서블릿 클래스의 명령으로 해석 --%>
 <%! //[%!]: 필드 또는 메소드 선언하는 영역을 표현
 
 	//서블릿 객체에 필요한 값을 저장하기 위한 필드
 	// => 필드는 서블릿 객체가 메모리에서 없어지면 자동 소멸
 	int count=0;
 %>
 
 <%-- 스클립틀릿(Scriptlet): 요청을 처리하기 위한 Java 명령을 작성하는 영역 제공 --%>
 <%-- => 요청 처리 메소드의 명령으로 해석 --%>
 <%
 	//요청 처리 메소드에서 생성되어 사용되는 지역변수
 	// => 지역변수는 변수가 선언된 메소드 종료시 자동 소멸
 	//int count=0;
 	
 	count++;
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<h1>스크립트 요소(Script Element)</h1>
	<hr>
	<%-- out 객체: JSP 문서의 처리결과를 저장한 파일을 생성하기 위한 출력스트림 --%>
	<%-- <p>JSP 문서의 요청 횟수 = <% out.println(count); %></p> --%>
	
	<%-- 표현식(Expression): 값(변수값, 연산결과값, 메소드반환값)을 응답파일에 포함하기 위한 영역 제공 --%>
	<p>JSP 문서의 요청 횟수 = <%=count %></p>
</body>
</html>