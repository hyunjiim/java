package xyz.itwill06.oop;

public class OopTwo {
	/*
	private void beforeLog() {
		System.out.println("### �޼ҵ��� ���(�ٽɰ����ڵ�)�� ����Ǳ� ���� ��ϵ� ���� ###");
	}
	*/
	
	private OopLogger logger=new OopLogger();
	
	public void display1() {
		//beforeLog();
		logger.beforeLog();
		System.out.println("*** OopTwo Ŭ������ display1() �޼ҵ� ȣ�� ***");
		
	}

	public void display2() {
		//beforeLog();
		logger.beforeLog();
		System.out.println("*** OopTwo Ŭ������ display2() �޼ҵ� ȣ�� ***");
		
	}
	
	public void display3() {
		//beforeLog();
		logger.beforeLog();
		System.out.println("*** OopTwo Ŭ������ display3() �޼ҵ� ȣ�� ***");
		
	}
}
