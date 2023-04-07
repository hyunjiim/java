package oop;

public class RuntimeApp {
	public static void main(String[] args) {
		//Runtime 클래스로 객체 만들기
		//생성자가 은닉화 선언되어 있어 new 연산자로 객체 생성 불가능
		//Runtime runtime= new Runtime();
		
		//Runtime.getRuntime(): Runtime 객체를 반환하는 메소드
		//=>정적 메소드이므로 클래스를 이용하여 호출 가능
		//=>getRuntime() 메소드를 여러번 호출해도 같은 객체를 반환
		Runtime runtime1=Runtime.getRuntime();
		Runtime runtime2=Runtime.getRuntime();
	
	    System.out.println("runtime1= "+runtime1);
	    System.out.println("runtime2= "+runtime2);
	    System.out.println("========================================================");
	    System.out.println("메모리 정리 전 JVM 사용 메모리의 크기 >>");
	    System.out.println((runtime1.totalMemory()-runtime1.freeMemory())+"Byte");
	
	    runtime1.gc();
	    
	    System.out.println("메모리 정리 후 JVM 사용 메모리의 크기 >>");
	    System.out.println((runtime1.totalMemory()-runtime1.freeMemory())+"Byte");
	}
}
