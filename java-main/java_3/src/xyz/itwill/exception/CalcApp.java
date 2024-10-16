package xyz.itwill.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

//키보드로 정수값 2개를 입력받아 첫번째 정수값으로 두번째 정수값을 나눈 몫을 계산하여 출력하는 프로그램 작성
public class CalcApp {
	
	public CalcApp() throws InputMismatchException, ArithmeticException{
		Scanner scanner = new Scanner(System.in);
		
		
		System.out.print("첫번째 정수값 입력 >> ");
		//Scanner.nextInt(): 입력값을 정수값으로 변환하여 반환하는 메소드
		//=>입력값이 정수값으로 변환되지 못할 경우 InputMismatchException 발생
		//=>직접 예외를 처리하지 않고 메소드를 이용하여 예외 전달
		int num1=scanner.nextInt();
		
		System.out.print("두번째 정수값 입력 >> ");
		int num2=scanner.nextInt();
		
		System.out.println("[결과]"+num1+"/"+num2+" = "+num1/num2);
		scanner.close();
	}
	
	public static void main(String[] args) {
		//new 연산자로 클래스의 생성자를 호출하여 객체 생성-생성자에 작성된 명령 실행
		//=>생성자를 호출하면 예외 전달되므로 예외처리
		try{
			new CalcApp();
			}catch(InputMismatchException e) {
				System.out.println("[에러]정수값만 입력 가능합니다.");
			}catch(ArithmeticException e) {
				System.out.println("[에러]0으로 나눌 수 없습니다.");
			}catch (Exception e) { //모든 예외를 전달받아 예외처리
				System.out.println("[에러]프로그램에 예기치 못한 오류가 발생되었습니다.");
			}
	}
}
