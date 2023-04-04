package basic;

import java.util.Scanner;

public class ArrayApp {
	public static void main(String[] args) {
		//1차원 배열을 생성하여 참조변수에 생성된 배열의 메모리 주소를 저장
		int[] num=new int[3];   //0|1|2 
		
		System.out.println("num= "+num); //[결과]:num= [I@6a5fc7f7
		System.out.println("=========================================================");
		
		System.out.println("num[0]= "+num[0]);
		System.out.println("num[1]= "+num[1]);
		System.out.println("num[2]= "+num[2]);
		System.out.println("=========================================================");
		System.out.println("num.length= "+num.length);
		System.out.println("=========================================================");
		int index=0;
		//배열 요소를 구분하는 첨자는 변수 또는 연산식 사용 가능
		num[index]=10;
		num[index+1]=20;
		num[index+2]=30;
		System.out.println("=========================================================");
		for(int i=0;i<num.length;i++) {
			System.out.println("num["+i+"]= "+num[i]);
		}
		
		System.out.println("=========================================================");
		//배열 생성시 배열 요소의 기본값 대신 원하는 초기값 저장 가능
		int[] su1= new int[] {10,20,30};
		
		for(int i=0;i<su1.length;i++) {
			System.out.println("su1["+i+"]= "+su1[i]);
		}
		System.out.println("=========================================================");
		//블럭 내부에 값을 나열하여 배열 생성 가능
		//형식)자료형[] 참조변수={초기값, 초기값,....}
		int[] su2= {10,20,30};   //단축형
		for(int i=0;i<su2.length;i++) {
			System.out.println("su2["+i+"]= "+su2[i]);
		}
		System.out.println("=========================================================");
		//Java에서는 배열을 일괄처리하기 위해 향상된 for 구문 제공
		//형식)for(자료형 변수형:참조변수){명령; ....}
		//=>참조변수에 저장된 배열의 요소값을 커서(cursor)를 사용하여 차례대로 하나씩 제공받아 변수에 저장하여 일괄처리하는 반복문
		//=>배열에서 얻어올 요소값이 없는 경우 반복문 종료
		int[] su= {10,20,30}; 
		for(int temp:su) {
			System.out.print(temp+"\t");
		}
		System.out.println();
		System.out.println("=========================================================");
		//5개 정수를 입력받은 후 차례로 출력하는 프로그램
		Scanner scanner=new Scanner(System.in);
		
		System.out.print("입력>> ");
		int[] num1=new int[5];
		 for(int i=0;i<5;i++) {
			 num1[i]=scanner.nextInt();
			 System.out.print(num1[i]+" ");
		 }
		 System.out.println("=========================================================");
		 int[] array= {54,70,64,33,11,51,82,66,41,90,99};
		 int tot=0;
		 for(int i=0;i<array.length;i++) {
			 tot+=array[i];
		 }
		 System.out.println("합계: "+tot);
		 System.out.println("=========================================================");
		 //배열 요소값이 30~60 범위의 정수값이 저장된 요소의 갯수를 계산하여 출력하는 프로그램
		 int count=0;
		 for(int element:array) {
			 if(element>=30&&element<=60) {
				 count++;
			 }
		 }
		 System.out.println("30~60 범위의 요소의 갯수 = "+count);
		 System.out.println("=========================================================");
		 
		 scanner.close();
	}
}
