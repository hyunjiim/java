package xyz.itwill.custom;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

//커스텀 태그(Custom Tag): JSP 문서에서 스크립트 요소 대신 사용하기 위해 프로그래머가 생성한 태그
// => 태그 클래스 작성 >> TLD 파일에 커스텀 태그 등록 >> JSP 문서에서 커스텀 태그 사용

//태그 클래스 : JSP 문서에서 커스텀 태그를 사용할 경우 호출될 메소드가 선언된 클래스
// => TagSupport 클래스. BodyTagSupport 클래스, SimpleTagSupport 클래스 중 하나를 상속받아 작성
// => 커스텀 태그 사용시 호출되는 메소드는 부모클래스의 메소드를 오버라이드 선언하여 작성

//태그 속성과 태그 내용이 없는 커스텀 태그의 클래스
public class HelloTag extends TagSupport {
	private static final long serialVersionUID = 1L;
	
	//JSP 문서에서 커스텀 태그를 최초로 사용할 경우 태그 클래스를 객체로 생성하기 위해 한번만 호출
	public HelloTag() {
		System.out.println("HelloTag 클래스의 기본생성자 호출 - 객체 생성");
	}
	
	//모든 메소드를 오버라이드 할 필요없이 필요한 것만 오버라이드하여 사용 가능
	
	/* 실행 결과: doAfterBody() 메소드는 생성되지 않음 - tld 파일에서 태그 내용 empty로 설정
	 HelloTag 클래스의 기본생성자 호출 - 객체 생성
	 HelloTag 클래스의 doStartTag() 메소드 호출
	 HelloTag 클래스의 doEndTag() 메소드 호출
	 */
	
	//JSP 문서에서 커스텀 태그의 시작 태그를 사용할 때마다 호출되는 메소드
	@Override
	public int doStartTag() throws JspException {
		//System.out.println("HelloTag 클래스의 doStartTag() 메소드 호출");
		
		try {
			//부모클래스로부터 제공받은 PageContext 객체(pageContext 변수에 저장되어 있음)를 이용하여 웹프로그램 작성에
			//필요한 객체를 반환받아 명령 작성
			//pageContext.getOut(): 응답문서를 생성하기 위한 출력스트림(JspWriter 객체)을 반환
			pageContext.getOut().println("<div>안녕하세요.</div>");
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		//doStartTag() 메소드의 반환값(정수값): 부모클래스에서 제공되는 상수 사용
		// => 상수: SKIP_BODY, EVAL_BODY_INCLUDE 중 하나를 선택하여 반환
		// SKIP_BODY: 태그내용을 클라이언트에게 전달하지 않을 경우 사용하는 상수 - 기본값
		// EVAL_BODY_INCLUDE: 태그내용을 클라이언트에게 전달할 경우 사용하는 상수
		return SKIP_BODY;
	}
	
	//JSP 문서에서 커스텀 태그의 태그내용을 사용할 때마다 호출되는 메소드
	@Override
	public int doAfterBody() throws JspException {
		//System.out.println("HelloTag 클래스의 doAfterBody() 메소드 호출");
		
		//doAfterBody() 메소드의 반환값(정수값): 부모클래스에서 제공되는 상수 사용
		//상수: SKIP_BODY, EVAL_BODY_AGAIN 중 하나를 선택하여 반환
		//SKIP_BODY: 태그내용을 다시 전달하지 않을 경우 사용하는 상수 - 기본값
		//EVAL_BODY_AGAIN: 태그내용을 클라이언트에게 다시 전달할 경우 사용하는 상수
		return SKIP_BODY;
	}
	
	//JSP 문서에서 커스텀 태그의 종료태그를 사용할 때마다 호출되는 메소드
	@Override
	public int doEndTag() throws JspException {
		//System.out.println("HelloTag 클래스의 doEndTag() 메소드 호출");
		
		//doEndTag() 메소드의 반환값(정수값): 부모클래스에서 제공되는 상수 사용
		//상수: SKIP_PAGE, EVAL_PAGE 중 하나를 선택하여 반환
		//SKIP_PAGE: 종료태그 실행 후 JSP 문서를 강제로 종료할 경우 사용하는 상수
		//EVAL_PAGE: 종료태그 실행 후 JSP 문서를 계속 실행할 경우 사용하는 상수 - 기본값
		//SKIP_PAGE를 반환하면 hello_tag.jsp 문서에서 <simple:hello/>를 3번 작성했어도
		//하나의 태그만 실행하고 종료됨
		return SKIP_PAGE;
	}
	
}

