package basic;

public class SwitchApp {
	public static void main(String[] args) {
		
		int choice=1;
		//switch문
		switch(choice) {
		case 1: 
			System.out.println("수성으로 이동합니다.");
			break;
		case 2: 
			System.out.println("금성으로 이동합니다.");
			break;
		case 3: 
			System.out.println("화성으로 이동합니다.");
			break;
			
		}
		
		System.out.println("======================================================");
		
		choice=4;
		//switch의 값과 case의 값이 모두 다른 경우 default에 작성된 명령을 무조건 실행
		switch(choice) {
		case 1: 
			System.out.println("수성으로 이동합니다.");
			break;
		case 2: 
			System.out.println("금성으로 이동합니다.");
			break;
		case 3: 
			System.out.println("화성으로 이동합니다.");
			break;
		default:
			System.out.println("지구로 이동합니다.");
			
		}
		
		System.out.println("======================================================");
		//변수값으로 등급을 구분하여 출력하는 프로그램 작성-switch문
		int jumsu=85;
		String grade="";
		
		switch(jumsu/10) {
		case 10: case 9:
			grade="A";
			break;
		case 8:
			grade="B";
			break;
		case 7:
			grade="C";
			break;
		case 6:
			grade="D";
			break;
		default:
			grade="F";
			
		}
		System.out.println("[결과]점수:"+jumsu+" 학점:"+grade);
		
		System.out.println("======================================================");
		
		String kor="둘";
		String eng="";
		
		switch(kor) {
		case "하나":
			eng="One";
			break;
		case "둘":
			eng="Two";
			break;
		case "셋":
			eng="Three";
			break;
		default: eng="1~3 사이값을 입력하세요.";
		}
		System.out.println("[결과]한글:"+kor+" 영어:"+eng);
	}
}
