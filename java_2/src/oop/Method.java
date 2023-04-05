package oop;

//객체 생성(참조)이 목적인 클래스- main 메소드 미작성
public class Method {
	void displayOne() {
		System.out.println("Method 클래스의 displayOne() 메소드 호출");
		return;
	}
	
	void displayTwo() {
		System.out.println("Method 클래스의 displayTwo() 메소드 호출");
		return;
	}
	
	void printOne() {
		int tot=0;
		for(int i=1;i<=100;i++) {
			tot+=i;
		}
		System.out.println("1~100 범위의 정수들의 합계: "+tot);
	}
	
	void printTwo(int num) {
		if(num<0) {
			System.out.println("[에러]매개변수에는 0보다 큰 값이 저장되어야 합니다");
			return; //메소드 종료
		}
		int tot=0;
		for(int i=1;i<=num;i++) {
			tot+=i;
		}
		System.out.println("1~"+num+"범위의 정수들의 합계: "+tot);
	}
	
	void printThree(int num1, int num2) {
		if(num1<0||num2<0) {
			System.out.println("[에러]매개변수에는 0보다 큰 값이 저장되어야 합니다.");
			return; 
		}
		if(num2<num1) {
			int temp;
			temp=num1;
			num1=num2;
			num2=temp;
		}
		
		int tot=0;
		for(int i=num1;i<=num2;i++) {
			tot+=i;
		}
		System.out.println(num1+"~"+num2+"범위의 정수들의 합계: "+tot);
	}
	
	int returnTot(int num1, int num2) {
		if(num1<0||num2<0) {
			System.out.println("[에러]매개변수에는 0보다 큰 값이 저장되어야 합니다.");
			return 0;
		}
		
		if(num2<num1) {
			int temp;
			temp=num1;
			num1=num2;
			num2=temp;
		}
		
		int tot=0;
		for(int i=num1;i<=num2;i++) {
			tot+=i;
		}
		return tot;
	}
	
	//매개변수로 정수값을 전달받아 홀수와 짝수를 구분하여 반환하는 메소드
	boolean isOddEven(int num) {
		if(num %2 ==0) {
			return true;
		}else {
			return false;
		}
	}
	
	//배열을 반환하는 메소드
	int[] returnArray(){
		/*int[] array= {10,20,30,40,50};
		return array; //배열의 메모리 주소 반환*/
		return new int[] {10,20,30,40,50};
	}
	
	//매개변수 3개에 전달된 정수들의 합계를 계산하여 반환하는 메소드
	int sumOne(int num1, int num2, int num3) {
		return num1+num2+num3;
	}
	
	//매개변수로 배열을 전달받아 배열의 모든 요소값들의 합계를 계산하여 반환하는 메소드
	int sumTwo(int[] array) {
		int tot=0;
		for(int num:array) {
			tot+=num;
		}
		return tot;
	}
}
