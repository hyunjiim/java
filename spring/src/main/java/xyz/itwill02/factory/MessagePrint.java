package xyz.itwill02.factory;

//참고:https://devmoony.tistory.com/100
//IoC(Inversion of Control) : 제어의 역행 - 메소드나 객체의 호출을 개발자가 결정하는 것이 아닌,
//외부에서 결정되는 것

//IoC 개념을 적용하여 얻는 장점 : Container 기능을 제공하여 객체간의 결합도 낮춤
//결합도 : 소프트웨어 코드의 한 요소가 다른 것과 얼마나 강력하게 연결되어있는지에 대한 정도
// => 결합도가 심할수록 클래스와 결합되어 있는 다른 클래스들도 같이 유지보수해야 할 가능성이 높음

//결합도 낮추는 방법 : 다형성, Container

//Container : 객체의 생성, 운용, 소멸 등의 객체의 라이프사이클 관리 담당
// => 주요 기능 - 생명주기 관리, Configuration, Lookup, Dependency Resolution
//필요성 : 컴포넌트/오브젝트의 자유로운 삽입이 가능하도록 하기 위한 Calling Code의 독립성, 서비스의 
//lookup이나 configuration의 일관성, 단일화된 서비스의 접근방법 제공, Container을 이용한 결합도 낮춤

//IoC의 구현 방법
//1. Dependency Lookup - 의존성 검색
// => Bean에 접근하기 위해 컨테이너가 제공하는 API를 이용하여 Bean을 Lookup하는 것
// => Container가 callback을 통해 제공하는 lookup context를 이용해서 필요한 리소스나 오브젝트를 얻는 방식
// => EJB, Apache Avalon의 구현 방법
//EJB(Enterprise JavaBeans) : 엔터프라이즈 어플리케이션 개발을 단순화하고자 하는 객체

//2. Dependency Injection - 의존성 주입
// => 각 클래스 간의 의존성을 자신이 아닌 외부(컨테이너)에서 주입하는 것
// => 비즈니스 오브젝트에 Lookup 코드를 사용하지 않고 Container가 직접 의존구조를 오브젝트에 설정
//할 수 있도록 지정해 주는 방법


public class MessagePrint {
	public void messagePrint() {
		//객체를 직접 생성하여 메소드 호출 - 객체 간의 결합도가 높아 유지보수 효율성 감소
		//MessageObject object=new HelloMessageObject();
		
		//프로그램 실행에 필요한 객체를 new 연산자가 아닌 Factory 클래스로부터 제공받아 메소드 호출
		// => IoC(Inversion of Control) : 제어의 역행 - 객체간의 결합도를 낮춰 유지보수의 효율성 증가
		//MessageObject object=MessageObjectFactory.getMessageObject(1);
		MessageObject object=MessageObjectFactory.getMessageObject(2);
		
		//인터페이스로 생성된 참조변수로 추상메소드를 호출한 경우 참조변수에 저장된 자식 객체의
		//오버라이드 메소드 호출 - 묵시적 객체 형변환 : 오버라이드에 의한 다형성
		String message=object.getMessage();
		System.out.println("message = "+message);
		
	}
}
