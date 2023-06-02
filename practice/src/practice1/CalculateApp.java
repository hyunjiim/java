package practice1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//키보드로 사칙 연삭식을 입력받아 연산결과를 계산하여 출력하는 프로그램 작성
//ex) 연산식 입력 >> 20+10
//  [결과]30
//=> 입력 연산식에서 사용 가능한 연산자는 사칙 연산자(*,/,+,-)
//=> 형식에 맞지 않는 연산식이 입력된 경우 에러 메세지 출력 후 프로그램 작성
//=> 입력 연산식에 공백 입력이 가능하도록 처리
public class CalculateApp {
	public static void main(String[] args) {
		while (true) {
			BufferedReader in;
			String operation;
			try {
				String[] operators = { "*", "/", "+", "-" };
				int index = 0;

				while (true) {
					in = new BufferedReader(new InputStreamReader(System.in));
					System.out.print("연산식 입력[입력종료: E] >> ");
					operation = in.readLine().replace(" ", "");
					if(operation.equals("E")) {
						System.exit(0);
					}

					for (String operator : operators) {
						index = operation.lastIndexOf(operator);
						if (index != -1)
							break;
					}

					if (index <= 0 || index >= operation.length()) {
						System.out.println("[입력오류]형식에 맞는 연산식을 입력해주세요.");
					} else {
						break;
					}
				}

				int num1 = Integer.parseInt(operation.substring(0, index));
				String operator = operation.substring(index, index + 1);
				int num2 = Integer.parseInt(operation.substring(index + 1, operation.length()));

				int result = 0;
				switch (operator) {
				case "*":
					result = num1 * num2;
					break;
				case "/":
					result = num1 / num2;
					break;
				case "+":
					result = num1 + num2;
					break;
				case "-":
					result = num1 - num2;
					break;
				}

				System.out.println("[결과]" + result);
			} catch (IOException e) {
				System.out.println("[에러]프로그램에서 예기치 못한 오류가 발생하였습니다." + e.getMessage());
			}
		}
	}
}