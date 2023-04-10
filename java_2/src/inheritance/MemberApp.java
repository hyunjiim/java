package inheritance;

public class MemberApp {
	public static void main(String[] args) {
		Member member1=new Member();
		
		member1.setId("abc123");
		member1.setName("고길동");
		
		member1.display();
		
		System.out.println("=====================================================");
		
		Member member2=new Member("xyz456", "임꺽정");
		member2.display();
		
		System.out.println("=====================================================");
		
		
		System.out.println("=====================================================");
		
	}
}
