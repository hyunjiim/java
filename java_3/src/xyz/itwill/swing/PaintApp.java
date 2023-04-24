package xyz.itwill.swing;//-4번째 클래스

import javax.swing.JFrame;

public class PaintApp extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public PaintApp(String title) {
		super(title);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(800, 200, 300, 400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new PaintApp("Paint");
	}
}
