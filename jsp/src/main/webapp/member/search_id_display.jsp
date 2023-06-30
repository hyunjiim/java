<%@page import="xyz.itwill.dao.MemberDAO"%>
<%@page import="xyz.itwill.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- 아이디 정보 보여주는 JSP 문서 --%>

<% 
	//GET 방식으로 요청된 경우 - 잘못된 요청 방법
	if(request.getMethod().equals("GET")){
		out.println("<script type='text/javascript'>");
		out.println("location.href='"+request.getContextPath()+"/index.jsp?group=error&worker=error_400'");
		out.println("</script>");
		return;
	}

	//POST 방식으로 요청하여 전달된 값에 대한 캐릭터셋 변경
	// => 템플릿 페이지 몸체부에 포함되는 JSP 문서에서는 request 객체의 정보 변경 불가능
	// => 템플릿 페이지(index.jsp)에서 request 객체의 정보 변경
	//request.setCharacterEncoding("utf-8");
	
	//전달값을 반환받아 저장
	String name=request.getParameter("name");
	String email=request.getParameter("email");
	
	//DTO 객체를 생성하여 전달값으로 필드값 변경
	MemberDTO member= new MemberDTO();
	member.setName(name);
	member.setEmail(email);
	
	//회원정보를 전달받아 MEMBER 
	String id=MemberDAO.getDAO().selectMemberId(member);

%>
<h1>아이디 검색 결과</h1>
<%if(id!=null){  //검색 결과가 있는 경우%>
	<p style="font-size: 1.5em;"><%=name %>님의 아이디는 [<%=id %>]입니다.</p>
<%} else{ %>
	<p style="font-size: 1.5em;" id="message"><%=name %>님의 회원정보가 존재하지 않습니다.</p>
<% } %>