<%@page import="xyz.itwill.dto.StudentDTO"%>
<%@page import="xyz.itwill.dao.StudentDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- STUDENT 테이블에 저장된 모든 학생정보를 검색하여 클라이언트에게 전달하여 응답하는 JSP 문서 --%>
<%-- => [학생추가] 태그를 클릭한 경우 [insertFormStudent.jsp] 문서를 요청하여 이동 --%>
<%-- => 학생정보 출력태그의 [변경] 태그를 클릭한 경우 [updateFormStudent.jsp] 문서를 요청하여 이동 - 학생번호 전달 --%>
<%-- => 학생정보 출력태그의 [삭제] 태그를 클릭한 경우 [deleteStudent.jsp] 문서를 요청하여 이동 - 학생번호 전달 --%>
<%
	//STUDENT 테이블에 저장된 모든 학생정보를 검색하여 List 객체로 반환하는 DAO 클래스의 메소드 반환하여 저장
	List<StudentDTO> studentList = StudentDAO.getDAO().selectStudentList();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP</title>
</head>
<body>
	<h1 align="center">학생리스트</h1>
	<table align="center" cellspacing="0" cellpadding="1" width="800">
		<tr align="right">
			<td>
				<input type="button" value="학생추가" onclick="location.href='insertFormStudent.jsp';">
			</td>
		</tr>
	</table>
	<table align="center" border="1" cellspacing="0" cellpadding="1" width="800">
		<tr bgcolor="yellow">
			<th width="100">학생번호</th>
			<th width="100">이름</th>
			<th width="150">전화번호</th>
			<th width="250">주소</th>
			<th width="100">생년월일</th>
			<th width="50">삭제</th>
			<th width="50">변경</th>
		</tr>
		
		<!-- 학생정보 출력-->
		<% for(StudentDTO student : studentList) { %>
		<tr align="center">
			<td width="100"><%=student.getNo() %></td>				
			<td width="100"><%=student.getName() %></td>				
			<td width="150"><%=student.getPhone() %></td>				
			<td width="250"><%=student.getAddress() %></td>				
			<td width="100"><%=student.getBirthday().substring(0, 10) %></td>				
			<td width="50"><input type="button" value="삭제" onclick="removeConfirm(<%=student.getNo()%>);"></td>				
			<td width="50"><input type="button" value="변경" onclick="location.href='updateFormStudent.jsp?no=<%=student.getNo()%>';"></td>				
		</tr>	
		<% } %>
	</table>
	
	<script type="text/javascript">
	function removeConfirm(no) {
		if(confirm("학생정보를 정말로 삭제 하시겠습니까?")) {
			location.href="deleteStudent.jsp?no="+no;
		}
	}
	</script>
</body>
</html>
