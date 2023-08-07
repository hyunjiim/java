package xyz.itwill00.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//실행 후 F5(새로고침) 버튼을 클릭하면 dailyLog 파일 생성
public class LogHelloWorldApp {
	//Logger 객체 : 로그 이벤트를 발생시키기 위한 객체
	// => 로그 이벤트가 발생되면 로그 구현체가 로깅정보를 제공받아 기록
	//LoggerFactory 클래스 : Logger 객체를 생성하여 제공하기 위한 클래스 - Factory 디자인 패턴을 이용해 만들어진 클래스
	//LoggerFactory.getLogger(Class<T> clazz) : 메모리에 저장된 클래스(Class 객체 - Clazz)를
	//전달받아 해당 클래스에서 로그 이벤트를 발생할 수 있는 Logger 객체를 생성하여 반환하는 메소드
	private static final Logger logger=LoggerFactory.getLogger(LogHelloWorldApp.class);
	
	public static void main(String[] args) {
		//Logger.info(String message): Logger 객체로 INFO 레벨의 로그 이벤트를 발생시키는 메소드
		// => 매개변수에는 로그 구현체로 기록될 로그 메세지 전달
		// => Logger.debug(String message) 같이 다른 이벤트 레벨의 메소드를 사용할 수도 있음
		//log4j.xml 파일에서 warn 이상의 레벨만 기록되도록 설정했기 때문에 info 메소드를 통해 전달한 메세지는
		//콘솔에서 확인 불가
		// => log4j.xml 파일에서 해당 패키지의 로그 이벤트 level을 info로 설정하는 logger 엘리먼트 추가
		logger.info("시작");
		LogHelloWorld hw=new LogHelloWorld();
		String message=hw.hello("홍길동");
		System.out.println("message = "+message);
		logger.info("종료");
		
	}
}
