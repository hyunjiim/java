package xyz.itwill.lang;


public class WrapperApp {
	public static void main(String[] args) {
		/*
		//Integer 클래스: 정수값(int)을 저장하기 위한 클래스
		//Integer.valueOf(Object i):매개변수로 값을 전달받아 정수값이 저장된 Integer 객체를 반환하는 메소드
		Integer num1=Integer.valueOf(100);
		Integer num2=Integer.valueOf("200");//문자열로 전달받아도 내부적으로 정수값으로 저장
		//Integer.intValue(): Integer 객체에 저장된 정수값을 반환하는 메소드
		Integer num3=Integer.valueOf(num1.intValue()+num2.intValue());
		*/
		
		//Wrapper 클래스는 오토박싱과 오토 언박싱 기능을 제공받아 객체를 생성하거나 사용 가능
		//오토박싱(AutoBoxing): 원시형 리터럴(값)을 JVM이 자동으로 Wrapper 클래스의 객체로 생성하여 반환하는 기능
		//오토언박싱(AutounBoxing): JVM이 자동으로 Wrapper 클래스의 객체에 저장된 값을 원시형 리터럴로 반환하는 기능
		Integer num1=100,num2=200;
		Integer num3=num1+num2;
		System.out.println("num3= "+num3);
		
		
		//Integer num=Integer.valueOf("ABC");//NumberFormatException 발생
		//Integer.valueOf(String s, int radix): 매개변수로 전달받은 문자열을 원하는 진수의 정수값이 저장된 Integer 객체로 반환하는 메소드
		//=>매개변수로 진수가 전달되지 않을 경우 문자열을 10진수로 인식하여 처리
		//=> 정수값으로 변환되지 못하는 문자열이 전달된 경우 NumberFormatException 발생
		Integer num=Integer.valueOf("ABC",16); //int num=0xABC;
		//Integer 객체에 저장된 정수값을 반환받아 10진수로 출력
		System.out.println("num= "+num);
		System.out.println("=======================================================");
		Integer su=50;
		
		System.out.println("su(10진수) = "+su);
		//Integer.toOctalString(int i): 매개변수로 전달된 정수값을 8진수 형태의 문자열로 변환하여 반환하는 메소드
		System.out.println("su(8진수) = "+Integer.toOctalString(su));
		//Integer.toHexString(int i): 매개변수로 전달된 정수값을 16진수 형태의 문자열로 변환하여 반환하는 메소드
		System.out.println("su(16진수) = "+Integer.toHexString(su));
		//Integer.toBinaryString(int i): 매개변수로 전달된 정수값을 2진수 형태의 문자열로 변환하여 반환하는 메소드
		System.out.println("su(2진수) = "+Integer.toBinaryString(su));
		
		su=-50;
		System.out.println("su(2진수) = "+Integer.toBinaryString(su));
		System.out.println("=======================================================");
		String str1="100", str2="200";
		System.out.println("합계 = "+(str1+str2)); //문자열 결합
		
		//Integer.parseInt(String s): 매개변수로 문자열을 전달받아 정수값으로 변환하여 반환하는 메소드
		//=>정수값으로 변환되지 못하는 문자열이 전달된 경우 NumberFormatException 발생 =>예외처리 권장
		System.out.println("합계 = "+(Integer.parseInt(str1)+Integer.parseInt(str2)));
		System.out.println("=======================================================");
	}
}
