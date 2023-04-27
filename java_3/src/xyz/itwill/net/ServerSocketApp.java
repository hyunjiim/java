package xyz.itwill.net;//2번째 클래스

import java.io.IOException;
import java.net.ServerSocket;

/*
 * 소켓(Socket)
 * 1.컴퓨터 네트워크를 경유하는 프로세스 간 통신의 종착점
 * 2.네트워크 응용 프로그램은 소켓을 통하여 통신망으로 데이터를 송수신
 *  =>두 소켓이 연결되면 서로 다른 프로세스끼리 데이터 전달 가능
 * 3.응용 프로그램과 TCP/IP 간 인터페이스 역할
 * 4.보통 TCP 또는 UDP를 이용하여 통신
 * 5. Socket의 종류
 *   ①Stream
 *    -TCP를 사용
 *    -양방향으로 보냈다는 보장성이 있음
 *    -대용량 데이터 전송에 적합
 *    -약간의 오버헤드 존재
 *   ②Datagram
 *    -UDP를 사용
 *    -비 연결형 소켓
 *    -메세지 크기에 약간의 제한이 있음
 *    -양방향으로 보냈다는 보장성 없음
 *    -데이터를 잃어 버려도 오류나지 않음
 *   ③RAW
 *    -Transport 계층을 우회하여 바로 애플리케이션으로 송신하는 소켓
 *    -필터를 거치지 않으므로 원형 그대로의 패킷 확인 가능 
 */



//TCP 프로그램: ServerSocket 클래스와 Socket 클래스를 이용하여 작성
//=>서버와 클라이언트가 소켓을 사용하여 1:1로 연결되어 데이터를 송수신하는 네트워크 프로그램

//서버(Server): 외부의 컴퓨터(클라이언트)가 접속할 수 있는 환경과 서비스를 제공하기 위한 컴퓨터
//=>ServerSocket 클래스를 사용하여 서버 프로그램 작성
//클라이언트(Client): 서버에 접속하여 서비스를 제공받을 수 있는 컴퓨터
//=>Socket 클래스를 사용하여 클라이언트 프로그램 작성

//ServerSocket 클래스를 사용하여 사용 가능한 포트번호를 검색하는 프로그램 작성
public class ServerSocketApp {
	public static void main(String[] args) {
		for(int i=2000;i<=9000;i+=1000) {  //0 ~ 1023 : Well-Known Port(HTTP : 80,HTTPS : 443, SMTP : 25, POP3 : 110 등)-사용불가
			try {
				//ServerSocket 클래스: 서버 프로그램을 작성하기 위해 사용하는 클래스
				//=>ServerSocket 클래스의 ServerSocket(int port)생성자를 이용하여 매개변수로 전달받은 포트번호를 활성화하여 ServerSocket 객체 생성
				//=>ServerSocket 객체를 생성하여 클라이언트가 접속할 수 있는 환경 제공
				//=>매개변수로 전달받은 포트번호를 이미 다른 네트워크 프로그램에 사용중인 경우 IOException 발생-try~catch구문으로 예외처리
				ServerSocket serverSocket=new ServerSocket(i);
				
				System.out.println("[메세지]"+i+"번 포트는 네트워크 프로그램에서 사용 가능합니다.");
				
				//ServerSocket.close(): ServerSocket 객체를 제거하는 메소드
				//=>클라이언트가 접속할 수 있는 환경 소멸
				serverSocket.close();
			}catch (IOException e) {

				System.out.println("[메세지]"+i+"번 포트는 이미 다른 프로그램에서 사용하고 있습니다.");			}
		}
	}
}
