package xyz.itwill06.oop;

public class OopTwo {
	/*
	private void beforeLog() {
		System.out.println("### 메소드의 명령(핵심관심코드)이 실행되기 전에 기록될 내용 ###");
	}
	*/
	
	private OopLogger logger=new OopLogger();
	
	public void display1() {
		//beforeLog();
		logger.beforeLog();
		System.out.println("*** OopOne 클래스의 display1() 메소드 호출 ***");
	}

	public void display2() {
		//beforeLog();
		logger.beforeLog();
		System.out.println("*** OopOne 클래스의 display2() 메소드 호출 ***");
	}
	
	public void display3() {
		//beforeLog();
		logger.beforeLog();
		System.out.println("*** OopOne 클래스의 display3() 메소드 호출 ***");
	}
}
