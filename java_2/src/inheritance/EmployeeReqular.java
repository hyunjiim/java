package inheritance;

//정규직 사원번호(사원번호,사원이름,연봉)를 저장하기 위한 클래스
//=>Employee 클래스를 상속받아 작성
public class EmployeeReqular extends Employee {
	private int anuualSalary;
	
	public EmployeeReqular() {
		// TODO Auto-generated constructor stub
	}
 
	public EmployeeReqular(int empNo, String empName, int anuualSalary) {
		super(empNo, empName);
		this.anuualSalary = anuualSalary;
	}

	public int getAnuualSalary() {
		return anuualSalary;
	}

	public void setAnuualSalary(int anuualSalary) {
		this.anuualSalary = anuualSalary;
	}
	/*
	//급여를 반환하는 메소드
	public int computeSalary() {
		return anuualSalary/12;
	}
	*/
	
	@Override
	public int computePay() {
		// TODO Auto-generated method stub
		return anuualSalary/12;
	}
}
