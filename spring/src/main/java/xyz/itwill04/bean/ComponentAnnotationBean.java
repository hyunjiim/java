package xyz.itwill04.bean;

import org.springframework.stereotype.Component;

//@Component : 클래스를 스프링 컨테이너가 관리하는 객체(Spring Bean)으로 등록하는 어노테이션
// => 클래스의 이름을 Spring Bean을 구분하기 위한 식별자(beanNAme)로 사용 - 첫번째 문자는 소문자로 변환
// => @Component 어노테이션의 value 속성을 사용하여 식별자(beanName) 변경 가능 - value 속성만 존재할 경우 속성값만 설정 가능
@Component("bean")
public class ComponentAnnotationBean {
	public ComponentAnnotationBean() {
		System.out.println("### ComponentAnnotationBean 클래스의 기본 생성자 호출 ###");
	}
	
	public void display() {
		System.out.println("*** ComponentAnnotationBean 클래스의 display() 메소드 호출 ***");
	}
	
}
