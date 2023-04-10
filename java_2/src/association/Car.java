package association; //oop package의 Car class와는 다른 class

//자동차 정보(모델명, 생산년도, 엔진정보)를 저장하기 위한 클래스
public class Car {
	private String modelName;
	private int productionYear;
	//엔진정보를 저장하기 위한 필드-Engine 클래스를 자료형으로 선언된 필드
	//=>필드에는 생성자 또는 Setter 메소드를 사용하여 Engine 객체를 제공받아 저장- 포함관계
	private Engine carEngine;  //NullPointerException 발생
	
	
	public Car() {
		// TODO Auto-generated constructor stub
	}

	public Car(String modelName, int productionYear, Engine carEngine) {
		super();
		this.modelName = modelName;
		this.productionYear = productionYear;
		this.carEngine = carEngine;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public int getProductionYear() {
		return productionYear;
	}

	public void setProductionYear(int productionYear) {
		this.productionYear = productionYear;
	}

	public Engine getCarEngine() {
		return carEngine;
	}

	public void setCarEngine(Engine carEngine) {
		this.carEngine = carEngine;
	}
	
	public void displayCar() {
		System.out.println("모델명: "+modelName);
		System.out.println("생산년도: "+productionYear);
		//System.out.println("엔진정보: "+carEngine);//객체의 메모리 주소 출력
		
		//필드에 저장된 객체를 이용하여 메소드 호출
		//=>포함관계로 설정된 클래스(객체)의 메소드를 호출하여 원하는 기능 구현
		//=>포함관계가 설정되지 않은 상태에서 메소드가 호출될 경우 NullPointerException 발생
		//System.out.println("연료타입: "+carEngine.getFualType());
		//System.out.println("배기량: "+carEngine.getDisplacement());
		carEngine.displayEngine(); //코드의 중복성 최소화
	
	}
}
