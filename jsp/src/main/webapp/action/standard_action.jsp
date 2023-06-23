<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
<style type="text/css">
span {
	color: skyblue;
	font-weight: bold;
}
</style>
</head>
<body>
	<h1>표준 액션 태그(Standard Action Tag)</h1>
	<hr>
	<p>Java 명령으로 구현해야 하는 기능을 표준 액션 태그로 제공
	- HTML 태그와 구분하기 위해 [jsp] 네임스페이스(NameSpace) 사용 : JSP 태그</p>
	<hr>
	<%-- JSP1의 명령을 읽어들여 응답하는 스레드가 JSP1 문서의 명령을 실행하다가 include 태그가 포함되어 있으면 
	include 태그가 가리키는 JSP2 문서로 결과만을 제공하여 스레드가 이동해 명령을 실행하고 실행결과를 담아 다시 
	JSP1문서로 되돌아 옴 --%>
	<%-- JSP1 문서에서 실행결과(html 태그)만을 가져오기 때문에 JSP2문서에서 JSP1 문서에 작성된 변수 등을 사용할 수 없음--%>
	<p><span>include 태그 </span>: JSP 문서의 스레드를 다른 JSP 문서로 이동하여 실행된 결과(웹문서)를
	제공받아 태그를 사용한 위치에 포함하는 태그</p>
	<%-- JSP1에서 스레드가 JSP1 문서에 작성된 명령을 실행하다 forward 태그가 가리키는 JSP2 문서로 넘어가 응답 결과를 반환--%>
	<%-- JSP1에서는 응답하기 위한 명령만 실행 JSP2에서 응답페이지 출력 --%>
	<%-- 서버측에서 클라이언트가 요청한 페이지가 아닌 다른 페이지로 응답하게 바꿈 --%>
	<p><span>forward 태그 </span>: JSP 문서의 스레드를 다른 JSP 문서로 이동하여 실행된 결과(웹문서)를
	클라이언트에게 전달하여 응답하는 태그</p>
	<%-- include나 forward 태그의 하위태그로만 사용될 수 있음 - 독립된 태그가 아님 --%>
	<p>param 태그 : JSP 문서에서 스레드가 이동된 JSP 문서로 값을 전달하기 위한 태그
	- include 태그와 forward 태그의 하위태그로 실행</p>
	<%-- 스클립틀릿을 줄이기 위해 사용 - 스클립틀릿을 많이 쓰게되면 가독성 떨어짐 --%>
	<p>useBean 태그 : JSP 문서에서 사용할 수 있는 객체를 제공하기 위한 태그
	- 내장객체에 저장된 속성값을 반환받아 제공하거나 새로운 객체를 생성하여 제공</p>
	<p>setProperty 태그 : useBean 태그로 제공된 객체의 필드값을 변경하기 위한 태그
	(Setter 메소드 호출) - useBean 태그의 종속태그</p>
	<p>getProperty 태그 : useBean 태그로 제공된 객체의 필드값을 반환하기 위한 태그
	(Getter 메소드 호출) - useBean 태그의 종속태그</p> 
</body>
</html>