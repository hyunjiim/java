package inheritance;

//static 제한자: 클래스(내부클래스), 메소드, 필드에 사용하는 제한자
//=>객체가 아닌 클래스로 접근하여 사용하기 위한 제한자

//사원정보(사원번호,사원이름)를 저장하기 위한 클래스
//=>모든 사원 관련 클래스가 상속받아야 되는 부모클래스
//=>객체 생성이 목적이 아닌 상속을 목적으로 작성된 클래스-추상클래스로 선언하는 것을 권장
//추상클래스(Abstract Class): abstract 제한자를 사용하여 선언된 클래스
//=>객체 생성 불가능-상속 전용 클래스
//형식) public abstract class 클래스명{}
//=>abstract 제한자: 클래스와 메소드에 사용하는 제한자
public abstract class Employee {
	private int empNo;
	private String empName;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int empNo, String empName) {
		super();
		this.empNo = empNo;
		this.empName = empName;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	//급여를 계산하여 반환하는 메소드
	public int computePay() {
		return 0;
	}
	
}
