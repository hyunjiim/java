package inheritance;

//이벤트 관련 회원정보(아이디, 이름, 이메일)를 저장하기 위한 클래스
//회원정보를 저장하기 위해 Member 클래스를 상속받아 작성하는 것을 권장
public class MemberEvent extends Member{
	/*private String id;
	private String name;
	*/
	private String email;
	
	//자식클래스의 메소드에서는 this 키워드로 자식클래스 객체의 필드 또는 메소드를 참조하고
	//자식클래스 객체의 필드 또는 메소드가 없는 경우 부모클래스 객체의 필드 또는 메소드 참조
	public MemberEvent() {
		// TODO Auto-generated constructor stub
	}

	/*
	 public MemberEvent(String id, String name, String email) {
		super(); //부모클래스의 매개변수가 없는 기본 생성자 호출
		setId(id);
		//this.id = id;
		setName(name);
		//this.name = name;
		this.email = email;
	}
	*/
	
	public MemberEvent(String id, String name, String email) {
		super(id, name);
		this.email = email;
	}

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	public void display() {
		System.out.println("아이디: "+getId());
		System.out.println("이름: "+getName());
		System.out.println("이메일: "+email);
	}
}
