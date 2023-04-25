package xyz.itwill.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//원본파일에 저장된 값을 원시데이터로 읽어 타겟파일에 전달하여 저장하는 프로그램 작성
//=>파일 복사 프로그램
public class FileCopyByteApp {
	public static void main(String[] args) throws IOException {
		//=>보조 스트림 클래스: 기존 스트림을 전달받아 기능을 확장하기 위한 스트림 클래스
		//=>BufferedInputStream,BufferedOutputStream,DataInputStream,DataOutputStream 등
		
		//BufferedInputStream 클래스: InputStream 객체를 전달받아 대량의 원시데이터를 읽기 위한 입력스트림을 생성하기 위한 클래스
		BufferedInputStream in=null;
		
		//BufferedOutputStream 클래스: OutputStream 객체를 전달받아 대량의 원시데이터를 전달하기 위한 출력스트림을 생성하기 위한 클래스
		BufferedOutputStream out=null;
		try {
			//원본파일의 값을 원시데이터로 읽기 위한 입력스트림을 생성하여 저장
			in=new BufferedInputStream(new FileInputStream("c:/data/BANDIZIP.EXE"));
			
			out=new BufferedOutputStream(new FileOutputStream("c:/data/BANDIZIP_byte.EXE"));
			
			int readByte;
			//원본파일의 값을 원시데이터로 읽어 타겟파일로 전달하는 반복문-
			while(true) {
				readByte=in.read();
				if(readByte==-1) break;
				out.write(readByte);
			}
			
			System.out.println("[메세지]파일을 성공적으로 복사하였습니다.");
		}catch (FileNotFoundException e) {
			System.out.println("[에러]원본파일을 찾을 수 없습니다.");
		}finally {
			in.close();
			out.close();
		}
	}
}
