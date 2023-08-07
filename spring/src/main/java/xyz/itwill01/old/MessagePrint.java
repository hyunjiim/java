package xyz.itwill01.old;

public class MessagePrint {
	public void helloMessagePrint() {
		//new 연산자를 통해 객체 직접 생성 - 객체 간 결합도가 매우 높음
		//HelloMessageObject 클래스가 아닌 HiMessageObject 클래스의 메소드를 사용하고 싶으면?
		// => HelloMessageObject를 참조하는 다른 클래스가 있을 수 있으므로, 기존에 작성한
		//HelloMessageObject를 바꾸기 보단 새로운 메소드를 다시 만들어야 함
		HelloMessageObject object=new HelloMessageObject();
		String message=object.getHelloMessage();
		System.out.println("message = "+message);
	}
	
	//HiMessageObject 클래스의 hiMessage() 메소드를 사용하기 위해 새로운 메소드 생성
	public void hiMessagePrint() {
		HiMessageObject object=new HiMessageObject();
		String message=object.getHiMessage();
		System.out.println("message = "+message);
	}
}
