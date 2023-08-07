<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX</title>
<style type="text/css">
#display {
	width: 50%;
	padding: 5px;
	margin: 10px;
	font-size: 20px;
	border: 1px solid red;
}
</style>
</head>
<body>
	<h1>AJAX - 값 전달</h1>
	<hr>
	<div id="display">요청 웹프로그램에 대한 응답 결과 출력</div>
	<table>
		<tr>
			<td>아이디</td>
			<td><input type="text" id="id"></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" id="name"></td>
		</tr>
		<tr>
			<td colspan="2">
				<button type="button" id="btn">입력완료</button>
			</td>
		</tr>
	</table>
	
	<script type="text/javascript">
	//[입력완료] 태그를 클릭한 경우 AJAX 기능을 사용하여 [example_two.jsp] 문서를 요청하여
	//응답결과를 제공받아 태그 변경
	// => [example_two.jsp] 문서를 요청할 때 사용자로부터 입력받은 아이디와 이름 전달
	document.getElementById("btn").onclick= function() {
		var id=document.getElementById("id").value;
		var name=document.getElementById("name").value;
		
		//입력값 검증
		if(id==""||name==""){
			document.getElementById("display").innerHTML="아이디와 이름을 모두 입력해주세요."
			return;
		}
		
		document.getElementById("id").value="";
		document.getElementById("name").value="";
		
		//준비 상태의 XMLHttpRequest 객체가 저장된 xhr 변수
		var xhr=new XMLHttpRequest();
		
		//XMLHttpRequest 객체의 준비상태(readyState)가 변할때마다 자동호출되는 함수
		xhr.onreadystatechange= function() {
			if(xhr.readyState==4){ //요청한 데이터 처리가 완료되어 응답할 준비가 완료됨
				if(xhr.status==200){ //서버에 문서가 존재할 경우 - 정상적인 응답
					document.getElementById("display").innerHTML=xhr.responseText; //XMLHttpRequest 객체의 응답결과에 대한 상태코드가 [200]인 경우
				}else{ //서버에 문서가 존재하지 않을 경우
					alert("에러코드 = "+xhr.status);
				}
			}
		}
		
		id=encodeURIComponent(id);
		name=encodeURIComponent(name);
		xhr.open("get", "example_two.jsp?id="+id+"&name="+name, true);
		xhr.send(null); //전달값이 없거나 get 방식은 무조건 null 전송 why?
	}
	</script>
</body>
</html>