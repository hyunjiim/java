package xyz.itwill05.di;

//Dependency Injection

//학생정보를 저장하기 위한 클래스 - VO 클래스, DTO 클래스, POJO(Plane Old Java Object) 클래스 - 스프링
// => 필드에 학생정보를 표현하는 값을 필드에 저장
public class Student {
	private int num;
	private String name;
	private String email;
	
	//생성자를 작성해주는 이유 : 생성자 매개변수를 통해 객체 필드에 초기값을 주기 위해 작성 - 간편
	public Student() {
		System.out.println("### Student 클래스의 기본 생성자 호출 ###");
	}
	
	public Student(int num) {
		super();
		this.num = num;
		System.out.println("### Student 클래스의 매개변수(학번)가 선언된 생성자 호출 ###");
	}
	
	//매개변수의 자료형은 다르지만 갯수가 같은 생성자 작성
	public Student(String name) {
		super();
		this.name = name;
		System.out.println("### Student 클래스의 매개변수(이름)가 선언된 생성자 호출 ###");
	}
	

	public Student(int num, String name) {
		super();
		this.num = num;
		this.name = name;
		System.out.println("### Student 클래스의 매개변수(학번, 이름)가 선언된 생성자 호출 ###");
	}

	public Student(int num, String name, String email) {
		super();
		this.num = num;
		this.name = name;
		this.email = email;
		System.out.println("### Student 클래스의 매개변수(학번, 이름, 이메일)가 선언된 생성자 호출 ###");
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
		System.out.println("*** Student 클래스의 setNum(int num)메소드 호출 ***");
		System.out.println("*** Student 클래스의 setNum(int num)메소드 호출 ***");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("*** Student 클래스의 setName(String name)메소드 호출 ***");
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
		System.out.println("*** Student 클래스의 setEmail(String email)메소드 호출 ***");
	}
	
	@Override
	public String toString() {
		return "학번 = "+num+" 이름 = "+name+" 이메일 = "+email;
	}
	
	
	
	
}
