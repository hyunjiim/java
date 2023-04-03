package basic;

public class MultiForApp {
	public static void main(String[] args) {
		int cnt=0; //이동방법의 개수를 저장하기 위한 변수
		
		for(int i=1;i<=3;i++) {
			for(int j=1;i<=4;i++) {
				cnt++;
			}
		}
		
		System.out.println("이동방법의 개수: "+cnt);
		
		System.out.println("=========================================");
		
		//구구단1
		for(int j=1;j<=9;j++) {
			System.out.println("==[ "+j+"단 ]==");
			for(int i=1;i<=9;i++) {
				System.out.println(j+" * "+i+" = "+ (j*i));
			}
		}
				
		System.out.println("=========================================");
		
		//구구단2
		for(int j=1;j<=9;j++) {
			for(int i=1;i<=9;i++) {
				System.out.print(i+" * "+j+" = "+ (j*i)+"\t");
				
			}
			System.out.println();
		}
		
		System.out.println("=========================================");
		
		//구구단3
		for(int i=1;i<=9;i++) {
			System.out.print("==[ "+i+"단 ]==\t");
		}
		System.out.println();
		for(int j=1;j<=9;j++) {
			for(int i=1;i<=9;i++) {
				System.out.print(i+" * "+j+" = "+ (j*i)+"\t");
						
			}
			System.out.println();
		}
				
		System.out.println("=========================================");
		
		
		//별출력
		for(int j=1;j<=9;j++) { //행(Row)을 처리하기 위한 반복문
			for(int i=1;i<=8;i++) {  //열(Column)을 처리하기 위한 반복문
				System.out.print("★");
			}
			System.out.println();
		}
		
		System.out.println("=========================================");
		
		for(int j=1;j<=9;j++) { //행(Row)을 처리하기 위한 반복문
			for(int i=1;i<=8;i++) {  //열(Column)을 처리하기 위한 반복문
				System.out.print(i+"*=\t");
			}
			System.out.println();
		}
		
		System.out.println("=========================================");
		
		//별출력2-1행 별1개, 2행 별2개.....
		for(int j=1;j<=9;j++) { //행(Row)을 처리하기 위한 반복문
			for(int i=1;i<=j;i++) {  //열(Column)을 처리하기 위한 반복문
				System.out.print("★");
			}
			System.out.println();
		}
		
		System.out.println("=========================================");
		
		for(int j=9;j>=1;j--) { //행(Row)을 처리하기 위한 반복문
			for(int i=j;i>=1;i--) {  //열(Column)을 처리하기 위한 반복문
				System.out.print("★");
			}
			System.out.println();
		}
		
		System.out.println("=========================================");
		
		for(int j=1;j<=5;j++) { //행(Row)을 처리하기 위한 반복문
			for(int i=1;i<=(5-j);i++) {  //열(Column)을 처리하기 위한 반복문
				System.out.print("☆");
			}
			for(int i=1;i<=j;i++) {  //열(Column)을 처리하기 위한 반복문
				System.out.print("★");
			}
			System.out.println();
		}

		System.out.println("=========================================");
		/*	(열)	1 2 3 4 5  (행)
					☆☆☆☆★  1
					☆☆☆★★  2
					☆☆★★★  3
					☆★★★★  4
					★★★★★  5
		행을 i, 열을 j라고 했을 때 i+j가 5보다 크면 검은별, 같거나 작으면 흰별
  	 	=>첫번째 행 검은별을 기준으로 봤을때 5(j)+1(i)=6이고, 흰별들은 각각 1+1/2+1/3+1/4+1<=5이다.*/
		for(int j=1;j<=5;j++) { //행(Row)을 처리하기 위한 반복문
			for(int i=1;i<=5;i++) {  //열(Column)을 처리하기 위한 반복문
				if(i+j<=5) {
					System.out.print("☆");
					}
				else {
					System.out.print("★");
				}
			}
			System.out.println();
		}
	}
}
