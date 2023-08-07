package oop;

//Car 클래스를 객체로 생성하여 작성된 프로그램
public class CarApp {
	public static void main(String[] args) {
		//Car 클래스를 객체를 생성하여 참조변수에 저장
		Car carOne= new Car();  
		Car carTwo= new Car(); 
		Car carThree= new Car(); 
		
		System.out.println("carOne= "+carOne); //carOne= oop.Car@3b6eb2ec
		System.out.println("carTwo= "+carTwo); //carTwo= oop.Car@1e643faf
		System.out.println("carThree= "+carThree); //carThree= oop.Car@6e8dacdf
		//=>다 다른 객체임을 메모리 주소로 알 수 있음
		
		System.out.println("=======================================================");
		//참조변수.필드명: 참조변수에 저장된 객체를 .연산자를 사용하여 필드에 접근
		//첫번째 자동차
		//객체의 필드에는 기본값이 초기값으로 자동 저장
		//문제점)객체를 사용하여 필드에 직접적인 접근을 허용하면 필드에 비정상적인 값 저장 가능
		//해결법)클래스 선언시 필드를 은닉화 처리하여 선언- 은닉화 선언된 필드에 접근할 경우 에러 발생
		//carOne.modelName="싼타페"; //객체의 필드값 변경
		carOne.setModelName("싼타페");
		
		System.out.println("첫번째 자동차 모델명: "+carOne.getModelName());
		System.out.println("첫번째 자동차 엔진상태: "+carOne.isEngineStatus());
		System.out.println("첫번째 자동차 현재속도: "+carOne.getCurrentSpeed());
		System.out.println("=======================================================");
		//두번째 자동차
		carTwo.setModelName("쏘나타");
		carTwo.setEngineStatus(true);
		carTwo.setCurrentSpeed(80);
		
		System.out.println("두번째 자동차 모델명: "+carTwo.getModelName());
		System.out.println("두번째 자동차 엔진상태: "+carTwo.isEngineStatus());
		System.out.println("두번째 자동차 현재속도: "+carTwo.getCurrentSpeed());
		
		System.out.println("=======================================================");
		//참조변수.메소드명(값. 값,...): 참조변수에 저장된 객체가 .연산자를 사용하여 메소드 호출
		carOne.startEngine();
		carOne.speedUp(100);
		carOne.speedUp(60);
		carOne.speedDown(80);
		carOne.speedZero();
		carOne.stopEngine();
		System.out.println("=======================================================");
		//
		
		System.out.println("=======================================================");

	}
}
