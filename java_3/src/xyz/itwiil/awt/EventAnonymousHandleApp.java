package xyz.itwiil.awt;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;


//=>이벤트 처리 클래스를 익명의 내부클래스(Anonymous InnerClass)로 작성
public class EventAnonymousHandleApp extends Frame {
	private static final long serialVersionUID = 1L;
	
	public EventAnonymousHandleApp(String title) {
		super(title);
		
		setLayout(new FlowLayout());
		Button exit=new Button("EXIT"); //이벤트 소스
		exit.setFont(new Font(Font.SANS_SERIF,Font.BOLD,30));
		add(exit);
		
		setBounds(800, 200, 300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new EventAnonymousHandleApp("이벤트처리");
	}
}
