package oop;

//클래스를 작성할 때 필드와 메소드에는 접근 지정자를 사용하여 접근 유무 설정 가능

//자동차를 객체 모델링하여 클래스로 작성
//=> 속성: 모델명, 엔진상태, 현재속도- 필드
//=> 행위: 시동 On/Off, 속도 증가, 속도 감소, 이동 중지- 메소드
public class Car {
	//필드
	private String modelName; //모델명
	private boolean engineStatus; //엔진상태-false:엔진 EngineOff, true:엔진 EngineOn
	private int currentSpeed; //현재속도
	//==================================================================================================
	//생성자
	//==================================================================================================
	//메소드
	//시동 On
	void  startEngine() {
		if(engineStatus) {//엔진이 꺼져있는 경우
			System.out.println(modelName+"의 자동차 시동이 켜져있습니다.");
			return; //메소드 종료
		}
		engineStatus=true;
		System.out.println(modelName+"의 시동을 켰습니다.");
	}
	
	//시동 Off
	void stopEngine() {
		if(!engineStatus) {//엔진이 꺼져있는 경우
			System.out.println(modelName+"의 자동차 시동이 꺼져있습니다.");
			return; //메소드 종료
		}
		if(currentSpeed!=0) {
			/*currentSpeed=0;
			System.out.println(modelName+"의 자동차가 멈췄습니다.");
			*/
			speedZero();
		}
		
		engineStatus=false;
		System.out.println(modelName+"의 시동을 껐습니다.");
	}
	
	//속도 증가
	void speedUp(int speed) {
		if(!engineStatus) {//엔진이 꺼져있는 경우
			System.out.println(modelName+"의 자동차 시동이 꺼져있습니다.");
			return; //메소드 종료
		}
		if(currentSpeed+speed>150) {
			speed=150-currentSpeed;
		}
		
		currentSpeed+=speed;
		System.out.println(modelName+"의 속도가 "+speed+"Km/h 증가 되었습니다. 현재 속도는 "+currentSpeed+"Km/h 입니다.");
	}
	
	//속도 감소
	void speedDown(int speed) {
		if(!engineStatus) {//엔진이 꺼져있는 경우
			System.out.println(modelName+"의 자동차 시동이 꺼져있습니다.");
			return; //메소드 종료
		}
		if(currentSpeed<speed) {
			speed=currentSpeed;
		}
		
		currentSpeed-=speed;
		System.out.println(modelName+"의 속도가 "+speed+"Km/h 감소 되었습니다. 현재 속도는 "+currentSpeed+"Km/h 입니다.");
		
	}
	
	//이동 중지
	void speedZero() {
		if(!engineStatus) {//엔진이 꺼져있는 경우
			System.out.println(modelName+"의 자동차 시동이 꺼져있습니다.");
			return; //메소드 종료
		}
		
		currentSpeed=0;
		System.out.println(modelName+"의 자동차가 멈췄습니다.");
	}
	
	//은닉화 처리된 필드를 위해 필드값을 반환하는 Getter메소드와 필드값을 변경하는 Setter 메소드 선언-캡슐화
	public String getModelName() {
		return modelName;
	}
	
	public void setModelName(String modelName) {
		//매개변수에 저장된 값에 대한 검증
		//this:메소드 내부에서 클래스의 객체를 표현하는 키워드
		//=>this 키워드를 사용하여 필드 표현
		this.modelName=modelName;  
		
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


	//
}
