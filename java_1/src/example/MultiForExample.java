package example;

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
		


		System.out.println("===============================================================");
		//★
		//★★★
		//★★★★★
		//★★★★★★★
		//★★★★★★★★★
		
		for(int i=1;i<=5;i++) { //행(Row)을 처리하기 위한 반복문
			for(int j=1;j<=(2*i-1);j++) {  //열(Column)을 처리하기 위한 반복문
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
	}
}
