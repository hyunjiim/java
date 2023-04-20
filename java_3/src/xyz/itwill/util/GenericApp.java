package xyz.itwill.util;

//제네릭 타입의 필드가 선언된 클래스(제네릭클래스)로 객체를 생성하여 사용하는 프로그램
public class GenericApp {
	public static void main(String[] args) {
		//제네릭 클래스를 사용할 경우 제네릭 타입 대신 사용된 Java 자료형을 전달하여 사용
		//=>전달받은 Java 자료형을 제네릭 타입 대신 사용하여 필드 또는 메소드 완성
		Generic<Integer> generic1=new Generic<Integer>();
		
		//제네릭 타입 대신 사용될 Java 자료형과 동일한 자료형의 객체를 전달받아 필드값 변경
		//=>제네릭 타입 대신 사용될 Java 자료형과 다른 자료형의 객체를 전달한 경우 에러 발생
		generic1.setField(100);
		
		Integer returnObject1=generic1.getField();
		
		System.out.println("필드값= "+returnObject1);
		System.out.println("========================================================");
		
		Generic<Double> generic2=new Generic<Double>();
		
		generic2.setField(12.34);
		
		Double returnObject2=generic2.getField();
		
		System.out.println("필드값= "+returnObject2);
		System.out.println("========================================================");
		//제네릭 타입이 상속받지 못한 클래스로 사용할 경우 에러 발생
		/*
		Generic<String> generic3=new Generic<String>();
		
		generic3.setField("홍길동");
		
		String returnObject3=generic3.getField();
		
		System.out.println("필드값= "+returnObject3);
		*/
		
		
	}
}
