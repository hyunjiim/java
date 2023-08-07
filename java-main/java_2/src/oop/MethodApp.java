package oop;

import java.util.Scanner;

//실행이 목적인 클래스-main 메소드를 반드시 작성
public class MethodApp {
	public static void main(String[] args) {
		//클래스로 객체를 생성하여 객체의 메모리 주소를 참조변수에 저장
		//=>같은 패키지에 작성된 클래스는 패키지 표현없이 클래스 사용 가능
		//=>참조변수를 사용하여 객체의 필드 또는 메소드 접근 가능
		Method method=new Method();
		
		//참조변수를 출력할 경우 "자료형@메모리주소" 형식의 문자열을 제공받아 출력
		System.out.println("method= "+method);
		System.out.println("=============================================================================");
		
		//메소드 호출: 객체를 이용하여 메소드를 호출하면 프로그램의 흐름(스레드)은 객체의 메소드로 이동하여 
		//메소드의 명령을 실행하고 메소드가 종료되면 메소드를 호출한 다음 차례의 명령 실행
		method.displayOne();
		System.out.println("=============================================================================");
		
		method.displayTwo();
		System.out.println("=============================================================================");
		
		method.printOne();
		System.out.println("=============================================================================");
		
		method.printTwo(50);
		method.printTwo(80);
		System.out.println("=============================================================================");
		
		method.printThree(35, 79);
		method.printThree(88, 19);
		method.printThree(-1,0);
		System.out.println("=============================================================================");
		
		int result= method.returnTot(30,70);
		System.out.println("[합계]: "+result);
		System.out.println("[합계]: "+method.returnTot(30,70));
		result=method.returnTot(-1, 70);
		if(result==0) {
			System.out.print("");
		}else{
			System.out.println(result);
		}
		System.out.println("=============================================================================");

		boolean result1=method.isOddEven(10);
		if(result1) {
			System.out.println("매개변수로 전달된 값은 [짝수]입니다.");
		}else {
			System.out.println("매개변수로 전달된 값은 [홀수]입니다.");
		}
		System.out.println("=============================================================================");
		if(method.isOddEven(9)) {
			System.out.println("매개변수로 전달된 값은 [짝수]입니다.");
		}else {
			System.out.println("매개변수로 전달된 값은 [홀수]입니다.");
		}
		System.out.println("=============================================================================");
		//배열의 메모리 주소를 반환하는 메소드를 호출하면 반환된 메모리 주소를 참조변수에 저장
		//=>참조변수에 저장된 메모리 주소를 사용하여 배열 참조 가능
		int[] array=method.returnArray();
		for(int num:array) {
			System.out.print(num+" ");
		}
		System.out.println();
		System.out.println("=============================================================================");
		
		System.out.println("합계 = "+method.sumOne(10, 20, 30));
		//System.out.println("합계 = "+method.sumOne());
		//System.out.println("합계 = "+method.sumOne(10, 20));
		//System.out.println("합계 = "+method.sumOne(10, 20, 30, 40));
		System.out.println("=============================================================================");
		//매개변수의 배열의 메모리 주소를 전달하여 메소드 호출
		System.out.println("합계 = "+method.sumTwo(new int[] {10,20,30,40}));
		System.out.println("합계 = "+method.sumTwo(new int[] {10,20,30}));
		System.out.println("합계 = "+method.sumTwo(new int[] {10,20}));
		System.out.println("합계 = "+method.sumTwo(new int[] {}));
		
		System.out.println("=============================================================================");
		
		//매개변수 생략기호(...)를 사용한 메소드를 호출할 때 new를 사용해 객체생성을 하지 않아도 됨
		System.out.println("합계 = "+method.sumThree(10,20,30));
	    System.out.println("합계 = "+method.sumThree());
	    System.out.println("합계 = "+method.sumThree(10,20));
	    System.out.println("합계 = "+method.sumThree(10,20,30,40));

	}
}
