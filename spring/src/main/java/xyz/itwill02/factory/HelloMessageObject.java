package xyz.itwill02.factory;

//xyz.itwill01.old 패키지의 HiMessageObject, HelloMessageObject의 객체 생성을
//개발자가 아닌 Factory에서 대신 하여 결합도를 낮추는 방법

//Factory 클래스로 제공받은 객체가 변경돼도 메소드는 변경되지 않도록 반드시 인터페이스를 상속받아 작성
public class HelloMessageObject implements MessageObject {

	@Override
	public String getMessage() {
		return "Hello!!!";
	}

}
