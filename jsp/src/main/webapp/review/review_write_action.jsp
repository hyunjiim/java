<%@page import="xyz.itwill.dao.ReviewDAO"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 게시글(새글 또는 답글)을 전달받아 REVIEW 테이블에 삽입하고 [review/review_list.jsp] 문서로
이동하기 위한 URL 주소를 클라이언트에게 전달하여 응답하는 JSP 문서 --%>
<%-- => [multipart/form-data] 형태로 값이 전달되므로 COS 라이브러리의 MultipartRequest 클래스 사용 --%>
<%-- => 전달받은 파일은 [/review_images] 서버 디렉토리에 업로드 처리하여 저장 --%>
    
<%
	if(request.getMethod().equals("GET")) {
		response.sendRedirect(request.getContextPath()+"/index.jsp?group=error&worker=error_400");
		return;
	}
	//전달파일을 저장할 서버 디렉토리(웹자원)의 파일 시스템 경로를 반환받아 저장
	//String saveDirectory=application.getRealPath(arg0)
	//아파치 톰캣의 어딘가에 저장되는 것이므로 현재 이클립스에서 확인 불가능
	String saveDirectory=request.getServletContext().getRealPath("/review_images");

	//[multipart/form-data]는 request.getParameter로 값 가져오는것이 불가능
	//MultipartRequest 객체 생성 - 모든 전달파일을 서버 디렉토리에 업로드 처리하여 저장
	// 최대 용량 설정: 20*1024*1024
	// => DefaultFileRenamePolicy 객체 전달: 파일 이름 중복 시 이름 변경
	MultipartRequest multipartRequest=new MultipartRequest(request, saveDirectory
			, 20*1024*1024, "utf-8", new DefaultFileRenamePolicy());
	
	//전달값을 반환받아 저장
	int ref=Integer.parseInt(multipartRequest.getParameter("ref"));
	int restep=Integer.parseInt(multipartRequest.getParameter("restep"));
	int relevel=Integer.parseInt(multipartRequest.getParameter("relevel"));
	String pageNum=multipartRequest.getParameter("pageNum");
	String subject=multipartRequest.getParameter("subject");
	int status=1; //전달값이 없는 경우 초기값 저장
	if(multipartRequest.getParameter("secret")!=null){ //비밀글
		status=Integer.parseInt(multipartRequest.getParameter("secret"));
	}
	String content=multipartRequest.getParameter("content");
	//업로드 처리된 파일명을 반환받아 저장
	String reviewimg=multipartRequest.getFilesystemName("reviewimg");
	
	//REVIEW_SEQ 시퀀스의 다음값을 검색하여 반환하는 DAO 클래스의 메소드 호출
	// => 게시글의 글번호(NUM 컬럼값)로 저장
	// => 새글(답글?)인 경우에는 게시글의 글그룹(REF 컬럼값)의 값으로 저장
	int num=ReviewDAO.getDAO().selectNextNum();
	
	//게시글을 작성한 클라이언트의 IP 주소를 반환받아 저장
	//request.getRemoteAddr(): JSP 문서를 요청한 클라이언트의 IP 주소를 반환하는 메소드
	// => 이클립스에 등록되어 동작되는 WAS 프로그램은 기본적으로 IPV6의 128bit 형식의 IP 주소 제공
	// 32bit 형식의 IP 주소를 제공받을 수 있도록 이클립스의 실행 환경 변경
	// => Run >> Run Configurations...(실행환경 변경 메뉴) >> Apache Tomcat >> 사용중인 Apache Tomcat 선택
	//	>> Arguments >> VM Arguments >> [-Djava.net.preferIPv4Stack=true] 추가 >> Apply
	String ip=request.getRemoteAddr();
	System.out.println("ip = "+ip);
	
%>