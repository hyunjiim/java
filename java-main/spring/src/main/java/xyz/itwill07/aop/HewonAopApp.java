package xyz.itwill07.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//AOP : 객체지향 프로그래밍/로그 처리, 보안, 트랜잭션 관리 그리고 예외사항 처리 등의 코드를 단일 모듈로
//각각 작성하고 필요한 시점에 핵심코드를 삽입하여 동작하게 하는 것

//AOP의 목적 : OOP와 같은 모듈화가 뛰어난 방법을 사용하더라도 결코 쉽게 분리된 모듈로 작성하기 힘든
//요구사항이 실제 어플리케이션 설계와 개발에서 자주 발견됨
// => AOP에서는 이를 횡단 관심이라 함

//횡단 관심(Crosscutting Concerns): 결코 쉽게 분리된 모듈로 작성하기 힘든 요구사항으로, 객체지향의 기본
//원칙을 지키면서 이를 분리해서 모듈화하는 것이 매우 어려움
//핵심 관심(Core Concerns): 해당 시스템의 핵심 가치와 목적이 그대로 드러난 관심영역으로, 기존의 객체지향
//분석/설계(OOAD)를 통해 쉽게 모듈화와 추상화가 가능함

public class HewonAopApp {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("07-1_aop.xml");
		HewonService service=context.getBean("hewonService", HewonService.class);
		System.out.println("==========================================================");
		service.addHewon(null);
		System.out.println("==========================================================");
		service.getHewon(0);
		System.out.println("==========================================================");
		service.getHewonList();
		System.out.println("==========================================================");
		((ClassPathXmlApplicationContext)context).close();
	}
}
