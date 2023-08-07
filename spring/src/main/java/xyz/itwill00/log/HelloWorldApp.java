package xyz.itwill00.log;

public class HelloWorldApp {
	public static void main(String[] args) {
		//로그 구현체를 사용하지 않아도 System.out.println()을 사용하여 확인 가능
		//클래스가 바뀌면 바꿔야 한다는 점, 코드 증가로 실행 시간이 늘어난다는 점에서 비효율적
		System.out.println("HelloWorldAapp 클래스의 main 메소드 - 시작");
		HelloWorld hw=new HelloWorld();
		String message=hw.hello("홍길동");
		System.out.println("message = "+message);
		System.out.println("HelloWorldAapp 클래스의 main 메소드 - 종료");
	}
}