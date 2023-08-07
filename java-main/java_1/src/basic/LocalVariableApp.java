package basic;

public class LocalVariableApp {
	public static void main(String[] args) {
		int num1=100; //main()메소드 안에서만 사용할 수 있는 지역변수
		
		//임의블럭
		{
			int num2=200;
			System.out.println("==========임의블럭 내부==========");
			System.out.println("num1:"+num1+" num2:"+num2);
		}
		System.out.println("==========임의블럭 외부==========");
		System.out.println("num1:"+num1);
		//System.out.println("num2:"+num2); ->num2는 임의블럭 종료시 소멸되는 지역변수이기 때문에 출력불가
	}
}
