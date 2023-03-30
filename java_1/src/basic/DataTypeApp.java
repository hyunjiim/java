package basic;

public class DataTypeApp {
	public static void main(String[] args) {
		System.out.println("<<정수형(IntegerType)>>");
		System.out.println("정수값(10진수 100) = "+100); //10진수 정수형 리터럴 출력
		System.out.println("정수값(8진수 100) = "+0100); //8진수 정수형 리터럴 출력
		System.out.println("정수값(16진수 100) = "+0x100);  //16진수 정수형 리터럴 출력
		System.out.println("정수값(10진수 100) = "+100L); //10진수 정수형 리터럴(8Byte-LongType) 출력
		
		System.out.println("정수값 = "+2147483647);
		//System.out.println("정수값 = "+2147483648); ->Byte로 표현 불가능힌 정수값을 사용한 경우 에러 발생 해결책: LongTye 사용! 정수값L
		System.out.println("정수값 = "+2147483648L);
		
		//정수값을 표현하기 위한 자료형: byte(1Byte), short(2Byte), int(4Byte), long(8Byte)
		byte a1= 127; //1Byte: -128~127
		short a2= 32767; //2Byte: -32768~32767
		int a3= 2147483647; //4Byte: -2147483648~2147483647
		long a4= 2147483648L; //8Byte
		
		//int a5= 100L; ->에러발생: 값에 대한 손실이 일어날 수 있으므로 에러 발생
		
		long a5= 100;
		System.out.println("a5 = "+a5);
		
		System.out.println("========================================");
		
		//실수형(DoubleType) 리터럴: 소숫점이 있는 숫자값
		//Java에서 실수형 리터럴은 기본적으로 8Byte(Double)로 표현>> 부동 소수점 형식으로 숫자값 표현
		System.out.println("<<실수형(DoubleType)>>");
		System.out.println("실수값(4Byte) = "+12.3F); //실수값F >>4Byte 실수형 리터럴(FloatType))
		System.out.println("실수값(8Byte) = "+12.3); //실수값 >>8Byte 실수형 리터럴(DoubleType))
		//println()메소드는 실수값이 아주 작거나 큰 경우 지수 형태로 변환하여 출력
		System.out.println("실수값(8Byte) = "+0.00000000123); //실수값 >>8Byte 실수형 리터럴(DoubleType))
		System.out.println("실수값(8Byte) = "+1.23E+10);
		
		//실수값을 표현하기 위한 자료형: float(4Byte), double(8Byte)
		float b1=1.23456789F; //결과값: b1 = 1.2345679 -> 가수부를 표현하기 위한 크기(정밀도): 7자리
		double b2=1.23456789; //가수부를 표현하기 위한 크기(정밀도): 15자리
		
		System.out.println("b1 = "+ b1);
		System.out.println("b2 = "+ b2);
	}

}
