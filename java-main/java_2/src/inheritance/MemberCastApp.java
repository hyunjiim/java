package inheritance;

//상속관계의 클래스에서 참조변수와 객체와의 관계
public class MemberCastApp {
	public static void main(String[] args) {
		//부모클래스의 참조변수=new 부모클래스();
		//=>부모클래스의 생성자로 객체를 생성하여 부모클래스의 참조변수에 저장
		Member member1=new Member();
		
		//참조변수에 저장된 부모클래스의 객체를 사용하여 부모클래스의 메소드 호출
		member1.setId("abc123");
		member1.setName("고길동");
		
		member1.display();
		System.out.println("=====================================================");
		//자식클래스 참조변수=new 자식클래스();
		//=>부모클래스의 생성자로 부모클래스 객체를 생성하고 자식클래스의 생성자로 자식클래스 객체를 생성하여 자식클래스의 참조변수에 자식클래스의 객체를 저장
		MemberEvent member2=new MemberEvent();
		
		//참조변수에 저장된 자식클래스의 객체를 사용하여 자식클래스의 메소드를 호출할 수 있으며, 상속관계에 의해 부모클래스 객체를 참조하여 부모클래스도 호출 가능
		member2.setId("xyz789");
		member2.setName("임둘리");
		member2.setEmail("xyz@itwill.xyz");
		
		member2.display();
		System.out.println("=====================================================");
		//자식클래스 참조변수=new 부모클래스();
		//=>부모클래스의 생성자로 부모클래스 객체를 생성하고 자식클래스의 참조변수에 부모클래스의 객체 저장-불가능(에러 발생)
		//MemberEvent member3=new Member(); >> Error!
		
		//부모클래스 참조변수=new 자식클래스();
		//=>부모클래스의 생성자로 부모클래스 객체를 생성하고 자식클래스의 생성자로 자식클래스 객체를 생성하여 자식클래스의 참조변수에 
		//  자식클래스의 객체를 저장
		Member member4=new MemberEvent();
		
		//참조변수에 저장된 부모클래스의 객체를 사용하여 부모클래스의 메소드를 호출 가능
		//=>참조변수로 자식클래스 객체를 참조할 수 없으므로 자식클래스도 호출 불가능
		member4.setId("opq456");
		member4.setName("차또치");
		//member4.setEmail("opq@itwill.xyz"); >> Error!
		
		//객체 형변환을 이용하면 부모클래스의 참조변수로 자식클래스의 메소드 호출 가능
		//=>명시적 객체 형변환(강제 형변환), 묵시적 객체 형변환(자동 형변환)
		//=>상속관계의 클래스에서만 객체 형변환 사용 가능
		
		//명시적 객체 형변환:Cast 연산자를 사용하여 부모클래스의 참조변수의 자료형을 일시적으로 자식클래스로 변경하면 참조변수에 자식 클래스의 객체가 자동 저장
		/*
		MemberEvent eventmem4=(MemberEvent)member4;
		eventmem4.setEmail("opq@itwill.xyz");
		*/

		//형변환(Cast 연산자)보다 .연산자가 먼저 실행되기 때문에 Cast 연산자를 괄호로 묶어 먼저 실행되도록 함.
		((MemberEvent)member4).setEmail("opq@itwill.xyz"); 
		//((MemberEvent)member4).display();
		//묵시적 객체 형변환: 부모클래스의 메소드를 자식클래스에서 오버라이드 선언하면 부모클래스의 숨겨진 매소드 대신 
		//자식클래스의 메소드를 호출하기 위해 참조변수의 자료형을 자동으로 자식클래스로 변경하여 일시적으로 자식클래스의 
		//객체가 참조변수에 저장되어 자식 클래스의 메소드 호출 
		member4.display();
		System.out.println("=======================================================");
	}
}
