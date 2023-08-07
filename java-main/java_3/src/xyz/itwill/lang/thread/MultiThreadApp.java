package xyz.itwill.lang.thread;

public class MultiThreadApp {
	
	//JVM에 의해 main 스레드가 생성되어 main() 메소드를 호출하여 main() 메소드에 작성된 명령 실행
	public static void main(String[] args) throws InterruptedException {
		
		/*
		//Thread 클래스로 직접 객체를 생성하여 start() 메소드 호출
		//=>새롭게 생성된
		Thread thread=new Thread();
		thread.start();
		*/
		
		MultiThreadOne one=new MultiThreadOne();
		//Thread.start(): Thread 객체로 새로운 스레드를 생성하기 위한 메소드
		//=>생성된 스레드는 자동으로 Thread 객체의 run() 메소드(숨겨진 메소드)를 호출
		//=>자식클래스의 오버라이드 선언된 run() 메소드가 호출되어 명령 실행
		one.start();
		
		//하나의 Thread 객체는 하나의 스레드 생성만 가능
		//=>Thread 객체를 사용하여 start() 메소드를 여러번 호출할 경우 IllegalThreadStateException 발생
		//=>다중 스레드 프로그램에서 예외가 발생된 경우 예외가 발생된 스레드만 소멸
		//one.start(); //예외가 발생되면 main 스레드 소멸
		
		//Thread 객체를 사용하여 start() 메소드외에 다른 메소드를 호출하지 않을 경우 참조변수 
		//객체를 저장하지 않고 객체를 생성하여 직접 메소드 호출
		new MultiThreadOne().start();
		new MultiThreadOne().start();
		
		MultiThreadTwo two=new MultiThreadTwo();
		
		for(char i='A';i<='Z';i++) {
			System.out.print(i);
			//Thread.sleep(long ms): 매개변수로 전달된 시간(ms)동안 스레드를 일시중지하는 메소드
			//=>메소드에서 InterruptedException 전달 - 일반 예외이므로 예외처리를 하지 않으면 에러 발생
			Thread.sleep(500);
		}
	}
}
