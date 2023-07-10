<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 사용자가 검색어를 입력한 경우 검색어가 포함된 제시어를 클라이언트에게 제공하는 JSP 문서 --%>
<%-- => 사용자가 검색어를 입력할 경우 [suggest_two.jsp] 문서를 AJAX 기능으로 요청하여 검색어가
포함된 제시어 관련 정보를 XML 데이터로 응답받아 출력 처리 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<style type="text/css">
#keyword{
	position: absolute;
	top: 100px;
	left: 10px;
	width: 300px;
	font-size: 16px;
}

#sugggest{
	position: absolute;
	top: 120px;
	left: 10px;
	width: 300px;
	border: 1px solid black;
	cursor: pointer;
	font-size: 16px;
	background: rgba(255,255,255,1);
}
</style>
</head>
<body>
	<h1>제시어 기능</h1>
	<hr>
	<div>
		<%-- 검색어를 입력받기 위한 태그 --%>
		<input type="text" id="keyword">
		
		<%-- 제시어를 제공받아 출력하기 위한 태그 --%>
		<div id="suggest">
			<div id="suggestList">
				JAVA<br>
				JAVA의 정석
			</div>
		</div>
		
		<%-- 선택된 제시어 관련 정보를 출력하기 위한 태그 --%>
		<div id="choice"></div>
	</div>
</body>
</html>