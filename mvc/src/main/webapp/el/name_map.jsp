<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Map<String, String> nameMap=new HashMap<>();

	nameMap.put("first.name", "홍");
	nameMap.put("second.name", "길동");
	
	request.setAttribute("nameMap", nameMap);
	
	request.getRequestDispatcher("name_map_el.jsp").forward(request, response);
	
%>