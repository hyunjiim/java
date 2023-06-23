<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<!-- 객체를 생성하지 않고 9개의 내장객체를 사용할 수 있음 -->
	<h1>내장객체(Implicit Object)</h1>
	<hr>
	<p>내장객체 : WAS 프로그램에 의해 JSP 문서에서 사용되도록 제공되는 Java 객체</p>
	<hr>
	<%-- page(HttpJspPage)는 class에서의 this 역할과 유사 - this처럼 잘 쓰지 않음 --%>
	<p>page(HttpJspPage): JSP 문서정보를 제공하기 위한 객체</p>
	<%-- contextParam으로 servlet에서는 써도 JSP에서는 잘 사용하지 않음 --%>
	<p>config(ServletConfig): WAS 프로그램에 등록된 환경설정 값을 제공하기 위한 객체</p>
	<%-- JSP Expression을 사용하면 out 객체를 사용하지 않아도 자바 변수값, 메소드 반환값 등을 문자값으로 변환하여 출력스트림으로 제공 --%>
	<p>out(JspWriter): 클라이언트에게 응답될 문서파일을 생성하기 위한 객체 - 출력스트림</p>
	<%-- request, response 객체 중요 --%>
	<p>request(HttpServletRequest): 클라이언트의 요청정보를 제공하기 위한 객체</p>
	<p>response(HttpServletResponse): 클라이언트의 응답정보를 제공하기 위한 객체</p>
	<%-- 세션은 클라이언트가 보내온 JSESSION 쿠키가 있음 바인딩하여 제공, 없으면 세션을 검색(트랙팅)하여 바인딩한 다음 제공 --%>
	<%-- 세션객체는 클라이언트에 따라 다르며 로그인과 관련해 클라이언트마다 다른 권한 관련 정보가 저장된 객체를 저장하여 권한관련
	 처리하기 위해 사용--%>
	<p>session(HttpSession): 서버와 클라이언트의 연결 지속성을 제공하기 위한 객체</p>
	<p>application(ServletContext): 웹자원(WebContext)을 관리하는 정보를 제공하기 위한 객체 - WAS</p>
	<p>pageContext(PageContext): 웹프로그램 작성에 필요한 객체를 제공하기 위한 객체</p>
	<%-- isErrorPage 속성값의 초기값은 false - 에러페이지 잘 만들지 않음 --%>
	<p>exception(Exception): 웹프로그램 실행시 발생된 예외를 제공하기 위한 객체
	- page Directive에서 isErrorPage 속성값을 [true]로 설정한 경우에만 제공: 에러페이지에서 사용</p>
	<p></p>
	<p></p>
	  
</body>
</html>