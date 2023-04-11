package inheritance;
 
//학생정보(학생번호, 학생이름, 수강과목)를 저장하기 위한 클래스
//학생번호, 학생이름 관련 속성과 행위는 AcademyPerson클래스를 상속받아 작성
public class AcademyStudent extends AcademyPerson {
	private String course;
	
	public AcademyStudent() {
		// TODO Auto-generated constructor stub
	}

	public AcademyStudent(int num, String name, String course) {
		super(num, name);  //부모클래스의 필드 호출
		this.course = course;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}
	
	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("학생번호: "+getNum());
		System.out.println("학생이름: "+getName());
		System.out.println("수강과목: "+course);
	}
	
	
	
}
