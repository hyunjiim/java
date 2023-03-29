package basic;

public class VariableApp {
	public static void main(String[] args) {
		int su;  //정수형 변수 선언
		su=100;
		System.out.print("초기값 = ");
		System.out.println(su);
		
		su=200;
		System.out.print("변경값 = ");
		System.out.println(su);
		
		System.out.println("======================================");
		
		int num=100;
		System.out.println("num = "+num);
		
		System.out.println("======================================");
		
		System.out.println("올해는"+2+0+2+3+"년 입니다.");
		System.out.println(2+0+2+3+"년은 토끼띠해 입니다.");  //결과: 7년은 토끼띠해 입니다.->잘못된 결과 발생(실행오류)
		System.out.println(""+2+0+2+3+"년은 토끼띠해 입니다.");  //비어있는 문자열 - NullString
		
		System.out.println("======================================");
		
		int num1=100, num2=200;
		System.out.println("연산결과 = "+num1+num2);  //결과: 연산결과 = 100200 -> 실행오류
		System.out.println("연산결과 = "+(num1+num2)); 
		System.out.println("연산결과 = "+num1*num2);
		System.out.println("연산결과 = "+(num1*num2));
		
		System.out.println("=====================================");
		int kor=88, eng=90;
		int tot=kor+eng;
		System.out.println("점수 합계 = "+tot);
		System.out.println("=====================================");
		
		//int count;
		//System.out.println("count = "+count); ->초기값이 없어 에러 발생
		
		//int count = 10.0;
		//System.out.println("count = "+count); ->자료형이 잘못되어 에러 발생
	}

}
