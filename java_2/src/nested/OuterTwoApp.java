package nested;

import nested.OuterTwo.InnerTwo;

public class OuterTwoApp {
	public static void main(String[] args) {
		OuterTwo outerTwo=new OuterTwo(100);
		
		outerTwo.outerDispalay();
		System.out.println("===========================================================");
		//정적 내부클래스의 생성자를 호출하여 객체 생성 가능
		InnerTwo innerTwo=new InnerTwo();
		innerTwo.innerDisplay();
		System.out.println("===========================================================");
		
		
		System.out.println("===========================================================");

	}
}
