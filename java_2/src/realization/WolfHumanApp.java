package realization;

//인터페이스(Interface): 현실에 존재하는 대상을 클래스보다 추상적으로 표현하기 위한 자료형(참조형)
public class WolfHumanApp {
	public static void main(String[] args) {
		WolfHuman wolfHuman=new WolfHuman();
		
		wolfHuman.speak();
		wolfHuman.walk();
		wolfHuman.smile();
		wolfHuman.change();
		wolfHuman.fastWalk();
		wolfHuman.cryLoudly();
		System.out.println("===========================================");
	}
}
