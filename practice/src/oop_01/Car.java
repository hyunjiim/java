package oop_01;

//oop-04

/*
 * 클래스(Class): 객체(Object)를 생성하기 위한 자료형 - 참조형
 * => Java에서는 객체(Object) 대신 인스턴스(Instance)라는 용어 사용
 * => 현실에 존재하는 사물 또는 관념을 클래스라는 자료형으로 표현하여 프로그램에 동작될 수 있도록
 * 		객체로 생성하여 사용
 * 
 * 클래스 선언 형식
 * 형식) [public] class 클래스명 {
 * 					필드(Field): 표현 대상의 속성(값)을 저장하기 위한 변수 - 멤버변수
 * 					...
 * 					생성자(Constructor): 클래스로 객체를 생성하기 위한 특별한 형태의 메소드
 * 			...
 * 			메소드(Method): 표현 대상의 행위를 명령으로 제공하기 위한 함수 - 멤버함수
 * 			...
 * 
 * 	}
 * 
 * 
 * 클래스를 작성할 때 필드와 메소드에 접근 제한자를 사용하여 접근 허용 설정
 * 
 * 접근 제한자(Access Modifier): private, package(default), protected, public
 * => 클래스, 필드, 생성자, 메소드를 선언할 때 접근 허용을 설정하기 위한 키워드
 * 
 * private: 클래스 내부에서만 접근 가능하도록 허용하는 접근 제한자
 *  => 필드, 생성자, 메소드를 은닉화 처리하기 위해 사용 - 클래스 외부에서 접근할 경우 에러 발생
 *  => 일반적으로 필드에 사용하는 접근 제한자 - 객체로 필드에 직접적인 접근을 제한하기 위한 사용
 *  => 데이터 은닉화(Data Hiding): 값을 숨겨 보호하기 위한 기능
 *  
 * public: 모든 패키지의 클래스에서 접근 가능하도록 허용하는 접근 제한자
 * => 일반적으로 메소드에 사용하는 접근 제한자 - 프로그램 작성에 필요한 모든 클래스에서 접근할 수
 * 		있도록 허용
 */

//자동차를 객체로 모델링하여 클래스로 작성
// => 속성: 모델명, 엔진상태, 현재속도 - 필드
// => 행위: 시동 온, 시동 오프, 속도 증가, 속도 감소, 이동 중지 - 메소드
public class Car {
	private String modelName;
	private boolean engineStatus;
	private int currentSpeed;
	
	//생성자(Constructor): 생성자를 선언하지 않으면 매개변수가 없는 기본 생성자(Default
	//Constructor)가 자동으로 생성되어 제공 - 생략 가능

	//메소드(Method): 필드를 사용하여 메소드의 명령으로 필요한 기능이 제공되도록 작성
	// 시동 On
	public void startEngine() {
		engineStatus=true;
		System.out.println(modelName+"의 자동차 시동을 켰습니다.");
	}

	// 시동 Off
	public void stopEngine() {
		if(currentSpeed!=0) {
			currentSpeed =0;
		}
	}
	
	// 속도 증가
	public void speedUp() {
		
	}
	
	// 속도 감소
	public void speedDown() {
		
	}
	
	//이동 중지
	public void stopSpeed() {
		
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public boolean isEngineStatus() {
		return engineStatus;
	}

	public void setEngineStatus(boolean engineStatus) {
		this.engineStatus = engineStatus;
	}
	
	
	public int getCurrentSpeed() {
		return currentSpeed;
	}

	public void setCurrentSpeed(int currentSpeed) {
		this.currentSpeed = currentSpeed;
	}
	
	
	
	
	
	


}
