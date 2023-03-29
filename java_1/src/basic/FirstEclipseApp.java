//클래스가 작성된 패키징를 표현하기 위한 문장
package basic;

//주석문: 프로그램에 설명을 제공하기 위한 문장으로 프로그램 실행과는 아무런 관계가 없는 문장이다.
//행주석: 하나의 행을 설명문으로 설정하여 사용
/*
범위주석: 범위로 설정된 문장을 설명문으로 사용
*/

//이클립스 단축키
//[Ctrl]+[Spacebar] >> 단어(키워드 또는 식별자)와 문장(템플릿 코드)울 자동 완성하는 기능을 제공
//[Ctrl]+[Alt]+[↑] 또는 [Ctrl]+[Alt]+[↓]: 행을 복사하여 붙여넣기 하는 기능을 제공
//[Alt]+[↑] 또는 [Alt]+[↓]: 행을 이동하는 기능을 제공
//[Ctrl]+[S]: 저장, 이때 자동 컴파일 됨
//

public class FirstEclipseApp { //자바는 대소문자 구분함, 거의 대부분 소문자 사용
	public static void main(String[] args) { 
		System.out.print("안녕하세요.");  //sysout 작성 후 [ctrl]+[Spacebar], [Enter]
		System.out.println("이클립스를 이용한 첫번째 프로그램입니다.");
		System.out.println("재미있게 프로그램을 만들어 봐요.");
	}
	
}