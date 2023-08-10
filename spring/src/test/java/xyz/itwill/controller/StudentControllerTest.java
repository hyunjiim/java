package xyz.itwill.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.extern.slf4j.Slf4j;

//보통 Service 클래스가 데이터를 전달받아 처리하기 때문에 Controller 클래스가 아닌 
//Service 클래스에 대한 테스트 프로그램을 작성한다.
//SpringJUnit4ClassRunner는 스프링 컨테이너를 내부적으로 생성 - ApplicationContext 객체가 생성되는데
//우리가 검사하는 건 웹 프로그램이기 때문에 WebApplicationContext 객체를 받을 수 있도록 해야 함
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
//[*] 패턴문자를 사용하여 Spring Bean Configuration File 설정 가능
// => [**] 형식으로 0개 이상의 하위 폴더를 표현
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@Slf4j
public class StudentControllerTest {
	//WebApplicationContext 객체를 제공받아 저장하기 위한 필드 선언 - 의존성 주입
	// => WebApplicationContext 객체 : SpringMVC 프로그램에서 스프링 컨테이너 기능을 제공하기 위한 객체
	@Autowired
	private WebApplicationContext context;
	
	//MockMvc 객체를 저장하기 위한 필드 선언
	// => MockMvc 객체 : 요청과 응답을 가상으로 제공하기 위한 객체
	private MockMvc mvc;
	
	/* [Builder 클래스와 Factory 클래스, Filter 클래스] - 공부하기
	 *  
	 * 
	 */
	//Factory 클래스는 인터페이스를 상속받은 자식 클래스를 여러 개 생성하고 그 중 하나를 반환받음
	
	
	//@Before : 테스트 메소드 호출 전에 실행될 명령을 작성한 메소드에 설정하는 어노테이션 - 초기화
	@Before
	public void setup() {
		//MockMvcBuilders.webAppContextSetup(WebApplicationContext context)
		// => MockMvcBuilder 객체를 생성하여 반환하기 위한 메소드
		//MockMvcBuilder.build() : MockMvc 객체를 생성하여 반환하기 위한 메소드
		mvc=MockMvcBuilders.webAppContextSetup(context).build();
		log.info("MockMvc 객체 생성");
	}
	
	@Test
	public void testStudentDisplay() throws Exception {
		//MockMvcRequestBuilders.get(String url) : 매개변수로 요청 URL 주소를 전달받아 GET
		//방식으로 웹프로그램을 요청하는 메소드
		// => 요청 페이지에 대한 요청 관련 정보(Request)가 저장된 Builder 객체를 반환
		//MockMvc.perform(Builder requestBuilder) : 가상으로 페이지를 요청하는 메소드
		// => 매개변수에 전달받은 RequestBuilder 객체에 저장된 정보를 이용하여 페이지 요청
		// => Controller 클래스의 요청 처리 메소드 호출
		// => 요청에 대한 처리 결과가 저장된 ResultActions 객체 반환
		//ResultActions.andReturn() : 요청 처리 메소드의 실행결과를 MvcResult 객체로 반환하는 메소드
		MvcResult result=mvc.perform(MockMvcRequestBuilders.get("/student/display")).andReturn();
		
		//MvcResult.getModelAndView() : 요청 처리 메소드에 의해 제공된 ModelAndView 객체를 반환
		log.info(result.getModelAndView().getViewName()); //[결과]student/student_display
		log.info(result.getModelAndView().getModel().toString()); 
		//[결과]{studentList= [Student(no=1000, name=홍길동, phone=010-2326-5596, address=서울시 강남구, birthday=2000-02-16 00:00:00)
		//, Student(no=2000, name=임꺽정, phone=010-3265-6611, address=서울시 용산구, birthday=1996-03-12 00:00:00)
		//, Student(no=3000, name=전우치, phone=010-8846-3652, address=수원시 팔당구, birthday=2002-05-08 00:00:00)
		//, Student(no=4000, name=일지매, phone=010-4611-5675, address=서울시 종로구, birthday=2000-12-31 00:00:00)
		//, Student(no=5000, name=홍경래, phone=010-5467-1326, address=서울시 서대문구, birthday=1999-05-07 00:00:00)
		//, Student(no=6000, name=로빈훗, phone=010-6561-1542, address=서울시 중랑구, birthday=2000-09-09 00:00:00)]}
		
	}

}
