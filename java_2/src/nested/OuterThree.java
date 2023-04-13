package nested;

//지역클래스(LocalClass): 메소드 내부에 선언된 클래스 - 메소드가 종료되면 자동 소멸
//=>지역클래스에 final 또는 abstract 제한자만 사용하여 선언 가능
//=>접근제한자 및 static 제한자를 사용하여 지역클래스를 선언할 경우 에러 발생
//=>비동기식 처리를 위한 스레드 객체를 생성하기 위해 사용
public class OuterThree {
	private int outerNum;
	
	public OuterThree() {
		// TODO Auto-generated constructor stub
	}

	public OuterThree(int outerNum) {
		super();
		this.outerNum = outerNum;
	}

	public int getOuterNum() {
		return outerNum;
	}

	public void setOuterNum(int outerNum) {
		this.outerNum = outerNum;
	}
	
	public void outerDisplay() {
		System.out.println("outerNum= "+outerNum);
	}
	
	public void local() {
		class InnerThree{
			int innerNum;
			
			void innerDisplay() {
				System.out.println("innerNum= "+innerNum);
			}
		}
		
		InnerThree innerThree=new InnerThree();
		innerThree.innerNum=200;
		innerThree.innerDisplay();
	}
}
