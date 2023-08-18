package xyz.itwill10.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
 
//요청 처리 메소드의 의해 처리된 결과를 뷰(JSP 문서)에게 제공하는 방법
//1. ModelAndView 객체의 addObject() 메소드를 호출하여 처리결과를 속성값으로 저장하여 제공
//2. HttpServletRequest 객체의 setAttribute() 메소드를 호출하여 처리결과를 속성값으로 저장하여 제공
//3. Model 객체의 addAttribute() 메소드를 호출하여 처리결과를 속성값으로 저장하여 제공

//Controller를 Spring Bean으로 등록
@Controller
public class ResultController {
	//1번 방법으로 결과를 뷰에 제공
	/*
	@RequestMapping("/requestMav")
	public ModelAndView modelAndViewResult() {
		ModelAndView modelAndView=new ModelAndView("result_display");
		
		//ModelAndView.addObject(String attributeName, Object attributeValue)
		// => ModelAndView 객체에 처리결과를 속성값으로 저장하는 메소드 - Request Scope
		// => 뷰(JSP 문서)에서는 EL 또는 JSTL을 이용하여 속성명으로 속성값을 제공받아 사용
		modelAndView.addObject("mavName", "홍길동");
		
		return modelAndView;
	}
	*/
	
	/* [ApplicationContext] - 최상위 인터페이스
	 * => Spring에서 만든 인터페이스로, 애플리케이션에 대한 context를 가지고 있음
	 * [WebApplicationContext] - Root, Servlet Context로 사용됨
	 * => Spring의 ApplicationContext를 확장한 인터페이스로, 웹 애플리케이션에서 필요한 몇 가지 기능을 추가한 인터페이스
	 * [ServletContext] - 자바 자체의 Context
	 * => Servlet API에서 제공하는 context 객체로, 모든 servlet이 공유하는 context
	 * 
	 * Spring Context?
	 * => Bean의 확장 버전으로 Spring Bean을 좀 더 쉽게 다룰 수 있도록 기능들이 추가된 공간
	 * 1. root-context(공통 부분) : 모든 servlet이 공유할 수 있는 Bean들이 모인 공간으로, DB와 관련된 Repository, Service 등이 있음
	 * 2. servlet-context(개별 부분) : 서블릿 각자의 Bean들이 모인 공간으로 웹 앱 그 자체를 의미하기도 함
	 * => context 내에서 Bean들은 서로 공유 불가 - MVC의 Controller가 이에 해당
	 */
	
	//요청 처리 메소드는 Front Controller에 의해 자동 호출되는 메소드
	// => 요청 처리 메소드에 매개변수를 작성하면 Front Controller는 스프링 컨테이너(WebApplicationContext 객체)
	//에게 매개변수에 저장 가능한 객체(Spring Bean)를 제공받아 저장
	@RequestMapping("/resultMav")
	public ModelAndView modelAndViewResult(ModelAndView modelAndView) {
		modelAndView.setViewName("result_display");
		modelAndView.addObject("mavName", "홍길동");
		
		return modelAndView;
	}
	
	@RequestMapping("/resultRequest")
	public String requestResult(HttpServletRequest request) {
		//HttpServletRequest.setAttribute(String attributeName, Object attributeValue)
		// => HttpServletRequest 객체에 처리결과를 속성값으로 저장하는 메소드 - Request Scope
		request.setAttribute("requestName", "임꺽정");
		return "result_display";
	}
	
	@RequestMapping("/resultModel")
	public String modelResult(Model model) {
		//Model 객체 : 처리결과를 속성값으로 저장하여 뷰에게 제공하기 위한 객체
		//Model.addAttribute(String attributeName, Object attributeValue)
		// => Model 객체에 처리결과를 속성값으로 저장하는 메소드 - Request Scope
		model.addAttribute("modelName", "전우치");
		return "result_display";
	}
	
	
}
