package xyz.itwill.access;

//접근제한자(Access Modifier): 클래스, 필드, 메소드에 대한 접근 설정을 제한하기 위한 키워드
//=>private, package(default), protected, public
/*
1.private
  클래스 내부에서만 접근 가능하며 클래스 외부에서는 접근 불가능 - 은닉화
 * */
//-----------------------------------------------------------------------------------------------------------
//[package(default)]
//=>같은 패키지의 클래스에서 접근 가능하도록 설정
//=>다른 패키지의 클래스에서 접근 불가능
//=>클래스, 필드, 메소드 선언시 접근 제한자 관련 키워드를 사용하지 않으면 자동 설정되는 접근 제한자
//-----------------------------------------------------------------------------------------------------------
//[protected]
//=>같은 패키지의 클래스에서 접근 가능하도록 설정
//=>다른 패키지의 클래스에서 접근 불가능
//=>다른 패키지의 클래스에서 protected 접근 제한자의 필드 또는 메소드의 클래스를 상속 받은 경우 접근 가능

//-----------------------------------------------------------------------------------------------------------
//[public] 
//=>모든 패키지의 클래스에서 접근 가능하도록 설정
//public 접근 제한자를 사용하여 클래스 선언
//=>public 클래스로 설정된 클래스는 모든 패키지의 클래스에서 접근 가능
//=>public 클래스로 설정되지 않은 클래스는 다른 패키지의 클래스에서 접근 불가능
//=>하나의 소스파일에는 public class를 하나만 설정 가능

public class PrivateMember {
	private int num;
	
	private void display() {
		System.out.println("num = "+num);
	}
}
