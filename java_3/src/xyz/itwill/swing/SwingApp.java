//xyz.itwill.swing 패키지 클래스_1
package xyz.itwill.swing;

import javax.swing.JFrame;

//javax.swing 패키지의 클래스를 이용하여 GUI 프로그램을 작성하는 방법

//1.java.awt 패키지의 컴퍼넌트 또는 컨테이너 관련 클래스 대신 javax.swing 패키지의 컴퍼넌트와 컨테이너 관련 클래스를 사용하여 UI 구현
//=>AWT 컴퍼넌트(컨테이너) 관련 클래스 이름 앞에 J를 붙이면 SWING 컴퍼넌트와 동일
//  ex) Frame(AWT) >> JFrame(SWING), Button(AWT) >> JButton(SWING)

public class SwingApp extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public SwingApp(String title) {
		super(title);
		
		setBounds(800, 200, 400, 500);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new SwingApp("Swing");
	}

}
