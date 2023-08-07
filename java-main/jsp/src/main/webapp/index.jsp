<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 템플릿 페이지를 구현한 JSP 문서 --%>
<%-- => 클라이언트의 모든 요청에 대한 응답 결과를 제공하는 JSP 문서 --%>
<%-- => 템플릿 페이지의 몸체부에는 클라이언트 요청에 의해 전달된 값을 이용하여 JSP 문서의 실행
결과를 제공받아 포함 --%>
<%
	//템플릿 페이지 몸체부에 포함되는 JSP 문서에서는 request 객체의 정보 변경 불가능
	// => 템플릿을 제공하는 jsp 문서에 적어야 템플릿 request 객체 정보 변경 가능 
	request.setCharacterEncoding("utf-8");

	String group=request.getParameter("group");
	if(group==null) group="main";
	
	String worker=request.getParameter("worker");
	if(worker==null) worker="main_page";
	
	String contentPath=group+"/"+worker+".jsp";
	
	String headerPath="header_main.jsp";
	if(group.equals("admin")){
		headerPath="header_admin.jsp";
	}
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="header">
		<%-- <jsp:include page="header_main.jsp"/> --%>
		<jsp:include page="<%=headerPath %>"/>
	</div>
	<%-- jsp:include로 포함시킨 문서에서는 response.sendRedirect가 작동하지 않음 --%>
	<%-- => <%%> 사이에서 request와 response 등의 요청 응답이 종료되므로 response 상태 변화 불가능 --%>
	<%-- => 페이지 생성 순서: <%%>로 감싸져 있는 스크립틀릿 - <jsp/>로 시작되는 액션태그 - <html>,<style>,<script> --%>
	<div id="content">
		<jsp:include page="<%=contentPath %>"/>
	</div>
	
	<div id="footer">
		<jsp:include page="footer.jsp"/>
	</div>
</body>
</html>