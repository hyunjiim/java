package oop_01;

//oop-03

//실행이 목적인 클래스 - main 메소드를 반드시 작성
public class MethodApp {
	//프로그램 실생시 JVM(Java Virtual Machine)에 의해 자동 호출하는 특별한 메소드
	public static void main(String[] args) {
		//클래스로 객체를 생성하여 객체의 메모리 주소를 참조변수에 저장
		// => 같은 패키지에 작성된 클래스는 패키지 표현없이 클래스 사용 가능
		// => 참조변수를 사용하여 객체의 필드 또는 메소드 접근 가능
		Method method=new Method();
		
		//참조변수를 출력할 경우 "자료형@메모리주소" 형식의 문자열을 제공받아 출력
		System.out.println("method: "+method);
		System.out.println("================================================");
		method.displayOne();
		method.displayTwo();
		System.out.println("================================================");
		method.printOne();
		method.printTwo(50);
		method.printThree(60, 20);
		
		int tot=method.returnTot(60, 20);
		
		if(tot!=0) {
			System.out.println("합계: "+tot);
		}
		System.out.println("================================================");
		boolean result=method.isOddEvent(10);
		if(result) {//짝수일때
			System.out.println("매개변수로 전달된 값은 [짝수] 입니다.");
		}else {
			System.out.println("매개변수로 전달된 값은 [홀수] 입니다.");
		}
		System.out.println("================================================");
		//배열의 메모리 주소를 반환하는 메소드를 호출하면 반환된 메모리 주소를 참조변수에 저장
		//=> 참조변수에 저장된 메모리 주소를 사용하여 배열 참조 가능
		int[] array=method.returnArray();
		for(int num:array) {
			System.out.print(num+" ");
		}
		System.out.println();
		System.out.println("================================================");
		System.out.println("합계: "+method.sumTwo(new int[] {10,20,30}));
		System.out.println("합계: "+method.sumTwo(new int[] {}));
		System.out.println("합계: "+method.sumTwo(new int[] {10,20}));
		System.out.println("합계: "+method.sumTwo(new int[] {10,20,30,40}));
		System.out.println("================================================");
		System.out.println("합계: "+method.sumThree(10,20,30));
		System.out.println("합계: "+method.sumThree());
		System.out.println("합계: "+method.sumThree(10,20));
		System.out.println("합계: "+method.sumThree(10,20,30,40));
		
	}
}
