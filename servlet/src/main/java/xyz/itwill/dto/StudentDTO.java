package xyz.itwill.dto;

//DTO(Data Transfer Object) 클래스: 테이블의 행정보를 표현하여 전달하기 위한 클래스 - VO 클래스

/*
 이름       널?       유형            
-------- -------- ------------- 
NO       NOT NULL NUMBER(4)     
NAME              VARCHAR2(50)  
PHONE             VARCHAR2(20)  
ADDRESS           VARCHAR2(100) 
BIRTHDAY          DATE          
 */

//STUDENT 테이블의 학생정보(행)를 저장하여 전달하기 위한 클래스
public class StudentDTO {
	private int no;
	private String name;
	private String phone;
	private String address;
	private String birthday;
	
	public StudentDTO() {
		// TODO Auto-generated constructor stub
	}

	public StudentDTO(int no, String name, String phone, String address, String birthday) {
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
	
	
}
