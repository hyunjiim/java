package xyz.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
 
//TilesView 클래스 : 요청 처리 메소드의 반환값(ViewName)을 제공받아 다수의 JSP 문서가 결합된
//JSP 문서(템플릿 페이지)로 응답하기 위한 기능을 제공하는 클래스 - ViewResolver : [https://enjoydevelop.tistory.com/103] 참고
//1. TilesView 관련 라이브러리(tiles-extras 라이브러리 : 의존관계에 의해 다른 tiles-XXX 라이브러리들도 사용 가능)를
//프로젝트에 빌드 처리 - 메이븐 : pom.xml
//2. 요청 처리 메소드의 반환값(ViewName)을 제공받아 응답할 템플릿 페이지 설정
// => TilesView 프로그램의 환경설정파일을 설정 : [/WEB-INF/spring/appServlet/tiles.xml] - 다른곳에 작성해도 되지만 이렇게 작성하면 접근성에 좋음
//3. Front Controller(DispatcherServlet 클래스)가 요청 처리 메소드의 반환값(ViewName)을 제공받아
//TilesView 클래스를 이용하여 응답 처리되도록 Spring Bean Configuration File(servlet-context.xml) 설정
// => InternalResourceViewResolver 클래스보다 TilesView 클래스가 먼저 실행되도록 우선 순위 설정
//InternalResourceViewResolver란?
// => 미리 지정된 접두사, 접미사를 사용하여 뷰이름으로 컴포넌트의 URL을 완성해 URL을 지정하기 편리
// => 교체 방법: xml 파일에서 설정, Java Config로 설정

//[ViewResolver 실행과정]
//1. 페이지 컨트롤러는 클라이언트가 요청한 작업을 실행한 후 그 결과를 출력할 뷰의 이름 리턴
//2. Front Controller는 RequestHandler가 리턴한 URL을 ViewResolver에게 전달

@Controller
public class TilesController {
	//@RequestMapping("/") : 최상위 패키지?를 호출했을 때
	@RequestMapping("/")
	public String tiles() {
		return "main";
	}
}
