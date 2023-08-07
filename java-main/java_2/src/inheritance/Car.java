package inheritance;
 
//자동차정보(모델명,소유자명)를 저장하기 위한 클래스
//=>클래스 선언시 상속받은 부모클래스가 없는 경우 기본적으로 Object 클래스를 자동으로 상속
public class Car {   //public class Car extends Object
	private String modelName;
	private String userName;
	
	public Car() {
		// TODO Auto-generated constructor stub
	}

	public Car(String modelName, String userName) {
		super();
		this.modelName = modelName;
		this.userName = userName;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	//Object 클래스의 toString() 메소드를 오버라이드 선언
	//=>Object 클래스의 toString() 메소드는 숨겨지고 Car 클래스의 toString() 메소드 호출
	//=>VO 클래스에서는 필드값을 문자열로 변환하여 반환하는 명령 작성- 필드값 확인
	@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "모델명: "+modelName+", 소유자: "+userName;
		}

}
