package xyz.itwill.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

//다른 컴퓨터에서 보내온 메세지를 얻어와 출력하는 UDP 프로그램 작성
public class MessageReceiveApp {
	public static void main(String[] args) throws IOException {
		//데이터를 받는 컴퓨터는 포트를 활성화하기 위해 DatagramSocket 클래스의 DatagramSocket(int port) 생성자를 사용하여 객체 생성
		DatagramSocket socket=new DatagramSocket(4000);
		
		//패킷에 의해 전달된 값(메세지)을 저장하기 위한 byte 배열 선언
		byte[] data=new byte[1024];
		
		//데이터를 받는 컴퓨터는 DatagramPacket 클래스의 DatagramPacket(byte[] data,int length) 생성자를 이용하여 DatagramPacket 객체 생성
		DatagramPacket packet=new DatagramPacket(data, data.length);
		
		System.out.println("메세지 수신 중...");
		
		//DatagramSocket.receive(DatagramPacket packet):연결 컴퓨터에 보내온 값(패킷)을 얻어와 DatagramPacket 객체의 byte 배열에 저장하는 메소드
		//=>패킷을 받기전까지 스레드 일시 중지
		socket.receive(packet);
		
		//byte 배열에 저장된 값을 제공받아 String 객체를 생성하여 저장
		String message=new String(data);
		
		System.out.print("[결과]메세지 >> "+message);
	}
}
