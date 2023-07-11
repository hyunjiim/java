package xyz.itwill.mvc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//프로그램 영역 - 비즈니스 레이아웃(데이터 처리), 프리벤테이션 레이아웃(), 커시던트 레이아웃(연결)
// => 하나의 파일에 작성되면 유지보수 어렵기 때문에 될 수 있으면 영역을 다 분리하여 작성하는 것이 좋음
// - MVC(Model, View, Controller) 패턴
// => but 여러개로 분리해서 만들어졌기 때문에 통합과정에서 문제가 많이 발생 - 테스트 프로그램을 통해 문제 제거

//컨트롤러(Controller - Servlet) : 클라이언트의 모든 요청을 받아 모델(Model - Class) 역할의 
//객체로 요청 처리 메소드를 호출하여 클라이언트의 요청을 처리하고 처리결과를 뷰(View - JSP)로
//전달하여 응답되도록 프로그램의 흐름을 제공하는 웹프로그램

//1.클라이언트의 모든 요청을 받을 수 있도록 서블릿을 설정하여 단일 진입점의 기능 구현
// => Front Controller Pattern
//@WebServlet("url") : 클래스를 웹프로그램(서블릿)으로 등록하고 요청 URL 주소를 매핑하는 어노테이션
// => 매핑 설정될 URL 주소에 패턴문자(* : 전체, ? : 문자 하나)를 사용하여 URL 패턴 등록 가능
// => @WebServlet("*.do") : 클라이언트가 [XXX.do] 형식의 URL 주소를 요청한 경우 웹프로그램(서블릿) 실행
// => @WebServlet 어노테이션 대신 [web.xml] 파일의 엘리먼트를 사용하여 클래스를 웹프로그램으로
//등록하고 URL 매핑 처리 가능
//@WebServlet("*.do")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("ControllerServlet 클래스의 service() 메소드 호출");
		
		//2.클라이언트의 요청 분석 : 요청 URL 주소 이용 - http://localhost:8000/mvc/XXX.do
		//HttpServletRequest.getRequestURI() : 요청 URL 주소에서 URI 주소를 반환하는 메소드
		String requestURI=request.getRequestURI();
		//System.out.println("requestURI = "+requestURI);//requestURI = /mvc/XXX.do
		
		//HttpServletRequest.getContextPath() : 요청 URL 주소에서 컨텍스트 경로를 반환하는 메소드
		String contextPath=request.getContextPath();
		//System.out.println("contextPath = "+contextPath);//contextPath = /mvc
		
		String command=requestURI.substring(contextPath.length());
		//System.out.println("command = "+command);//command = /XXX.do
		
		//3.모델(Model) 객체를 이용하여 요청 처리 메소드를 호출해 클라이언트의 요청을 처리하고
		//뷰(View) 관련 정보를 반환받아 저장
		// => 하나의 요청에 대해 하나의 모델 객체가 요청을 처리하도록 설정 - Command Controller Pattern 
		// => 요청 처리 메소드가 선언된 모델 역활의 클래스 작성 - 모델 역활의 클래스는 인터페이스를 상속받아 작성
	
		//회원관리 프로그램에서 클라이언트 요청(Command)에 대한 모델 객체가 매핑되도록 설정
		// => 클래스 안의 요청 처리 메소드는 똑같이 만들어져야 함 그렇지 않으면 만들기 어렵고 유지보수도 어려움
		// => 특별한 인터페이스를 작성하여 밑의 모델 클래스들이 상속받을 수 있도록 - Action
		// => [/loginform.do]  >> LoginFormModel 클래스
		// => [/login.do]      >> LoginModel 클래스
		// => [/logout.do]     >> LogoutModel 클래스
		// => [/writeform.do]  >> WriteFormModel 클래스
		// => [/write.do]      >> WriteModel 클래스
		// => [/list.do]       >> ListModel 클래스
		// => [/view.do]       >> ViewModel 클래스
		// => [/modifyform.do] >> MojdifyFormModel 클래스
		// => [/modify.do]     >> ModifyModel 클래스
		// => [/remove.do]     >> RemoveModel 클래스
		// => [/error.do]      >> ErrorModel 클래스
		
		//모델 역할의 클래스가 상속받기 위한 인터페이스로 참조변수 생성
		// => 인터페이스로 생성된 참조변수에는 인스페이스를 상속받은 모든 자식클래스(모델)의 객체 저장 가능
		Action action=null;
				
		//클라이언트 요청정보를 구분하여 요청을 처리하기 위한 모델 역활의 클래스로 객체를 
		//생성하여 인터페이스 참조변수에  저장
		if(command.equals("/loginform.do")) {
			action=new LoginFormModel();
		} else if(command.equals("/login.do")) {
			action=new LoginModel();
		} else if(command.equals("/logout.do")) {
			action=new LogoutModel();
		} else if(command.equals("/writeform.do")) {
			action=new WriteFormModel();
		} else if(command.equals("/write.do")) {
			action=new WriteModel();
		} else if(command.equals("/error.do")) {
			action=new ErrorModel();
		} else {//클라이언트 요청에 대한 모델 역할의 클래스가 없는 경우
			action=new ErrorModel();
		}
				
		//인터페이스 참조변수로 추상메소드를 호출하면 참조변수에 저장된 모델 객체의 요청 
		//처리 메소드를 호출하고 뷰 관련 정보를 반환받아 저장 -  오버라이드의 의한 다형성
		ActionForward actionForward=action.execute(request, response);
				
		//4.응답 관련 정보가 저장된 ActionForward 객체를 이용하여 응답 처리
		if(actionForward.isForward()) {//ActionForward 객체의 forward 필드값이 [true]인 경우 - 포워드 이동
			//JSP 문서로 포워드 이동하여 JSP 문서의 실행결과(HTML)로 클라이언트에게 전달하여 응답 처리
			//RequestDispatcher 객체: 다른 페이지로 이동하는 forward() 또는 include() 메소드를 가지고 있는 객체
			// => new 연산자가 아니라 HttpServletRequest 객체의 getRequestDispatcher()로 객체를 생성
			// => forward(request.response): 해당 주소에 대해 요청하고 응답하라
			request.getRequestDispatcher(actionForward.getPath()).forward(request, response);
		} else {//ActionForward 객체의 forward 필드값이 [false]인 경우
			//서블릿에서 클라이언트에게 URL 주소(/XXX.do)를 전달하여 응답 처리
			// => URL 주소를 전달받은 클라이언트는 브라우저의 URL 주소를 변경하여 서블릿 요청
			response.sendRedirect(actionForward.getPath());
		}
	}
}
