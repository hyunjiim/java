<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 회원정보를 입력받기 위한 JSP 문서 --%>
<%-- => [회원가입] 태그를 클릭한 경우 [member/member_join_action.jsp] 문서 요청 - 입력값(회원정보) 전달 --%>
<%-- => [아이디 중복 검사] 태그를 클릭한 경우 팝업창을 실행하여 [id_check.jsp] 문서 요청 - 아이디 전달 --%>
<%-- => [우편번호] 태그를 클릭한 경우 Daum 우편번호 서비스(JavaScript)를 사용하여 입력태그에 입력값으로 사용 --%>    
<style type="text/css">
fieldset {
	text-align: left;
	margin: 10px auto;
	width: 1100px;
}

legend {
	font-size: 1.2em;
}

#join label {
	width: 150px;
	text-align: right;
	float: left;
	margin-right: 10px;
}

#join ul li {
	list-style-type: none;
	margin: 15px 0;
}

#fs {
	text-align: center;
}

.error {
	color: red;
	position: relative;
	left: 160px;
	display: none;
}

#idCheck, #postSearch {
	font-size: 12px;
	font-weight: bold;
	cursor: pointer;
	margin-left: 10px;
	padding: 2px 10px;
	border: 1px solid black;
}

#idCheck:hover, #postSearch:hover {
	background: black;
	color: white;
}
</style>
<form id="join" action="<%=request.getContextPath() %>/member/member_join_action.jsp" method="post">
<%-- 아이디 중복 검사 결과를 저장하기 위한 입력태그 --%>
<%-- => 0: 아이디 중복 검사 미실행 또는 아이디 중복 - 아이디 사용 불가능 --%>
<%-- => 1: 아이디 중복 검사 실행 및 아이디 미중복 - 아이디 사용 가능 --%>
<input type="hidden" id="idCheckResult" value="0">
<fieldset>
	<legend>회원가입 정보</legend>
	<ul>
		<li>
			<label for="id">아이디</label>
			<input type="text" name="id" id="id"><span id="idCheck">아이디 중복 검사</span>
			<div id="idMsg" class="error">아이디를 입력해 주세요.</div>
			<div id="idRegMsg" class="error">아이디는 영문자로 시작되는 영문자,숫자,_의 6~20범위의 문자로만 작성 가능합니다.</div>
			<div id="idCheckMsg" class="error">아이디 중복 검사를 반드시 실행해 주세요.</div>
		</li>
		<li>
			<label for="passwd">비밀번호</label>
			<input type="password" name="passwd" id="passwd">
			<div id="passwdMsg" class="error">비밀번호를 입력해 주세요.</div>
			<div id="passwdRegMsg" class="error">비밀번호는 영문자,숫자,특수문자가 반드시 하나이상 포함된 6~20 범위의 문자로만 작성 가능합니다.</div>
		</li>
		<li>
			<label for="passwd">비밀번호 확인</label>
			<input type="password" name="repasswd" id="repasswd">
			<div id="repasswdMsg" class="error">비밀번호 확인을 입력해 주세요.</div>
			<div id="repasswdMatchMsg" class="error">비밀번호와 비밀번호 확인이 서로 맞지 않습니다.</div>
		</li>
		<li>
			<label for="name">이름</label>
			<input type="text" name="name" id="name">
			<div id="nameMsg" class="error">이름을 입력해 주세요.</div>
		</li>
		<li>
			<label for="email">이메일</label>
			<input type="text" name="email" id="email">
			<div id="emailMsg" class="error">이메일을 입력해 주세요.</div>
			<div id="emailRegMsg" class="error">입력한 이메일이 형식에 맞지 않습니다.</div>
		</li>
		<li>
			<label for="mobile">전화번호</label>
			<select name="mobile1">
				<option value="010" selected>&nbsp;010&nbsp;</option>
				<option value="011">&nbsp;011&nbsp;</option>
				<option value="016">&nbsp;016&nbsp;</option>
				<option value="017">&nbsp;017&nbsp;</option>
				<option value="018">&nbsp;018&nbsp;</option>
				<option value="019">&nbsp;019&nbsp;</option>
			</select>
			- <input type="text" name="mobile2" id="mobile2" size="4" maxlength="4">
			- <input type="text" name="mobile3" id="mobile3" size="4" maxlength="4">
			<div id="mobileMsg" class="error">전화번호를 입력해 입력해 주세요.</div>
			<div id="mobileRegMsg" class="error">전화번호는 3~4 자리의 숫자로만 입력해 주세요.</div>
		</li>
		<li>
			<label>우편번호</label>
			<input type="text" name="zipcode" id="zipcode" size="7" readonly="readonly">
			<span id="postSearch">우편번호 검색</span>
			<div id="zipcodeMsg" class="error">우편번호를 입력해 주세요.</div>
		</li>
		<li>
			<label for="address1">기본주소</label>
			<input type="text" name="address1" id="address1" size="50">
			<div id="address1Msg" class="error">기본주소를 입력해 주세요.</div>
		</li>
		<li>
			<label for="address2">상세주소</label>
			<input type="text" name="address2" id="address2" size="50">
			<div id="address2Msg" class="error">상세주소를 입력해 주세요.</div>
		</li>
	</ul>
</fieldset>
<div id="fs">
	<button type="submit">회원가입</button>
	<button type="reset">다시입력</button>
</div>
</form>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript">
$("#id").focus();

//join form 태그 submit
$("#join").submit(function() {
	//전송결과: true(전송), false(미전송)
	var submitResult=true;
	
	$(".error").css("display","none"); //error 메세지 미출력

	var idReg=/^[a-zA-Z]\w{5,19}$/g;
	if($("#id").val()=="") {
		$("#idMsg").css("display","block");
		submitResult=false;
	} else if(!idReg.test($("#id").val())) {
		$("#idRegMsg").css("display","block");
		submitResult=false;
	} else if($("#idCheckResult").val()=="0") {
		$("#idCheckMsg").css("display","block");
	}
		
	var passwdReg=/^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[~!@#$%^&*_-]).{6,20}$/g;
	if($("#passwd").val()=="") {
		$("#passwdMsg").css("display","block");
		submitResult=false;
	} else if(!passwdReg.test($("#passwd").val())) {
		$("#passwdRegMsg").css("display","block");
		submitResult=false;
	} 
	
	if($("#repasswd").val()=="") {
		$("#repasswdMsg").css("display","block");
		submitResult=false;
	} else if($("#passwd").val()!=$("#repasswd").val()) {
		$("#repasswdMatchMsg").css("display","block");
		submitResult=false;
	}
	
	if($("#name").val()=="") {
		$("#nameMsg").css("display","block");
		submitResult=false;
	}
	
	var emailReg=/^([a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+(\.[-a-zA-Z0-9]+)+)*$/g;
	if($("#email").val()=="") {
		$("#emailMsg").css("display","block");
		submitResult=false;
	} else if(!emailReg.test($("#email").val())) {
		$("#emailRegMsg").css("display","block");
		submitResult=false;
	}

	var mobile2Reg=/\d{3,4}/;
	var mobile3Reg=/\d{4}/;
	if($("#mobile2").val()=="" || $("#mobile3").val()=="") {
		$("#mobileMsg").css("display","b lock");
		submitResult=false;
	} else if(!mobile2Reg.test($("#mobile2").val()) || !mobile3Reg.test($("#mobile3").val())) {
		$("#mobileRegMsg").css("display","block");
		submitResult=false;
	}
	
	if($("#zipcode").val()=="") {
		$("#zipcodeMsg").css("display","block");
		submitResult=false;
	}
	
	if($("#address1").val()=="") {
		$("#address1Msg").css("display","block");
		submitResult=false;
	}
	
	if($("#address2").val()=="") {
		$("#address2Msg").css("display","block");
		submitResult=false;
	}
	
	return submitResult;
});

<%-- [아이디중복] 태그를 클릭하면 --%>
$("#idCheck").click(function() {
	//아이디 관련 에러메세지가 보여지지 않도록 설정	
	$("#idMsg").css("display","none"); //아이디를 입력해주세요
	$("#idRegMsg").css("display","none"); //정규표현식 메세지
	
	//정규표현식 검사
	var idReg=/^[a-zA-Z]\w{5,19}$/g;
	if($("#id").val()=="") {
		$("#idMsg").css("display","block"); //아이디가 입력되지 않았을때 
		return;
	} else if(!idReg.test($("#id").val())) { //정규표현식과 일치하지 않은 입력값일 때
		$("#idRegMsg").css("display","block");
		return;
	}
			
	//팝업창을 실행하여 [id_check.jsp] 문서 요청
	//window.open('팝업주소','팝업창 이름','팝업창 설정')
	window.open("<%=request.getContextPath()%>/member/id_check.jsp?id="+$("#id").val()
			,"idCheck","width=450, height=130, left=700, top=400");
});



//입력태그(아이디)의 입력값이 변경된 경우 호출되는 이벤트 처리 함수 등록
$("#id").change(function() {
	//아이디 중복 검사 결과값을 저장한 입력태그의 입력값 변경 - 아이디 중복 검사 미실행
	$("#idCheckResult").val("0");
});

$("#postSearch").click(function() {
	new daum.Postcode({
    	oncomplete: function(data) {
        	// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
        	// 예제를 참고하여 다양한 활용법을 확인해 보세요.
        	// [http://postcode.map.daum.net/guide] >> 기본 사용법 >> 원하는 코드 복사해오기
    		$("#zipcode").val(data.zonecode);
    		$("#address1").val(data.address);
    	}
	}).open();	
});
    
</script>