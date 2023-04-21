package xyz.itwiil.awt;

import java.awt.Button;
import java.awt.Frame;

//배치관리자(LayoutManager): 컨테이너에 컴포넌트를 자동 배치하기 위한 기능을 제공하는 클래스
//=>BorderLayout, FlowLayout, GridLayout, CardLayout 등

//컨테이너 컴퍼넌트를 자동 배치하기 위한 배치관리자가 초기화 설정- 기본 배치 관리자
//=>Frame, Window, Dialog 등: BorderLayout
//=>Panel, Applet 등: FlowLayout

//배치관리자를 사용하지 않고 프레임에 컴퍼넌트를 배치하여 사용하는 프로그램
public class NonLayoutManagerApp extends Frame{
	private static final long serialVersionUID = 1L;
	
	public NonLayoutManagerApp(String title) {
		super(title);
		
		setLayout(null);
		
		Button button1=new Button("BUTTON-1");
		Button button2=new Button("BUTTON-2");
		
		button1.setBounds(80,100,150,80);
		button2.setBounds(80,300,150,80);
		
		add(button1);
		add(button2);
		
		setBounds(600, 100, 400, 500);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new NonLayoutManagerApp("배치관리자 미사용");
	}
	

}
