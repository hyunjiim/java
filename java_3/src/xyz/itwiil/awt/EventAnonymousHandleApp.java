package xyz.itwiil.awt;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//[EXIT]버튼을 누른 경우 프로그램을 종료하는 기능의 프로그램 작성
//=>이벤트 처리 클래스를 익명의 내부클래스(Anonymous InnerClass)로 작성
public class EventAnonymousHandleApp extends Frame {
	private static final long serialVersionUID = 1L;
	
	public EventAnonymousHandleApp(String title) {
		super(title);
		
		setLayout(new FlowLayout());
		Button exit=new Button("EXIT"); //이벤트 소스
		exit.setFont(new Font(Font.SANS_SERIF,Font.BOLD,30));
		add(exit);
		
		//스마트 기기에서 많이 사용
		//[단점]객체를 한번만 사용할 수 있기 때문에 복잡한 프로그램에서 사용할 경우 코드의 중복이 발생할 수 있음
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		
		setBounds(800, 200, 300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new EventAnonymousHandleApp("이벤트처리");
	}
}
