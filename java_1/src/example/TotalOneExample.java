package example;

import java.util.Scanner;

public class TotalOneExample {
	//키보드로 정수값을 5번 입력받아 합계를 계산하여 출력하는 프로그램을 작성하세요.
	//ex) 1번째 정수값 입력 >> 10
//	    2번째 정수값 입력 >> 20
//	    3번째 정수값 입력 >> 30
//	    4번째 정수값 입력 >> 40
//	    5번째 정수값 입력 >> 50
//	    [결과]합계 = 150
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int tot=0;
		for(int cnt=1;cnt<=5;cnt++) {
			System.out.print(cnt+"번째 정수값 입력 >> ");
			int i=scanner.nextInt();
			tot+=i;
			}
		
		System.out.println("[결과]합계 = "+tot);
		
	}
}
