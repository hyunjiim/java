package oop;

//자동차를 객체 모델링하여 클래스로 작성
//=> 속성: 모델명, 엔진상태, 현재속도- 필드
//=> 행위: 시동 On/Off, 속도 증가, 속도 감소, 이동 중지- 메소드
public class Car {
	//필드
	String modelName; //모델명
	boolean engineStatus; //엔진상태-false:엔진 EngineOff, true:엔진 EngineOn
	int currentSpeed; //현재속도
	//==================================================================================================
	//생성자
	//==================================================================================================
	//메소드
	//시동 On
	void  startEngine() {
		engineStatus=true;
		System.out.println(modelName+"의 시동을 켰습니다.");
	}
	
	//시동 Off
	void stopEngine() {
		engineStatus=false;
		System.out.println(modelName+"의 시동을 껐습니다.");
	}
	
	//속도 증가
	void speedUp(int speed) {
		currentSpeed+=speed;
		System.out.println(modelName+"의 속도가 "+speed+"Km/h 증가 되었습니다. 현재 속도는 "+currentSpeed+"Km/h 입니다.");
	}
	
	//속도 감소
	void speedDown(int speed) {
		currentSpeed-=speed;
		System.out.println(modelName+"의 속도가 "+speed+"Km/h 감소 되었습니다. 현재 속도는 "+currentSpeed+"Km/h 입니다.");
		
	}
	
	//이동 중지
	void speedZero() {
		currentSpeed=0;
		System.out.println(modelName+"의 자동차가 멈췄습니다.");
	}
}
