package basic;

public class BreakApp {
	public static void main(String[] args) {
		//break문
		for(int i=1;i<=5;i++) {
			if(i==3) {
				break;
			}
			System.out.print(i+"\t");
		}
		System.out.println();
		System.out.println("=========================================");
		
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=5;j++) {
				if(j==3) {
					break;
				}
				System.out.println("i= "+i+" j= "+j);
			}
		}
		System.out.println("=========================================");
		//반복문 작성시 반복문을 구분하기 위한 식별자(라벨명) 선언 가능
		loop:for(int i=1;i<=5;i++) {
			for(int j=1;j<=5;j++) {
				if(j==3) {
					break loop;
				}
				System.out.println("i= "+i+" j= "+j);
			}
		}
		System.out.println("=========================================");

	}
}
