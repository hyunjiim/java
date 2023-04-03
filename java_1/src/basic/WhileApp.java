package basic;

public class WhileApp {
	public static void main(String[] args) {
		//while문-"Java Programming" 5번 출력하는 프로그램
		int i=1;
		while(i<=5) {
			System.out.println("Java Programming");
			i++;
		}
		System.out.println("=========================================");
		//do-while문-"Java Programming" 5번 출력하는 프로그램
		i=1;
		//do-while문-"Java Programming" 5번 출력하는 프로그램
		do {
			System.out.println("Java Programming");
			i++;
		}while(i<=5);
		
		System.out.println("=========================================");
		//do-while문
		//1~100범위의 정수들의 합계를 계산하여 출력하는 프로그램
		int j=1, tot=0;
		do {
			tot+=j;
			j++;
			i++;
		}while(j<=100);
		System.out.println("1~100 범위의 정수들의 합계= "+tot);
		
		System.out.println("=========================================");
		//A4 용지를 반으로 계속 접어 펼쳤을 경우 사각형 모양의 갯수가 500개 
		//이상이 만들어 지려면 몇 번 접어야 되는지 계산하여 출력하는 프로그램 작성
		int cnt =0;
		int sq=1;
		while(sq<500) {
			sq*=2;
			cnt++;
		}
		System.out.println("[결과]접는 횟수: "+cnt+" 만들어진 사각형 갯수:"+sq);
		
		System.out.println("=========================================");
		//1~x 범위의 정수들의 합계가 300이상이 만들어지려면 x가 얼마인지 
		//계산하여 출력하는 프로그램
		int x=0; //1씩 증가되는 정수값
		int sum=0; //누적 결과
		while(sum<300) {
			x++;
			sum+=x;
		}
		System.out.println("[결과]범위: 1~"+x+" 정수들의 합계: "+sum);
		
		System.out.println("=========================================");

	}

}
