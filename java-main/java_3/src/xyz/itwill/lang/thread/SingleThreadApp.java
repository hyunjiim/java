package xyz.itwill.lang.thread;

public class SingleThreadApp {
	public static void main(String[] args) {
		/*
		System.out.println("SingleThreadApp 클래스의 main() 메소드 시작");
		
		//Thread 클래스: 스레드 관련 정보를 저장하여 스레드 관련 제어 기능을 메소드로 제공하기 위한 클래스
		//Thread.currendThread():현재 명령을 읽어 처리하는 스레드에 대한 Thread 객체를 반환하는 메소드
		//Thread.currendThread().getName(): Thread 객체에 저장된 스레드의 이름(고유값)를 반환하는 메소드
		System.out.println("["+Thread.currentThread().getName()+"] 스레드에 의해 main() 메소드의 명령 실행");
		
		//객체를 생성하여 메소드를 호출한 경우 스레드가 메소드로 이동하여 메소드의 명령 실행
		//=>메소드의 명령을 모두 실행한 후 다시 현재 위치로 되돌아와 나머지 명령 실행
		new SingleThread().display(); //객체를 생성하여 직접 메소드 호출
		
		System.out.println("SingleThreadApp 클래스의 main() 메소드 종료");
		*/
		
		for(char i='A';i<='Z';i++) {
			System.out.print(i);
		}
		System.out.println();
		new SingleThread().display();
	
	}
}
