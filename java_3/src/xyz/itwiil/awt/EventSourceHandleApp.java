package xyz.itwiil.awt;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//EventHandleApp의 문제점(이벤트 처리 메소드에서 디자인 클래스의 컴퍼넌트를 사용할 수 없음) 보완
//[EXIT]버튼을 누른 경우 프로그램을 종료하는 기능의 프로그램 작성
//=>디자인 클래스와 이벤트 처리 클래스를 하나의 클래스로 작성
public class EventSourceHandleApp extends Frame implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	public EventSourceHandleApp(String title) {
		super(title);
		
		setLayout(new FlowLayout());
		Button exit=new Button("EXIT"); //이벤트 소스
		exit.setFont(new Font(Font.SANS_SERIF,Font.BOLD,30));
		add(exit);
		
		//컴퍼넌트에서 발생된 이벤트를 this 키워드를 사용하여 현재 클래스의 객체로 이벤트 처리
		exit.addActionListener(this);
		setBounds(800, 200, 300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new EventSourceHandleApp("이벤트처리");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
}
