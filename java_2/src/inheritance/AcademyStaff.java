package inheritance;
 
//직원정보(직원번호,직원이름,근무부서)를 저장하기 위한 클래스
public class AcademyStaff extends AcademyPerson {
	private String depart;
	
	public AcademyStaff() {
		// TODO Auto-generated constructor stub
	}

	public AcademyStaff(int num, String name, String depart) {
		super(num, name);
		this.depart = depart;
	}

	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}
	
	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("직원번호: "+getNum());
		System.out.println("직원이름: "+getName());
		System.out.println("근무부서: "+depart);
	}
	
}
