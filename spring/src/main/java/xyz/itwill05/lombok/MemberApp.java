package xyz.itwill05.lombok;

public class MemberApp {
	public static void main(String[] args) {
		Member member1=new Member("abc123", "ȫ�浿", "abc@itwill.xyz");
		
		System.out.println("���̵� = "+member1.getId());
		System.out.println("�̸� = "+member1.getName());
		System.out.println("�̸��� = "+member1.getEmail());
		System.out.println("===============================================================");
		//Memebr Ŭ������ ������ ���������� ����� ��� Member Ŭ������ toString() �޼ҵ� �ڵ� ȣ��
		System.out.println(member1); //Member(id=abc123, name=ȫ�浿, email=abc@itwill.xyz)
		System.out.println("===============================================================");
		//Member ��ü�� new �����ڰ� �ƴ� builder() �޼ҵ带 ���� ����
		//Ŭ������.builder() : Ŭ���� ���ο� �ۼ��� Builder Ŭ������ ��ü�� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
		// => Builder ��ü�� �ʵ��� ���� �̸��� �޼ҵ带 ȣ���Ͽ� �ʵ尪 ����
		// => Builder.build() : Ŭ������ ��ü�� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
		Member member2=Member.builder()
				.id("xyz789")
				.name("�Ӳ���")
				.email("xyz@itwill.xyz")
				.build();
		System.out.println(member2); //Member(id=xyz789, name=�Ӳ���, email=xyz@itwill.xyz)
		System.out.println("===============================================================");
		
		
	}
}
