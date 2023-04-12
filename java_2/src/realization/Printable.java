package realization;

public interface Printable {
	void print();
	
	//JDK11 버전 이상에서는 인터페이스에 명령을 작성할 수 있는 기능의 기본 메소드 선언 가능
	//기본 메소드(Default Method): 인터페이스를 상속받은 자식클래스에서 오버라이드 선언하지 않아도 되는 메소드
	default void scan() {
		System.out.println("[Error]스캔 기능을 제공하지 않습니다.");
	}
}
