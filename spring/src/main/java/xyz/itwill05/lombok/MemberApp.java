package xyz.itwill05.lombok;

public class MemberApp {
	public static void main(String[] args) {
		Member member1=new Member("abc123", "홍길동", "abc@itwill.xyz");
		
		System.out.println("아이디 = "+member1.getId());
		System.out.println("이름 = "+member1.getName());
		System.out.println("이메일 = "+member1.getEmail());
		System.out.println("===============================================================");
		//Memebr 클래스로 생성된 참조변수를 출력할 경우 Member 클래스의 toString() 메소드 자동 호출
		System.out.println(member1); //Member(id=abc123, name=홍길동, email=abc@itwill.xyz)
		System.out.println("===============================================================");
		//Member 객체를 new 연산자가 아닌 builder() 메소드를 통해 생성
		//클래스명.builder() : 클래스 내부에 작성된 Builder 클래스로 객체를 생성하여 반환하는 메소드
		// => Builder 객체로 필드명과 같은 이름의 메소드를 호출하여 필드값 변경
		// => Builder.build() : 클래스로 객체를 생성하여 반환하는 메소드
		Member member2=Member.builder()
				.id("xyz789")
				.name("임꺽정")
				.email("xyz@itwill.xyz")
				.build();
		System.out.println(member2); //Member(id=xyz789, name=임꺽정, email=xyz@itwill.xyz)
		System.out.println("===============================================================");
		
		
	}
}
