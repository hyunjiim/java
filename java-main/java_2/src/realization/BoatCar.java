package realization;

//Boat인터페이스와 Car인터페이스를 상속받는 인터페이스
//인터페이스가 다른 인터페이스를 상속받기 위해서는 extends 키워드 사용-다중 상속
public interface BoatCar extends Car, Boat {
	void floating();
}
