package example;

import java.util.Scanner;

public class MultiForExample {
	public static void main(String[] args) {
		//★★★★★
		//★★★★
		//★★★
		//★★
		//★
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=(6-i);j++) {
				System.out.print("★");
			}
			System.out.println();
		}

		System.out.println("===============================================================");
		//★★★★★ 
		//☆★★★★
		//☆☆★★★
		//☆☆☆★★
		//☆☆☆☆★
		//if문 사용
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=5;j++) {
				if(j-i<0) {
					System.out.print("☆");
				}
				else {
					System.out.print("★");
				}
			}
			System.out.println();
		}	
		//for문 사용
		for(int i=1;i<=5;i++) {
			int j;
			for(j=1;j-i<0;j++) {
				System.out.print("☆");
			}
			for(;j<=5;j++) {
				System.out.print("★");
			}
			System.out.println();
		}
		System.out.println("===============================================================");
		//★
		//★★★
		//★★★★★
		//★★★★★★★
		//★★★★★★★★★
		
		for(int i=1;i<=5;i++) { //행(Row)을 처리하기 위한 반복문
			for(int j=1;j<=(2*i)-1;j++) {  //열(Column)을 처리하기 위한 반복문
				System.out.print("★");
			}
			System.out.println();
		}

		System.out.println("===============================================================");
		//★☆☆☆★
		//☆★☆★☆
		//☆☆★☆☆
		//☆★☆★☆
		//★☆☆☆★
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=5;j++) {
				if(i+j==6 || i-j==0) {
					System.out.print("★");
				}
				else {
					System.out.print("☆");
				}
			}
			System.out.println();
		}
		
		System.out.println("===============================================================");
		//1 1 1 1 1
        //2 2 2 2 2
        //3 3 3 3 3
        //4 4 4 4 4
        //5 5 5 5 5 
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=5;j++) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
		
		System.out.println("===============================================================");
		//1 2 3 4 5
        //1 2 3 4 5
        //1 2 3 4 5
        //1 2 3 4 5
        //1 2 3 4 5
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=5;j++) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
		
		System.out.println("===============================================================");
		//2 3 4 5 6
        //3 4 5 6 7
        //4 5 6 7 8
        //5 6 7 8 9
        //6 7 8 9 10
		for(int i=1;i<=5;i++) {
			for(int j=(i+1);j<=(5+i);j++) {
				System.out.print(j+" ");
			}
			System.out.println();
		}

		System.out.println("===============================================================");
		//a 1 2 3 4
        //b c 5 6 7
        //d e f 8 9
        //g h i j 10
		int num=1;
		char mun='a';
		for(int i=1;i<=4;i++) {
			for(int j=1;j<=5;j++) {
				if(i-j<0) {
					System.out.print(num+" ");
					num++;
				}
				else {
					System.out.print(mun+" ");
					mun++;
				}
			}
			System.out.println();
		}
		
		System.out.println("===============================================================");
		//a 1 2 3 4
        //b c 5 6 7
        //d e f 8 9
        //g h i j 10
		//for문 만으로 작성해보기
		num=1;
		mun='a';
		int j=0;
		for(int i=1;i<=4;i++) {
			for(j=1;(i-j)>=0;j++) {
				System.out.print(mun+" ");
				mun++;
			}
			for(;j<=5;j++) {
				System.out.print(num+" ");
				num++;
			}
			System.out.println();
		}
		
		System.out.println("===============================================================");
		//행과 열의 소를 입력받아 출력하는 프로그램
		//입력: 3 4
		//출력: 1 2 3 4
		//      2 4 6 8
		//      3 6 9 12
		Scanner scanner=new Scanner(System.in);
		System.out.print("행과 열을 순서대로 입력하세요>> ");
		int x=scanner.nextInt();
		int y=scanner.nextInt();
		
		for(int i=1;i<=x;i++) {
			for(int f=1;f<=y;f++) {
				System.out.print((f*i)+" ");
			}
			System.out.println();
		}
		
		System.out.println("===============================================================");
	}
}
