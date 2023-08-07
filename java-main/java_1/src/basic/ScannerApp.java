package basic;

import java.util.Scanner;

public class ScannerApp {
	public static void main(String[] args) {
		//사용자로부터 키보드로 이름과 나이를 입력받아 화면에 출력하는 프로그램 작성
		Scanner scanner=new Scanner(System.in);
		System.out.print("이름을 입력하세요>>");
		String name=scanner.nextLine();
		System.out.print("나이를 입력하세요>>");
		int age=scanner.nextInt();
		
		System.out.println("[결과]사용자 "+name+"님의 나이는 "+age+"살 입니다.");
		scanner.close();
	}

}
