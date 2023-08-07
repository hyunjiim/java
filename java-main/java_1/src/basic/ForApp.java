package basic;

public class ForApp {
	public static void main(String[] args) {
		//for문-"Java Programming" 5번 출력하는 프로그램
		for(int i=0;i<5;i++) {
			System.out.println("Java Programming");
		}
		
		System.out.println("======================================================");
		
		for(int i=5;i>=1;i--) {
			System.out.println("Java Programming");
		}
		
		System.out.println("======================================================");

		for(int i=1;i<=10;i+=2) {
			System.out.println("Java Programming");
		}
		
		System.out.println("======================================================");
        //"1	2	3	4	5"출력
		for(int i=1;i<=5;i++) {
			System.out.print(i+"\t");
		}
		System.out.println();
		System.out.println("======================================================");
		//"5	4	3	2	1"출력
		for(int i=5;i>=1;i--) {
			System.out.print(i+"\t");
		}
		System.out.println();
		System.out.println("======================================================");
		
		/*for(int i=1;i<=5;i++) {
			System.out.print(6-i+"\t");
		}
		System.out.println();
		System.out.println("======================================================");
		*/
		for(int i=1;i<=10;i++) {
			if(i%2==0) {
				System.out.print(i+"\t");
				}
		}
		System.out.println();
		System.out.println("======================================================");
		int sum=0;
		for(int i=1;i<=100;i++) {
			sum+=i;
		}
		System.out.println("1~100까지 정수들의 합계: "+sum);
		System.out.println("======================================================");
		int begin=80, end= 20;
		/*
		sum=0;
		
		if(begin>end) {
			System.out.println("[Error]시작값이 종료값보다 작아야 합니다.");
			System.exit(0);   //프로그램 강제 종료 메소드 호출
		}
		
		for(int i=begin;i<=80;i++) {
			sum+=i;
		}
		System.out.println(begin+"~"+end+" 범위의 정수들의 합계: "+sum);
		*/
		if(begin>end) {
			int temp=begin;
			begin=end;
			end=temp;
		}
		
		sum=0;
		for(int i=begin;i<=80;i++) {
			sum+=i;
		}
		System.out.println(begin+"~"+end+" 범위의 정수들의 합계: "+sum);
		
		System.out.println("======================================================");
		
		for(int i=1, j=5; i<=3;i++,j--) {
			System.out.println("i= "+i+" j= "+j);
		}
		
		System.out.println("======================================================");
		
		int i=1;
		
		for(;i<=4;i++) {  //초기식 생략, 세미콜론은 무조건 두개
			System.out.print(i+"\t");
		}
		
		//i가 반복문이 끝나도 사라지지 않으므로 i=5가 저장되어 있음
		
		for(;i>=1;i--) {  //초기식 생략, 세미콜론은 무조건 두개
			System.out.print(i+"\t");
		}
		System.out.println();
		
		
	}
}
