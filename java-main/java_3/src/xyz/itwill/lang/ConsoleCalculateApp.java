package xyz.itwill.lang;

import java.util.Scanner;

//키보드로 사칙 연삭식을 입력받아 연산결과를 계산하여 출력하는 프로그램 작성
//ex) 연산식 입력 >> 20+10
//    [결과]30
//=> 입력 연산식에서 사용 가능한 연산자는 사칙 연산자(*,/,+,-)
//=> 형식에 맞지 않는 연산식이 입력된 경우 에러 메세지 출력 후 프로그램 작성
//=> 입력 연산식에 공백 입력이 가능하도록 처리

//내 코딩의 문제점
//=> 사칙연산에 사용되는 피연산자가 음수일 경우((ex) -20 -50) 음수 피연산자의 -도 split()메소드에의해 연산자로 인식하여 실행오류 발생

public class ConsoleCalculateApp {
	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.print("연산식 입력 >> ");
			String calc = scanner.nextLine().replace(" ", "");
			if (calc.indexOf("+") == -1 && calc.indexOf("-") == -1 && calc.indexOf("*") == -1
					&& calc.indexOf("/") == -1) {
				System.out.println("[에러]형식에 맞지 않는 연산식이 입력되었으므로 프로그램을 강제 종료합니다.");
				System.exit(0);
			}

			String[] calcArray = {};
			/*
			 * if (calc.contains("+")) { calcArray = calc.split("\\+");
			 * System.out.println("[결과]" + (Integer.parseInt(calcArray[0]) +
			 * Integer.parseInt(calcArray[1]))); } else if (calc.contains("-")) { calcArray
			 * = calc.split("\\-"); System.out.println("[결과]" +
			 * (Integer.parseInt(calcArray[0]) - Integer.parseInt(calcArray[1]))); } else if
			 * (calc.contains("*")) { calcArray = calc.split("\\*");
			 * System.out.println("[결과]" + (Integer.parseInt(calcArray[0]) *
			 * Integer.parseInt(calcArray[1]))); } else if (calc.contains("/")) { calcArray
			 * = calc.split("\\/"); System.out.println("[결과]" +
			 * (Integer.parseInt(calcArray[0]) / Integer.parseInt(calcArray[1]))); }
			 */

			if (calc.indexOf("+") != -1) {
				calcArray = calc.split("\\+");
				System.out.println("[결과]" + (Integer.parseInt(calcArray[0]) + Integer.parseInt(calcArray[1])));
			} else if (calc.indexOf("-") != -1) {
				calcArray = calc.split("\\-");
				System.out.println("[결과]" + (Integer.parseInt(calcArray[0]) - Integer.parseInt(calcArray[1])));
			} else if (calc.indexOf("*") != -1) {
				calcArray = calc.split("\\*");
				System.out.println("[결과]" + (Integer.parseInt(calcArray[0]) * Integer.parseInt(calcArray[1])));
			} else if (calc.indexOf("/") != -1) {
				calcArray = calc.split("\\/");
				System.out.println("[결과]" + (Integer.parseInt(calcArray[0]) / Integer.parseInt(calcArray[1])));
			}

			scanner.close();
		} catch (ArithmeticException e) {
			System.out.println("[에러]0으로 나눌 수 없습니다.");
		} catch (NumberFormatException e) {
			System.out.println("[에러]연산식에 숫자가 아닌 값이 입력되었습니다.");
		} catch (Exception e) {
			System.out.println("[에러]프로그램에 예기치 못한 오류가 발생하였습니다. 프로그램을 강제 종료합니다.");
		}
	}
}
