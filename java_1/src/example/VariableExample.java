package example;

public class VariableExample {
	public static void main(String[] args) {
		//가로의 길이가 7이고 세로의 길이가 10인 사각형의 넓이를 계산하여 출력하세요.
		int garo=7;
		int sero=10;
		int area= garo*sero;
		System.out.println("사각형의 넓이= "+area);
		
		System.out.println("======================================================");
		
		//높이가 9이고 밑변의 길이가 7인 삼각형의 넓이를 계산하여 출력하세요.
		int h = 9;
		int b = 7;
		double sarea = (double)(b*h)/2;
		System.out.println("삼각형의 넓이= "+sarea);
		
		System.out.println("======================================================");
		
		//10명의 전체 몸무게가 759Kg인 경우 평균 몸무게를 계산하여 출력하세요.
		int cnt=10;
		int sumw = 759;
		double avgw = (double)sumw/cnt;
		System.out.println("평균 몸무게= "+avgw+"kg");
		
		System.out.println("======================================================");
		
		//이름이 [홍길동]인 학생이 국어점수 89점, 영어점수 93점, 수학점수 95점을 받은 경우
		//총점과 평균을 계산하여 이름, 총점, 평균을 출력하세요.
		//단, 평균은 소숫점 한자리까지만 출력하고 나머지는 절삭 처리 하세요.
		String name = "홍길동";
		int kor=89, eng=93, math= 95;
		int sumpoint = kor+eng+math;
		double avgpoint = (double)sumpoint/3;
		System.out.println("\'"+name+"\'의 총점:"+sumpoint+", 평균(반올림): "+(int)(avgpoint*10+0.5)/10.0); 
		
		System.out.println("======================================================");
	}

}
