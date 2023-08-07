package xyz.itwill02.factory;

//Factory 디자인 패턴을 이용하여 작성된 클래스 - Factory 클래스(Provider 클래스)
// => 프로그램 개발에 필요한 객체를 생성하여 제공하는 기능의 클래스 - 컨테이너(Container) : 관리는 하지 않음

public class MessageObjectFactory {
	//Factory 클래스에 의해 제공될 객체를 구분하기 위한 상수(Constant)
	public static final int HELLO_MSG=1;
	public static final int HI_MSG=2;
	
	public static MessageObject getMessageObject(int messageObject) {
		MessageObject object=null;
		switch (messageObject) {
		case HELLO_MSG:
			object=new HelloMessageObject();
			break;
		case HI_MSG:
			object=new HiMessageObject();
			break;
		}
		return object;
	}
}
