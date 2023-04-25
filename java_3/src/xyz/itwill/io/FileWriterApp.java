package xyz.itwill.io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

//키보드로 입력된 값을 문자데이터로 제공받아 파일로 전달하여 저장하는 프로그램 작성
//=>EOF(End of File): 입력종료-[Ctrl]+[Z] 신호를 입력하면 프로그램 종료
public class FileWriterApp {
	public static void main(String[] args) throws IOException {
		System.out.println("[메세지]키보드를 눌러 값을 입력해주세요.[프로그램 종료: Ctrl+Z]");
		
		//키보드 입력 스트림을 InpuStreamReader 클래스의 입력스트림으로 확장
		//=>원시데이터가 아닌 문자데이터를 입력받기 위한 입력스트림
		InputStreamReader in=new InputStreamReader(System.in);
		
		//FileWriter 클래스: 파일에 문자데이터를 전달하기 위한 출력스트림을 생성하기 윟나 클래스
		//=>FileWriter 클래스의 FileWriter(String name)생성자를 이용하여 매개변수로 파일경로를 전달받아 파일 출력스트림 생성
		//=>매개변수로 전달받은 파일경로의 파일이 없는 경우 FileNotFoundException 
		//
		//FileWriter out=new FileWriter("c:/data/char.txt");
		FileWriter out=new FileWriter("c:/data/char.txt",true);
		
		int readByte;
		
		while(true) {
			readByte=in.read();
			
			if(readByte==-1) break;
			
			out.write(readByte);
		}
		
		out.close();
	}
}
