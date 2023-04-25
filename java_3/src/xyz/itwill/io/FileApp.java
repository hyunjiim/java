package xyz.itwill.io;

import java.io.File;
import java.io.IOException;

//File 클래스: 파일(디렉터리-폴더) 관련 정보를 저장하기 위한 클래스
public class FileApp {
	public static void main(String[] args) throws IOException {
		//File 클래스의 File(String pathname) 생성자를 이용하여 매개변수로 전달받은 시스템(OS-운영체제)의
		//파일경로를 전달받아 File 객체 생성
		//=>파일경로: 시스템에 존재하는 파일 위치를 표현하는 방법
		//1. 절대경로 표현방법: 파일경로를 최상위 디렉터리를 기준으로 파일 위치를 표현하는 방법
		//2. 상대경로 표현방법: 현재 실행 프로그램의 작업 디렉터리를 기준으로 파일 위치를 표현하는 방법
		//=>이클립스에서는 프로젝트 폴더를 작업 디렉터리로 처리
		//=>Windows 운영체제에서는 폴더(드라이브)와 파일을 구분하기 위한 \기호 사용
		//=>Java에서는 \ 기호가 회피문자(Escape Character)를 표현하는 용도로 사용
		//=>\기호를 문자로 사용하기 위해 \\형태의 회피문자로 표현
		File fileOne=new File("c:\\data");
		
		//File.exists(): File 객체에 저장된 파일경로의 파일(디렉터리)이 시스템에 존재하지 않을 경우 [false]를 반환하고
		//존재할 경우[true]를 반환하는 메소드
		if(fileOne.exists()) {
			System.out.println("c:\\data 폴더가 이미 존재합니다.");
		}else {
			//File.mkdir(): File 객체에 저장된 파일경로의 디렉터리(폴더)를 생성하는 메소드
			fileOne.mkdir();
			System.out.println("c:\\data 폴더를 생성 하였습니다.");
		}
		
		System.out.println("=================================================================");
		File fileTwo=new File("c:\\data\\itwill.txt");
		
		if(fileTwo.exists()) {
			System.out.println("c:\\data\\\\itwill.txt 파일이 이미 존재합니다.");
		}else {
			//File.createNewFile(): File 객체에 저장된 파일경로의 파일을 생성하는 메소드
			fileTwo.createNewFile(); //IOException 발생 오류->throws
			System.out.println("c:\\data 폴더를 생성 하였습니다.");
		}
		System.out.println("=================================================================");
		//File 클래스의 File(String parent,String child)생성자를 이용하여 매개변수로 부모(디렉터리)와 자식(파일)을 
		//따로 전달받아 파일 경로가 저장된 File 객체 생성
		File fileThree=new File("c:/data","itwill.xyz");
		
		if(fileThree.exists()) {			
			//File.delete(): File 객체에 저장된 파일경로의 파일을 삭제하는 메소드
			fileThree.delete();
			System.out.println("c:\\data\\itwill.txt 파일을 삭제하였습니다.");
		}else {
			System.out.println("c:\\data\\itwill.txt 파일이 존재하지 않습니다.");
		}
		
		System.out.println("=================================================================");
		//파일경로를 상대경로 표현방법으로 전달하여 File 객체 생성
		//=>현재 프로그램의 작업 디렉토리(프로잭트 폴더)를 기준으로 파일 경로 설정
		//=>상대경로 표현방법은 [..] 기호를 사용하여 상위 디렉터리를 표현하며 [파일]형식으로 작업 디렉터리에 존재하는
		//파일이나 하위 디렉터리 표현
		File fileFour=new File("src");
		
		if(fileFour.exists()) {			
			//File.toString(): File 객체에 저장된 파일경로를 문자열로 반환하는 메소드
//			System.out.println("파일경로="+fileFour.toString());
			System.out.println("파일경로="+fileFour); //참조변수를 출력할 경우 toString() 메소드 자동호출
			//File.getAbsolutePath(): File 객체에 저장된 파일경로를 문자열로 
			System.out.println("파일경로="+fileFour.getAbsolutePath()); //참조변수를 출력할 경우 toString() 메소드 자동호출
			
			
		}else {
			System.out.println("작업디렉토리에 [src]디렉터리가 없습니다.");
		}
		System.out.println("=================================================================");
		//파일경로를 상대경로 표현방법으로 전달하여 File 객체 생성
		//=>현재 프로그램의 작업 디렉토리(프로잭트 폴더)를 기준으로 파일 경로 설정
		//=>상대경로 표현방법은 [..] 기호를 사용하여 상위 디렉터리를 표현하며 [파일]형식으로 작업 디렉터리에 존재하는
		//파일이나 하위 디렉터리 표현
		File fileFive=new File("c:/");
		//File.isDirectory(): File 객체에 저장된 파일경로의 파일이 디렉토리가 아닌경우 [false]를 반환하고 디렉터리인 경우[true]를 반환하는 메소드 
		if(fileFive.isDirectory()) {			
			//File.listFiles(): File 객체에 저장된 파일 경로의 디렉터리 파일이나 하위 디렉터리 목록을 File 객체 배열로 반환하는 메소드
			File[] subFiles=fileFive.listFiles();
			System.out.println(fileFive+"폴더의 자식 목록 >> "); 
			for(File file: subFiles) {
				if(fileFive.isFile()) {
					System.out.println("파일 ="+file);
				}else {
					System.out.println("폴더 ="+file);
				}
			}
			
		}else {
			System.out.println("작업디렉토리에 [src]디렉터리가 없습니다.");
		}
		
	}
}
