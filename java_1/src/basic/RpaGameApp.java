package basic;


import java.util.Scanner;

//import java.util.*;

public class RpaGameApp {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int comp = (int)(Math.random()*3)+1;
		int user;
		int cnt=0;  //사용자 승리 횟수를 저장하기 위한 변수
		//(int)(Math.random()+3)+1=>1이면 가위, 2면 바위, 3이면 보
		
		//가위바위보 대결-반복(사용자가 지는 순간 반복 종료)
		while(true) {
			
			while(true) {
				System.out.println("====가위바위보 게임=====");
				System.out.print("사용자[1:가위/2:바위/3:보]>> ");
				user=scanner.nextInt();
				if(user>=1 && user<=3) {
					break;
				}
				System.out.println("[error]1~3사이의 숫자를 입력하셔야 합니다.");
				}
			
			System.out.print("컴퓨터>>");
			switch(comp) {
			case 1: System.out.print("가위"); break;
			case 2: System.out.print("바위"); break;
			case 3: System.out.print("보"); break;
			}
			
			System.out.print(", 사용자>>");
			switch(user) {
			case 1: System.out.print("가위"); break;
			case 2: System.out.print("바위"); break;
			case 3: System.out.print("보"); break;
			}
			
			System.out.println();
			
			if(comp==user) {
				System.out.println("[결과]비겼습니다.");
			}
			else if(comp==1&&user==2 || comp==2&&user==3 || comp==3&&user==1) {
				System.out.println("[결과]사용자가 컴퓨터를 이겼습니다.");
				cnt++;
			}
			else {
				System.out.println("[결과]사용자가 컴퓨터에게 졌습니다.");
				break;
			}
		}
		System.out.println("===============================================================");

	      //승리횟수 출력
	      if(cnt==0) {
	         System.out.println("[메세지]사용자가 컴퓨터에게 한 번도 이기지 못했습니다.");
	      }else {
	         System.out.println("[메세지]사용자가 컴퓨터에게 "+cnt+"번 연속적으로 이겼습니다.");
	      }
	      scanner.close();

		
	}
}
