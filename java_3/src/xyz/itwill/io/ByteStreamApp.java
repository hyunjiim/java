package xyz.itwill.io;

import java.io.IOException;

//java.io 패키지: 입력과 출력 관련 클래스가 선언된 패키지

//스트림(Stream): 값을 전달하기 위한 목적으로 생성된 입력 클래스와 출력클래스의 객체
//=>시냇물이 흐르는 모양을 모델링하여 만들었기 때문에 값이 한쪽 방향으로 전달되어 순차적으로 처리

//원시데이터 기반의 스트림(Byte Stream): 가공되지 않은 원시데이터를 전달하기 위한 입출력 스트림
//=>값을 1Byte 단위로 입력 또는 출력하기 위한 스트림
//=>InputStream 클래스와 OutputStream 클래스를 최상위 클래스로 관계가 설정된 클래스

//키보드로 원시데이터를 입력받아 모니터에 전달하여 출력하는 프로그램 작성
//=>EOF(End of File): 입력종료-[Ctrl]+[Z] 신호를 입력하면 프로그램 종료
public class ByteStreamApp {
	public static void main(String[] args) throws IOException {
		System.out.println("[메세지]키보드를 눌러 값을 입력해주세요.[프로그램 종료:Ctrl+Z]");
		
		int readByte;
		
		while (true) {
			//System.in: Java 프로그램 개발을 위해 기본적으로 제공되는 키보드 입력스트림이 저장된 필드
			//=>InputStream 클래스를 기반으로 제공되는 입력스트림(객체)
			//=>키보드를 누르면 키보드의 문자값이 입력스트림으로 전달
			//InputStream.read(): 입력스트림에 존재하는 값을 원시 데이터(1Byte)로 읽어 정수값(int)으로 반환하는 메소드
			//=>입력스트림에 값이 없는 경우 스레드는 일시 중지 상태로 전환
			//=>입력스트림에 엔터(Enter)가 입력될 경우 스레드 다시 실행
			//=>입력스트림 또는 출력스트림 관련 메소드는 IOException 발생
			//=>IOException은 일반 예외이므로 반드시 예외처리
			readByte=System.in.read(); //거의 발생하지 않는 예외이므로 throws를 사용하여 JVM이 예외처리하도록 작성
			
			//입력종료신호(Ctrl+Z: EOF)가 전달된 경우 반복문 종료
			if(readByte==-1) break;
			
			//System.out: Java 프로그램 개발을 위해 기본적으로 제공되는 모니터 출력스트림이 저장된 필드
			//=>OutputStream 클래스를 기반으로 제공되는 입력스트림(객체)-PrintStream 클래스
			//=>출력스트림에 값을 전달하면 모니터가 출력 처리
			//=>OutputStream.write(int b): 매개변수로 제공받은 값을 원시 데이터(1Byte)로 출력스트림에 전달하는 메소드
			System.out.write(readByte);
		}
		
		System.out.println("[메세지]프로그램을 종료합니다.");
	}
}
