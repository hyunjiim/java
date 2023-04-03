package basic;

import java.util.Scanner;

public class InputCheckApp {
	//키보드로 점수를 입력받아 학점을 계산하여 출력하는 프로그램 작성
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		/*
		int jumsu=-1;  //while문을 실행하기 위해서 초기값을 정상적이지 않은 값 대입 
		
		while(jumsu<0 || jumsu>100) {
			System.out.println("점수[0~100]를 입력하시오>>");
			jumsu=scanner.nextInt();
			}
		================================================================================
		int jumsu; 
		
		do {
			System.out.print("점수[0~100]를 입력하시오>>");
			jumsu=scanner.nextInt();
			}while(jumsu<0 || jumsu>100);
		*/
		int jumsu;  //while문을 실행하기 위해서 초기값을 정상적이지 않은 값 대입 
		
		while(true) {
			System.out.println("점수[0~100]를 입력하시오>>");
			jumsu=scanner.nextInt();
			//입력값이 정상적인 값인 반복문 종료
			if(jumsu>=0 && jumsu<=100) {
				break;
				}
			  System.out.print("0~100사이의 정상적인 점수값을 입력하세요.");
			}
		
		
		String grade="";
		switch(jumsu/10) {
		case 10:
		case 9: grade="A"; break;
		case 8: grade="B"; break;
		case 7: grade="C"; break;
		case 6: grade="D"; break;
		case 5: grade="E"; break;
		default: grade="F"; break;
		}
		
		System.out.println("[결과]학점: "+grade);
		
		scanner.close();
	}

}
