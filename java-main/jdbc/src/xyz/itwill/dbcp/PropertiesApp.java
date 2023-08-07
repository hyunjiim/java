//[34day-2]
package xyz.itwill.dbcp;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


/* Properties 파일
 * =>Key=Value형식으로 파라미터 정보들을 저장하기 위한 파일 확장자
 * =>프로그램 실행에 필요한 값을 제공하기 위한 텍스트 파일 - 확장자: ~.properties
 * =>프로그램의 유지보수 효율성 증가
 * =>Properties 파일에서 제공되는 값은 문자열만 가능
 * =>Properties 파일에서는 영문자,숫자,일부 특수문자를 제외한 나머지 문자는 유니코드로 변환되어 처리
 * =>주로 응용 프로그램에 대한 환경설정정보, DB와 연결하기 위한 DB 환경설정정보 등을 저장할 때 사용
 */

/* Properties 객체
 * =>Properties 클래스는 Map 인터페이스를 상속받은 자식 클래스(콜렉션 클래스)
 * =>Properties 파일의 이름(Name:Key)과 값(Value)을 하나의 엔트리로 저장하기 위한 객체
 */

/* Map 인터페이스(복습)
 * 
 * Map 인터페이스를 상속받은 콜렉션 클래스 - HashMap,Hashtable, Properties 등
 * =>이름(Key-고유값)과 객체(Value)를 하나의 그룹으로 묶어 Map 객체에 저장하여 관리
 * =>엔트리(Entry): Map 객체에 이름과 객체를 하나로 묶어 저장하기 위한 단위
 * =>이름(Key)를 이용하여 객체(Value)를 빠르게 검색하여 제공하기 위한 콜렉션 클래스
 */



//user.properties 파일에 저장된 값을 얻어와 출력하는 프로그램 작성
public class PropertiesApp {
	public PropertiesApp() throws IOException {
		//Properties 파일을 읽기 위한 입력스트림 생성
		//=>Properties 파일의 경로를 제공받아 FileInputStream 클래스로 객체 생성
		//[문제점] 프로그램 배포시 파일 경로에 문제 발생 가능 - [비권장]
		//FileInputStream in=new FileInputStream("src/xyz/itwill/dbcp/user.properties");
				
		//클래스.class: Class 파일을 이용하여 Class 객체(Clazz)를 제공받는 방법
		//=>Class.forName(), getClass() 등을 사용하여 Clazz를 제공받을 수도 있음
		//main 메소드에 작성하는 경우 아래처럼 작성		
		//InputStream in=PropertiesApp.class.getClassLoader().getResourceAsStream("xyz/itwill/dbcp/user.properties");
		
		//main 메소드에 작성하는것이 아니라면 아래처럼 작성 - 정석
		//Class.getClassLoader(): 클래스를 읽어 메모리에 저장된 ClassLoader 객체를 반환하는 메소드
		//ClassLoader.getResourceAsStream(String name): 리소스 파일에 대한 입력스트림을 생성하여 반환하는 메소드		
		InputStream in=getClass().getClassLoader().getResourceAsStream("xyz/itwill/dbcp/user.properties");
		
		//Properties 객체 생성 - 다수의 엔트리(Entry - Key와 Value) 저장
		//=>Properties 클래스는 Map 인터페이스를 상속받은 자식클래스
		//=>Properties 파일의 이름(Name - Key)과 값(Value)을 하나의 엔트리(Entry)로 저장하기 위한 객체
		Properties properties = new Properties();
		
		//Properties.load(InputStream in): 입력스트림으로 Properties 파일을 제공받아 파일에 저장된
		//모든 이름과 값으로 Properties 객체에 엔트리를 추가하는 메소드
		properties.load(in);
		
		//Properties.get(String key): Properties 객체에 저장된 엔트리에서 맵키(MapKey)를 전달받아
		// 맴값(MapValue)를 반환하는 메소드
		//=> 맵값은 Object 객체로 반환되므로 반드시 명시적 객체 형변환 후 사용 가능
		String id=(String)properties.get("id");
		String password=(String)properties.get("password");
		String name=(String)properties.get("name");
		
		System.out.println("아이디: "+id);
		System.out.println("비밀번호: "+password);
		System.out.println("이름: "+name);
	}
	
	public static void main(String[] args) throws IOException {
		new PropertiesApp();
	}
}


