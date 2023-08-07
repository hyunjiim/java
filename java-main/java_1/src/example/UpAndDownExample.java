package example;

import java.util.Scanner;

//컴퓨터로부터 제공받은 정수 난수값을 키보드로 입력하여 맞추는 프로그램을 작성하세요.
//=> 1~100 범위의 정수 난수값을 제공받도록 작성
//=> 난수값을 맞출 수 있는 기회는 10번만 제공되도록 작성
//=> 키보드 입력값이 1~100 범위가 아닌 경우 메세지 출력 후 재입력
//=> 난수값과 입력값이 같은 경우 입력 횟수 출력 후 프로그램 종료
//=> 난수값과 입력값이 다른 경우 "큰값 입력" 또는 "작은값 입력" 형식의 메세지 출력
//=> 난수값을 10번 안에 맞추지 못한 경우 난수값이 출력되도록 작성
public class UpAndDownExample {
	public static void main(String[] args) {
		int rand = (int)(Math.random()*100)+1;
		Scanner scanner=new Scanner(System.in);
		
		int cnt=1;
		int user;
		while(true) { //입력 기회 10번 반복
			while(true) { //난수값이 같은 경우/범위를 벗어난 경우/큰값 입력/작은값 입력
				System.out.print(cnt+"번째 입력[기회:10번]>>");
				user=scanner.nextInt();
				if(user>=0&&user<=100) {
					break;
				}
				System.out.println("[error]1~100 범위 안의 정상적인 값을 입력하셔야 합니다.");
			}
			if(user==rand) {
				System.out.println("[결과]정답입니다."+cnt+"번만에 정답!");
				break;
			}else if(user<=rand) {
				System.out.println("[결과]큰값 입력"); 
			}else {
				System.out.println("[결과]작은값 입력");
			}
			cnt++;
			if(cnt>10) {
				System.out.println("[결과]실패! 난수값: "+rand);
				break;
			}
			
		}
		scanner.close();
	}

}
