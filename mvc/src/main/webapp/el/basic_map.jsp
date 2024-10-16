<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//VO 클래스를 Map으로 대체 가능
	//DTO를 만들지 않았는데 클래스 객체를 생성하여 사용할 필요없음 - Map 사용
	//HashMap 객체(Map 객체)를 생성하여 저장
	Map<String, String> carMap=new HashMap<String, String>();

	//HashMap 객체(Map 객체)에 엔트리(Entry : 이름과 값을 하나로 묶어 표현한 요소)를 추가하여 저장
	carMap.put("modelName", "싼타페");
	carMap.put("carColor", "하얀색");
	
	//pageContext 내장객체에 속성값으로 HashMap 객체(Map 객체) 저장
	pageContext.setAttribute("carMap", carMap);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>EL(Expression Language)</h1>
	<hr>
	<h2>EL 미사용</h2>
	<%
		//pageContext 내장객체에 저장된 속성값을 속성명(carMap)을 사용하여 Map 객체로 반환받아 저장
		//@SuppressWarnings : 프로그램에서 발생되는 경고를 제거하는 어노테이션
		// => value 속성값으로 제거할 경고의 종류를 설정 - 다른 속성이 없는 경우 속성값만 설정 가능
		@SuppressWarnings("unchecked")
		Map<String, String> car=(Map<String, String>)pageContext.getAttribute("carMap");
	%>
	<p>자동차 = <%=car %></p>
	<%-- Map 객체에 저장된 엔트리에서 맵키(Key)를 이용하여 맵값(Value)을 반환받아 JSP 표현식으로 출력 처리 --%>
	<p>자동차 모델명 = <%=car.get("modelName") %></p>
	<p>자동차 색상 = <%=car.get("carColor") %></p>	
	<h2>EL 사용</h2>
	<p>자동차 = ${carMap }</p>
	<%-- ${속성명.맵키} 형식의 EL 표현식을 사용하여 스코프 속성명으로 Map 객체를 제공받아 맵값 출력 처리 --%>
	<%-- => Map 객체의 get() 메소드를 호출하지 않아도 Map 객체의 맵값을 제공받아 출력 처리 가능 --%>
	<p>자동차 모델명 = ${carMap.modelName }</p>
	<p>자동차 색상 = ${carMap.carColor }</p>
</body>
</html>