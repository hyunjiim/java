package xyz.itwill.awt;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//EventSourceHandleApp >> EventInnerHandleApp 
//이유: 컴퍼넌트의 수가 많아질 경우 내부클래스로 작성하는 방법이 유지보수에 유리
//=>가장 좋은 방법

//[EXIT]버튼을 누른 경우 프로그램을 종료하는 기능의 프로그램 작성
//=>이벤트 처리 클래스를 디자인 클래스의 내부 클래스로 작성
//=>내부클래스(이벤트 처리 클래스)는 외부클래스(디자인 클래스)의 필드와 메소드를 접근제한자에 상관없이 사용 가능
//=>이벤트 처리 메소드에서 디자인 클래스의 컴퍼넌트 사용 가능
public class EventInnerHandleApp extends Frame {
	private static final long serialVersionUID = 1L;
	public EventInnerHandleApp(String title) {
		super(title);
		
		setLayout(new FlowLayout());
		Button exit=new Button("EXIT"); //이벤트 소스
		exit.setFont(new Font(Font.SANS_SERIF,Font.BOLD,30));
		add(exit);
		
		//new연산자를 사용해 내부클래스의 객체를 생성하여 접근 가능
		exit.addActionListener(new EventHandle());
		
		setBounds(800, 200, 300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new EventInnerHandleApp("이벤트처리");
	}
	
	public class EventHandle implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
		
	}

}
