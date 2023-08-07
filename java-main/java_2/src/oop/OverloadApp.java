package oop;

public class OverloadApp {
	public static void main(String[] args) {
		Overload overload = new Overload();

		overload.displayInt(100);
		overload.displayBoolean(false);
		overload.displayString("홍길동");
		System.out.println("==============================================================");
		// 오버로드 선언된 메소드는 매개변수에 전달되는 값에 따라 메소드를 선택하여 호출
		// =>메소드 오버로드에 의한 다형성
		overload.display(100);
		overload.display(true);
		overload.display("임꺽정");
		System.out.println("==============================================================");

	}
}
