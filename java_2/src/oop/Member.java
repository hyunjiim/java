package oop;

//생성자
//회원정보(아이디, 이름, 이메일)를 저장하기 위한 클래스
public class Member {
	// 필드 선언: 객체를 생성하면 객체의 필드에는 기본값(숫자형:0, 논리형:false, 참조형:NULL)이 초기값으로 자동 저장
//	 => 객체 생성시 객체 필드에 초기값으로 자동 저장될 기본값 변경 가능
	private String id="NoId";
	private String name="NoName";
	private String email="NoEmail";
	
//	생성자 선언: 객체를 생성하기 위한 특별한 형태의 메소드
//	=>생성자를 선언하지 않으면 매개변수가 없는 기본 생성자 제공
	
//	매개변수가 없는 생성자 선언- 기본 생성자(Default Constructor)
//	=>초기화 작업 미구현- 객체 필드에 기본값이 초기값으로 저장
	
	public Member() {
		// TODO Auto-generated constructor stub
//		this(값, 값,...); :생성자에서 this 키워드로 다른 생성자를 호출하는 명령
		//this("NoId", "NoName","NoEmail");
	}
	
//	매개변수가 있는 생성자
//	매개변수에 전달되어 저장된 값을 필드의 초기값으로 저장
	public Member(String id) {
		this.id=id;
	}
	
	public Member(String id, String name) {
		this.id=id;
		this.name=name;
	}
	
	
	
	public Member(String id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

//	메소드 선언
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// 필드값을 확인하기 위해 필드값을 출력하는 메소드
	public void display() {
		System.out.println("아이디: " + id);
		System.out.println("이름: " + name);
		System.out.println("이메일: " + email);
	}

}
