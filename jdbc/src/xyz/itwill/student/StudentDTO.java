//[34day-6]StudentDAO보다 먼저 만드는것이 정석
//-https://choitaetae.tistory.com/97
package xyz.itwill.student;

//DTO(Data Transfer Object) 클래스: DAO 클래스의 메소드에 필요한 정보를 매개변수로 전달하거나 메소드의 
//실행결과를 저장하여 반환하기 위한 클래스 - VO(Value Object) 클래스
//VO클래스가 더 큰 개념이고 DTO,자바빈은 VO에서 더 세분화된 개념
//=>테이블의 컬럼과 1:1로 매핑되는 필드 선언 - Getter & Setter
//=>필드의 이름은 컬럼의 이름과 동일하게 작성하는 것을 권장


/* 자바빈(JavaBean)
 * JSP(JavaServer Pages)에서 객체를 가져오기 위한 기법으로 데이터 전달 오브젝트 파일(DTO)라고도 함
 * JSP 프로그래밍에는 DTO나 DAO 클래스의 객체를 JSP 페이지에서 사용하기 위해 사용
 * 
 * 사용목적
 * -JSP 페이지가 화면 표현 부분과 로직들이 같이 존재해 복잡해지는 구성을 가급적 피함
 * -JSP 페이지의 로직 부분을 분리하여 코드를 재사용함으로써 프로그램 효율 향상
 * 
 * 자바빈 설계 규약
 * 1.멤버변수마다 별도의 getter,setter 메서드 존재
 * 2.get메소드는 매개변수가 존재하지 않아야함
 * 3.set 메소드는 반드시 하나 이상의 매개변수 존재
 * 4.생성자는 매개변수가 존재하지 않아야함
 * 5.멤버변수의 접근제어자는 private이고 각 getter,setter 메소드의 접근제어자는 public, 클래스의 접근제어자는 public으로 정의
 */



/*
이름       널?       유형            
-------- -------- ------------- 
NO       NOT NULL NUMBER(4)     
NAME              VARCHAR2(50)  
PHONE             VARCHAR2(20)  
ADDRESS           VARCHAR2(100) 
BIRTHDAY          DATE    
 */

//STUDENT 테이블에 저장된 하나의 행(학생정보)을 저장하여 전달하기 위한 DTO 클래스
public class StudentDTO {
	private int no;
	private String name;
	private String phone;
	private String address;
	private String birthday;
	
	public StudentDTO() {
		
	}
	

	public StudentDTO(int no, String name, String phone, String address, String birthday) {
		super();
		this.no = no;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.birthday = birthday;
	}


	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	@Override
	public String toString() {
		return no+"\t"+name+"\t"+phone+"\t"+address+"\t"+birthday;
	}
	
}
