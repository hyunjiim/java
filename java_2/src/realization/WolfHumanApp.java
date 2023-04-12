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
		//부모클래스로 참조변수를 생성하여 자식클래스의 객체 저장
		//=>참조변수는 기본적으로 부모클래스의 메소드만 호출 가능
		//=>오버라이드된 메소드의 경우 자식클래스의 메소드 호출
		Human human=new WolfHuman();
		
		human.speak();
		human.walk();
		human.smile();
		System.out.println("============================================");
		//명시적 객체 형변환을 사용하여 자식클래스의 메소드 호출
		((WolfHuman)human).change();
		System.out.println("============================================");
		//인터페이스로 참조변수를 생서앟여 자식클래스의 객체 저장 가능
		//Wolf wolf=new WolfHuman();
		
		//자식클래스가 같은 클래스와 인터페이스는 명시적 형변환을 이용하면 자식클래스의 객체를 공유하여 사용 가능
		Wolf wolf=(Wolf)human;
		
		//묵시적 객체 형변환에 의해 자동으로 자식클래스의 메소드가 호출
		wolf.fastWalk();
		wolf.cryLoudly();
		System.out.println("============================================");
	}
}
