package xyz.itwill02.factory;

//xyz.itwill01.old 패키지의 HiMessageObject, HelloMessageObject의 객체 생성을
//new 연산자를 사용하여 개발자가 직접 생성하는 것이 아닌, Factory에서 대신 생성
//하여 결합도를 낮추는 방법

//Factory 클래스로 제공될 객체를 생성하는 클래스가 반드시 상속받아야 되는 부모인터페이스
// => Factory 클래스로 제공받은 객체가 변경돼도 메소드는 변경되지 않도록 인터페이스 상속
//인터페이스를 상속받은 자식 클래스는 반드시 인터페이스에 선언된 모든 추상메소드를 오버라이드 선언
// => 인터페이스를 상속받은 클래스의 메소드 작성 규칙을 제공 - 작업지시서 역할
//인터페이스로 참조변수를 생성하면 참조변수에는 인터페이스를 상속받은 모든 자식클래스의 객체 저장 가능
// => 인터페이스로 생성된 참조변수로 추상메소드를 호출하면 참조변수에 저장된 자식 객체의 오버라이드
//메소드 호출 - 오버라이드에 의한 다형성 : 객체 간의 결합도 감소
public interface MessageObject {
	String getMessage();
}
