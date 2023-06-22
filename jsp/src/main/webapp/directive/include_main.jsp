<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<h1>include Directive</h1>
	<hr>
	<p>현재 서버에 존재하는 자원의 소스코드를 제공받아 JSP 문서에 포함하는 지시어 - 정적포함</p>
	<hr>
	<!-- 아래의 태그를 다른 파일로 만들어 include 태그로 불러오도록 작성 
	<p>클라이언트에게 응답될 아주 중요한 내용입니다.</p>
	<p>클라이언트에게 응답될 아주 중요한 내용입니다.</p>
	<p>클라이언트에게 응답될 아주 중요한 내용입니다.</p>
	<p>클라이언트에게 응답될 아주 중요한 내용입니다.</p>
	<p>클라이언트에게 응답될 아주 중요한 내용입니다.</p>
	<p>클라이언트에게 응답될 아주 중요한 내용입니다.</p>
	<p>클라이언트에게 응답될 아주 중요한 내용입니다.</p>
	<p>클라이언트에게 응답될 아주 중요한 내용입니다.</p>
	<p>클라이언트에게 응답될 아주 중요한 내용입니다.</p>
	<p>클라이언트에게 응답될 아주 중요한 내용입니다.</p>
	<p>클라이언트에게 응답될 아주 중요한 내용입니다.</p>
	<p>클라이언트에게 응답될 아주 중요한 내용입니다.</p>
	 -->
	 
	 <%-- include Directive의 file 속성에 현재 서버 자원의 URL 주소를 속성값으로 설정 --%>
	 <%-- => file 속성값으로 설정된 파일이 없는 경우 에러 발생 => 500 error --%>
	 <%-- => 파일의 소스코드를 얻어와 include Directive 명령 위치에 포함 --%>
	 <%@include file="include_sub.jspf" %>
	 
</body>
</html>