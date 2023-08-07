<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/* 	HTTP 헤더
		- 클라이언트와 서버 사이에 이루어지는 HTTP 요청과 응답은 HTTP 헤더를 사용하여 수행
		- HTTP 헤더는 클라이언트와 서버가 서로에게 전달해야 할 다양한 종류의 데이터를 포함할 수 있음
		- HTTP 헤더는 헤더이름, 콜론(:), 공백, 헤더 값의 순서로 구성됨
		
		- HTTP 요청 헤더는 원래 웹 브라우저가 자동으로 설정해서 보내므로, 사용자가 직접 설정할 수 없었음
		 => Ajax를 사용하여 HTTP 요청 헤더 직접 설정 가능, HTTP 응답 헤더의 내용 확인 가능
	*/
	
	/* 주기적으로 Ajax 요청하기
	   => ajax는 클라이언트가 서버에 데이터를 요청하는 클라이언트 풀링 방식을 사용하므로, 서버 푸시 방식의
	   실시간 서비스 만드는 것은 불가
	   => 주기적으로 Ajax 요청을 보내도록 설정하여, 실시간 서비스와 비슷한 동작을 하도록 할 수 있음
	*/
	
	/*
		브라우저 캐시?
		- 브라우저 캐시는 브라우저(Chrom,Safari 등)에서 로컬 웹 페이지 리소스를 저장하는 데 사용되는 매커니즘
		  => 성능이 향상되고 대역폭 소비가 최소화 됨
		- 캐시: 빠른 엑세스를 위해 값을 임시로 저장하는 데 사용되는 방식
		- 브라우저 캐시: CSS, JS, 이미지, 비디오 등의 정적 리소스를 포함하는 작은 데이터베이스
		- 캐시를 사용하지 않으면 자주 변하지 않는 데이터(정적 리소스)라도 요청마다 새롭게 다운로드 해야함
			=> 불필요한 네트워크 비용 야기, 서버에 추가적인 부담 - 느린 웹페이지 로딩 속도
		
		
		브라우저 캐시 방식
		- 브라우저가 웹 서버의 일부 컨텐츠를 요청
		- 컨텐츠가 브라우저 캐시에 없으면 웹 서버에서 직접 검색. 컨텐츠가 이전에 캐시되었다면 브라우저는
		서버를 우회하여 캐시에 직접 콘텐츠를 로드
		
		브라우저 캐싱은 특정 HTTP 헤더를 사용하여 웹 개발자와 관리자가 활용 가능
		=> 헤더는 자원을 언제 캐시할 것인지, 얼마나 오래 캐시할지 웹 브라우저에 지시
		
		Pragma
		- 캐시가 캐시 복사본을 릴리즈 하기 전에 원격 서버로 요청을 날려 유효성 검사를 강제하도록 함
		- Cache-control: no-cache와 동일한 효과
		-Pragma 헤더는 HTTP/1.0 을 사용하는 클라이언트들만을 위한 비공식적인 호환성을 위해 사용되어야 함
		
		Expires
		- Cache-Control과 별개의 또 다른 헤더로, 응답 컨텐츠가 언제 만료되는지를 나타내며, Chache-Control의 max-age가 있는 경우 무시됨
			
		Cache-control 헤더 - HTTP/1.1부터 도입
		1. no-cache, no-store
		 - 항상 최신 버전의 리소스를 캐시하거나, 혹은 아예 캐시 자체를 하지 않는 방법
		 - no-cache: 리소스에 대한 캐시를 생성하지만, 리소스를 요청할 떄 원 서버에 항상 캐시 유효성 검증을 하는 옵션
		 - no-store: 리소스에 대한 캐시를 생성하지 말라는 가장 강력한 cache-control 디렉티브 - 저장하면 안되는 민감한 정보에 사용
		 
		2. private, public
		 - public: shared cache에서도 캐싱을 허용
		 - private: 사용자 브라우저에게만 캐싱 허용
		 
		3. max-age
		 - 캐시의 유효시간
	*/
	
	//request.getProtocol() : 웹프로그램을 요청할 때 사용한 통신규약(Protocol)을 반환하는 메소드
	String protocol=request.getProtocol();

	//프로토콜을 구분하여 브라우저 캐싱 기능을 사용하지 않도록 설정
	if(protocol.equals("HTTP/1.0")) {
		response.setDateHeader("Expires", -1);//캐싱 만료기간 설정
		response.setHeader("Pragma", "no-cache");//캐싱 기능 비활성화 설정
	} else if(protocol.equals("HTTP/1.1")) {
		response.setHeader("Cache-control", "no-cache");//캐싱 기능 비활성화 설정
	}

	Date now=new Date();
	SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy년 M월 d일 H시 m분 s초");
	String displayTime=dateFormat.format(now);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Expires" content="-1">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-control" content="no-cache">
<title>AJAX</title>
</head>
<body>
	<%=displayTime %>
</body>
</html>