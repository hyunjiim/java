<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<h1>메일페이지</h1>
<%-- href로 왜 index.jsp만 불러올까? --%>
<%-- index.jsp를 요청할 때 메일,블로그,카페마다 다른 헤더가 적용되도록 할 것 --%>
<a href="index.jsp?category=mail">메일(Mail)</a>&nbsp;&nbsp;
<a href="index.jsp?category=blog">블로그(Blog)</a>&nbsp;&nbsp;
<a href="index.jsp?category=cafe">카페(Cafe)</a>&nbsp;&nbsp;
<hr>