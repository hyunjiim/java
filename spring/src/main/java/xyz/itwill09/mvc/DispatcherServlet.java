package xyz.itwill09.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//컨트롤러(Controller) : 클라이언트의 모든 요청을 받아 URL 주소를 분석하여 필요한 요청 처리
//클래스(Model)의 메소드를 호출하여 클라이언트의 요청을 처리하고 JSP 문서(View)로 스레드를
//이동하여 응답처리 되도록 프로그램의 흐름을 제어하는 기능 제공 - 서블릿(Servlet)으로 구현

//Dispatcher - Servlet - Filter - Interceptor => https://steady-coding.tistory.com/601

/* 필터(Filter)
 * Dispatcher Servlet에 요청이 전달되기 전/후에 url 패턴에 맞는 모든 요청에 대해 부가 작업을 처리할 수 있는 기능 제공
 * => 스프링 컨테이너가 아닌 톰캣과 같은 웹 컨테이너에 의해 관리되므로 디스패치 서블릿으로 가기 전 요청 처리
 * @Componenet : Filter를 Spring Bean으로 등록
 * @Order : 필터가 여러 개일 경우 순서 지정
 * => 특정 URI에만 필터를 동작하게 하려면 FilterRegistrationBean을 사용하여 필터를 Spring Bean으로 등록
 * 주요 기능
 * => 보안 검사(XSS,CSRF 방어 등)를 하여 올바른 요청이 아닐 경우 차단
 * => 모든 요청에 대한 로깅
 * => 이미지/데이터 압축 및 문자열 인코딩 - 전반적으로 사용되는 기능 등을 구현
 * => Body를 로깅하기 위해 커스텀한 ServletRequest 생성 가능 - HttpServletRequest는 Body의 내용을 한번만 
 *읽을 수 있으므로, Filter나 Interceptor에서는 Body를 읽을 수 없음
 * 
 * 인터셉터(Interceptor)
 * 스프링이 제공하는 기술로, DispatcherServlet이 Controller를 호출하기 전/후에 요청과 응답을 참조하거나
 * 가공할 수 있는 기능을 제공 - Spring Context에서 동작
 * 
 */


//컨트롤러 기능을 제공하기 위한 서블릿 클래스
// => 클라이언트의 모든 요청을 받아 처리하는 단일 진입점의 역할을 수행 - Front Controller Pattern
// => [web.xml] 파일에서 클래스를 서블릿(웹프로그램)으로 등록하고 클라이언트의 모든 요청을 받아
//처리할 수 있도록 URL 패턴 설정
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//클라이언트의 요청을 처리하기 위해 자동 호출되는 메소드를 오버라이드 선언
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 클라이언트의 요청 URL 주소를 분석하여 요청정보를 반환받아 저장
		String requestURI=request.getRequestURI();
		String contextPath=request.getContextPath();
		String command=requestURI.substring(contextPath.length());
		
		//아래의 방법은 속도가 너무 느리고 관리도 힘들어 잘 사용하지 않음 - HandlerMapping 클래스로 작성
		//2. 클라이언트의 요청정보를 이용하여 요청 처리 클래스(Model)의 객체를 제공받아 객체의 메소드를 호출하여
		//클라이언트의 요청을 처리하고 응답 관련 정보(View)를 반환받아 저장
		// => 인터페이스로 참조변수를 선언하면 인터페이스를 상속받은 모든 자식클래스의 객체 저장 가능
		/*
		Controller controller=null;
		//클라이언트의 요청정보를 비교하여 요청 처리 클래스(Model)로 객체를 생성하여 저장
		if(command.equals("/list.itwill")) {
			controller=new ListController();
		} else if(command.equals("/view.itwill")) {
			controller=new ViewController();
		}
		*/
		
		//HandlerMapping 클래스로 객체 생성
		// => HandlerMapping 클래스 : 클라이언트의 요청정보와 요청처리 클래스의 객체가 엔트리로 저장된
		//Map 객체를 제공하기 위한 클래스
		HandlerMapping handlerMapping=new HandlerMapping();
		//HandlerMapping 객체의 메소드를 호출하여 매개변수에 전달된 요청정보에 대한 요청 처리 클래스의 객체를 반환받아 저장
		Controller controller=handlerMapping.getController(command);
		
		//요청처리 클래스의 메소드를 호출하여 클라이언트의 요청을 처리하고 응답 처리할 JSP 문서의
		//이름(ViewName)을 반환받아 저장
		String viewName=controller.handleRequest(request, response);
		
		//3. JSP 문서로 포워드 이동하여 클라이언트에게 처리결과가 응답되도록 처리
		// => 요청처리 메소드의 반환값(ViewName)을 이용하여 JSP 문서의 경로를 완성하여 포워드 이동
		//ViewResolver 클래스로 객체 생성
		// => ViewResolver 클래스 : 요청처리 메소드의 반환값(ViewName)을 이용하여 응답 처리할 JSP 문서의
		//경로를 완성하여 반환하는 메소드
		ViewResolver viewResolver=new ViewResolver();
		String view=viewResolver.getView(viewName); //응답할 JSP 문서의 경로를 반환받아 저장
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}