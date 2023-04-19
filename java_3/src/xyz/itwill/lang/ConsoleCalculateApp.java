package xyz.itwill.lang;

import java.util.Scanner;

//키보드로 사칙 연삭식을 입력받아 연산결과를 계산하여 출력하는 프로그램 작성
//ex) 연산식 입력 >> 20+10
//    [결과]30
//=> 입력 연산식에서 사용 가능한 연산자는 사칙 연산자(*,/,+,-)
//=> 형식에 맞지 않는 연산식이 입력된 경우 에러 메세지 출력 후 프로그램 작성
//=> 입력 연산식에 공백 입력이 가능하도록 처리

public class ConsoleCalculateApp {
	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.print("연산식 입력 >> ");
			String calc = scanner.nextLine();
			if (calc.indexOf("+") == -1 && calc.indexOf("-") == -1 && calc.indexOf("*") == -1
					&& calc.indexOf("/") == -1) {
				System.out.println("[에러]형식에 맞지 않는 연산식이 입력되었으므로 프로그램을 강제 종료합니다.");
				System.exit(0);
			}

			calc = calc.replace(" ", "");
			String[] calcArray = {};
			if (calc.contains("+")) {
				calcArray = calc.split("\\+");
				System.out.println("[결과]" + (Integer.parseInt(calcArray[0]) + Integer.parseInt(calcArray[1])));
			} else if (calc.contains("-")) {
				calcArray = calc.split("\\-");
				System.out.println("[결과]" + (Integer.parseInt(calcArray[0]) - Integer.parseInt(calcArray[1])));
			} else if (calc.contains("*")) {
				calcArray = calc.split("\\*");
				System.out.println("[결과]" + (Integer.parseInt(calcArray[0]) * Integer.parseInt(calcArray[1])));
			} else if (calc.contains("/")) {
				calcArray = calc.split("\\/");
				System.out.println("[결과]" + (Integer.parseInt(calcArray[0]) / Integer.parseInt(calcArray[1])));
			}

			scanner.close();
		} catch (ArithmeticException e) {
			System.out.println("[에러]연산식에 올바르지 않은 수식이 입력되었습니다.");
		}
	}
}
