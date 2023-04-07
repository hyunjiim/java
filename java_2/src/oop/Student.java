package oop;

//학생정보(학번,이름,국어,영어,총점)를 저장하기 위한 클래스
public class Student {
	//인스턴스 필드(Instance Field) : 객체가 생성될 때 메모리(HeapArea)에 생성되는 필드
	private int studentNum;
	private String name;
	private int kor, eng, tot;
	
	//정적 필드(Static Field): 클래스를 읽어 메모리(MethodArea)에 저장될때 생성되는 필드
	//=> 객체가 생성되기 전에 메모리에 하나만 생성되는 필드
	//=> 생성자에 초기화 처리하지 않고 직접 초기값을 필드에 저장
	//=> 클래스로 생성된 모든 객체가 정적 필드 사용 가능- 공유값: 메모리 절약 및 필드값 변경 용이
	//=> 클래스 외부에서는 클래스를 사용하여 접근 가능
	private static int total; //기본값을 초기값으로 저장할 경우 초기값 저장 생략 가능

	// 생성자(Constructor) : 객체를 생성하면서 인스턴스 필드에 원하는 초기값을 저장하기 위해 작성
	public Student() {
	}

	public Student(int studentNum, String name, int kor, int eng) {
		super();
		this.studentNum = studentNum;
		this.name = name;
		this.kor = kor;
		this.eng = eng;

		// 메소드 호출-효율적인 유지보수
		calcTot();
	}
	
	//정적 메소드(Static Method)
    public static int getTotal() {
		return total;
	}

	public static void setTotal(int total) {
		Student.total = total;
	}

	//인스턴스 메소드(Instance Method): this 키워드가 제공되는 메소드
	// =>this 키워드를 이용하여 인스턴스 필드 및 메소드 접근 가능
	// =>클래스를 사용하여 정적 필드 및 메소드 접근 가능-클래스 생략 가능
	public int getStudentNum() {
		return studentNum;
	}

	public void setStudentNum(int studentNum) {
		this.studentNum = studentNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
		calcTot();
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
		calcTot();
	}

	public int getTot() {
		return tot;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}

	// 은닉화 선언된 메소드- 클래스 내부에서만 호출하여 사용하는 메소드
	// =>코드의 중복성 최소화하기 위한 기능을 제공하는 메소드
	private void  calcTot() { // 총점 계산 메소드
		tot = kor + eng;
	}
	
	public void display() {
		System.out.println("[" + name + "]님의 성적 >> ");
		System.out.println("국어 = " + kor + ", 영어 = " + eng + ", 총점 =" + tot);
	}

}
