package basic;

//자료형 변환
public class TypeCastApp { 
	public static void main(String[] args) {
		//자동 형변환(JVM)
		System.out.println("결과= "+(3+1.5)); 
		
		double su=10;
		System.out.println("su= "+su);
		
		System.out.println("결과= "+(95/10));   //int/int >>int
		System.out.println("결과= "+(95.0/10.0)); //double/double >>double
		System.out.println("결과= "+(95.0/10));  //double/int >> double/double(자동 형변환) >> double
		System.out.println("결과= "+(95/10.0));  //int/double >> double(자동 형변환)/double >> double
		
		int kor=95, eng=90;
		int tot=kor+eng;
		//double avg = tot/2; ->결과: 92.0(실행오류) tot(정수)/2(정수)이므로 정수값으로 나온 결과(92)가 실수값(92.0)으로 변환됨
		double avg = tot/2.0;
		System.out.println("총점= "+tot+"평균= "+avg);
		
		//int 자료형보다 작은 자료형의 값은 무조건 int 자료형으로 형변환되어 연산 처리
		byte su1= 10, su2=20;
		int su3= su1+su2;  //byte su3=su1+su2하면 오류
		System.out.println("su3= "+su3);
		
		//강제 형변환(프로그래머)
		int num = (int)12.3; //(int)12.3 >> 12
		System.out.println("num= "+num);
		
		int num1=95, num2=10;
		//double num3= num1/num2; ->결과: 9.0(실행오류) 정수/정수이므로 정수값으로 나온 결과(9)가 실수값(9.0)으로 변환됨
		double num3= (double)num1/num2; 
		System.out.println("num3= "+num3);
		
		int num4=100000000, num5= 30;
		//int num6=num4*num5;  30억은 int형으로 표현 가능한 범위를 벗어나므로, 쓰레기값이 변수에 저장됨
		long num6=(long)num4*num5;  //8Byte의 연산 결과값을 저장하기 위해 변수를 long 자료형으로 선언
		System.out.println("num6= "+num6);
		
		double number=1.23456789;
		System.out.println("number= "+number);
		
		//소수점 2자리 위치까지만 출력되도록
		System.out.println("number(내림)= "+(int)(number*100)/100.0);
		System.out.println("number(반올림)= "+(int)(number*100+0.5)/100.0);
		System.out.println("number(올림)= "+(int)(number*100+0.9)/100.0);
	}

}
