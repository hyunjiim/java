package xyz.itwill.exception;

public class ExceptionThrowsApp {
	public static void display() throws ArrayIndexOutOfBoundsException {
		int[] array= {10,20,30,40,50};
		
		for(int i=0;i<array.length;i++) {
			System.out.println("array["+i+"] = "+array[i]);
		}
	}
	
	public static void main(String[] args) {
		//ExceptionThrowsApp.display();  =>정적메소드는 클래스를 이용하여 호출 가능
		try{
			display(); //같은 클래스의 정적메소드는 클래스 표현없이 메소드 호출
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("[에러]프로그램에 예기치 못한 오류가 발생되었습니다.");
		}
	}
}
