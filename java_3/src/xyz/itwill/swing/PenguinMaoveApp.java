package xyz.itwill.swing;//-5번째 클래스

import javax.swing.JFrame;

//
public class PenguinMaoveApp extends JFrame {
	private static final long serialVersionUID = 1L;

	public PenguinMaoveApp(String title) {
		super(title);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(700, 200, 646, 461);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new PenguinMaoveApp("펭귄 이동");
	}
}
