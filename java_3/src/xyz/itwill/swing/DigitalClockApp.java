package xyz.itwill.swing;//-2번째 클래스

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

//시스템 현재 날짜와 시간을 제공받아 출력하는 GUI 프로그램 작성
public class DigitalClockApp extends JFrame {
	private static final long serialVersionUID = 1L;
	
	//날짜와 시간을 출력할 JLabel 컴퍼넌트를 저장하기 위한 필드
	JLabel clockJLabel;

	public DigitalClockApp(String title) {
		super(title);
		
		clockJLabel=new JLabel("2023년 04월 24일 15시 44분 22초",JLabel.CENTER);
		clockJLabel.setFont(new Font("굴림체", Font.BOLD, 30));
		clockJLabel.setForeground(Color.DARK_GRAY);
		
		getContentPane().add(clockJLabel,BorderLayout.CENTER);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(700, 200, 600, 200);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new DigitalClockApp("디지털 시계");
	}
}
