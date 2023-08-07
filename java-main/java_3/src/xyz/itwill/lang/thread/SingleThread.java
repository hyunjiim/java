package xyz.itwill.lang.thread;

public class SingleThread {
	public void display() {
		/*
		System.out.println("SingleThread 클래스의 display() 메소드 시작");
		System.out.println("SingleThread 클래스의 display() 메소드 종료");
		*/
		
		for(char i='a';i<='z';i++) {
			System.out.print(i);
		}
		
	}
}
