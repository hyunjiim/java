package xyz.itwill.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import xyz.itwill.swing.DigitalClockApp.ClockEventHandle;

//사칙 연산식을 입력받아 연산 결과를 출력하는 프로그램

//[내가 작성한 프로그램의 문제점]
//1.실제 계산기에서는 연산자(*,/,+,-)를 누른경우 0으로 초기화되어야함-연산식이 입력된 그대로 label에 출력
//2.나누기 연산을 했을 때 소수점 한자리까지 출력됨
//3.b_C를 누르고 다시 연산을 시작하면 연산식 맨 앞에 0이 출력됨
//=>operation에는 ""을 저장하고 setText()를 사용하여 JLabel 컴퍼넌트에는 0이 출력되도록 수정
//4.여러 연산을 한번에 처리하려고 하는 경우 에러 발생

public class CalculatorFrameExampleApp extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	// 연산식을 입력하기 위한 필드(컴퍼넌트)
	private JButton b_0, b_1, b_2, b_3, b_4, b_5, b_6, b_7, b_8, b_9, b_equals, b_plus, b_minus, b_multi, b_div, b_C;

	// 연산 결과를 출력하기 위한 필드(컴퍼넌트)
	private JLabel label;

	// 연산식을 저장하기 위한 필드
	private String operation = "";
	private String[] operationArray= {};
	
	public CalculatorFrameExampleApp(String title) {
		super(title);
		initButtons();
		init();

	}

	private void init() {
		label = new JLabel("0");
		label.setFont(new Font("DIALOG", Font.BOLD, 30));
		label.setHorizontalAlignment(JLabel.RIGHT);
		label.setBackground(Color.LIGHT_GRAY);
		label.setForeground(Color.WHITE);

		JPanel p = new JPanel(new GridLayout(4, 4, 5, 5));
		p.setBackground(Color.BLACK);

		p.add(b_multi);
		p.add(b_div);
		p.add(b_plus);
		p.add(b_minus);
		p.add(b_1);
		p.add(b_2);
		p.add(b_3);
		p.add(b_4);
		p.add(b_5);
		p.add(b_6);
		p.add(b_7);
		p.add(b_8);
		p.add(b_9);
		p.add(b_0);
		p.add(b_equals);
		p.add(b_C);

		Container container = getContentPane();
		container.setLayout(new BorderLayout(10, 10));
		container.setBackground(Color.BLACK);
		container.add(label, BorderLayout.NORTH);
		container.add(p, BorderLayout.CENTER);

		b_0.addActionListener(this);
		b_1.addActionListener(this);
		b_2.addActionListener(this);
		b_3.addActionListener(this);
		b_4.addActionListener(this);
		b_5.addActionListener(this);
		b_6.addActionListener(this);
		b_7.addActionListener(this);
		b_8.addActionListener(this);
		b_9.addActionListener(this);
		b_div.addActionListener(this);
		b_plus.addActionListener(this);
		b_minus.addActionListener(this);
		b_multi.addActionListener(this);
		b_C.addActionListener(this);
		b_equals.addActionListener(this);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setResizable(false);
		setBounds(500, 100, 400, 400);
		setVisible(true);
	}

	private void initButtons() {
		// 버튼 객체 생성
		b_0 = new JButton("0");
		b_1 = new JButton("1");
		b_2 = new JButton("2");
		b_3 = new JButton("3");
		b_4 = new JButton("4");
		b_5 = new JButton("5");
		b_6 = new JButton("6");
		b_7 = new JButton("7");
		b_8 = new JButton("8");
		b_9 = new JButton("9");
		b_equals = new JButton("=");
		b_plus = new JButton("+");
		b_minus = new JButton("-");
		b_multi = new JButton("*");
		b_div = new JButton("/");
		b_C = new JButton("C");

		// 버튼 폰트
		b_0.setFont(new Font("DIALOG", Font.PLAIN, 20));
		b_1.setFont(new Font("DIALOG", Font.PLAIN, 20));
		b_2.setFont(new Font("DIALOG", Font.PLAIN, 20));
		b_3.setFont(new Font("DIALOG", Font.PLAIN, 20));
		b_4.setFont(new Font("DIALOG", Font.PLAIN, 20));
		b_5.setFont(new Font("DIALOG", Font.PLAIN, 20));
		b_6.setFont(new Font("DIALOG", Font.PLAIN, 20));
		b_7.setFont(new Font("DIALOG", Font.PLAIN, 20));
		b_8.setFont(new Font("DIALOG", Font.PLAIN, 20));
		b_9.setFont(new Font("DIALOG", Font.PLAIN, 20));
		b_div.setFont(new Font("DIALOG", Font.PLAIN, 20));
		b_plus.setFont(new Font("DIALOG", Font.PLAIN, 20));
		b_minus.setFont(new Font("DIALOG", Font.PLAIN, 20));
		b_multi.setFont(new Font("DIALOG", Font.PLAIN, 20));
		b_C.setFont(new Font("DIALOG", Font.PLAIN, 20));
		b_equals.setFont(new Font("DIALOG", Font.PLAIN, 20));

		// 버튼 바탕화면
		b_0.setBackground(Color.WHITE);
		b_1.setBackground(Color.WHITE);
		b_2.setBackground(Color.WHITE);
		b_3.setBackground(Color.WHITE);
		b_4.setBackground(Color.WHITE);
		b_5.setBackground(Color.WHITE);
		b_6.setBackground(Color.WHITE);
		b_7.setBackground(Color.WHITE);
		b_8.setBackground(Color.WHITE);
		b_9.setBackground(Color.WHITE);
		b_div.setBackground(Color.YELLOW);
		b_plus.setBackground(Color.YELLOW);
		b_minus.setBackground(Color.YELLOW);
		b_multi.setBackground(Color.YELLOW);
		b_C.setBackground(Color.GREEN);
		b_equals.setBackground(Color.CYAN);
	}

	public static void main(String[] args) {
		new CalculatorFrameExampleApp("계산기");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
			if (e.getSource() == b_equals) {
				if(operation.indexOf("+")!=-1) {
					operationArray = operation.split("\\+");
					long sum=Integer.parseInt(operationArray[0]) + Integer.parseInt(operationArray[1]);
					label.setText(String.valueOf(sum));
					
				} else if (operation.indexOf("-") != -1) {
					operationArray = operation.split("\\-");
					long minus=Integer.parseInt(operationArray[0]) - Integer.parseInt(operationArray[1]);
					label.setText(String.valueOf(minus));
					
				} else if (operation.indexOf("*") != -1) {
					operationArray = operation.split("\\*");
					long multi=Integer.parseInt(operationArray[0]) * Integer.parseInt(operationArray[1]);
					label.setText(String.valueOf(multi));
					
				} else if (operation.indexOf("/") != -1) {
					operationArray = operation.split("\\/");
					double div=Integer.parseInt(operationArray[0]) / Integer.parseInt(operationArray[1]);
					label.setText(String.valueOf(div));
				}
			}else if(e.getSource() == b_0){
				operation+="0";
				label.setText(operation);
			}else if(e.getSource() == b_1){
				operation+="1";
				label.setText(operation);
			}else if(e.getSource() == b_2){
				operation+="2";
				label.setText(operation);
			}else if(e.getSource() == b_3){
				operation+="3";
				label.setText(operation);
			}else if(e.getSource() == b_4){
				operation+="4";
				label.setText(operation);
			}else if(e.getSource() == b_5){
				operation+="5";
				label.setText(operation);
			}else if(e.getSource() == b_6){
				operation+="6";
				label.setText(operation);
			}else if(e.getSource() == b_7){
				operation+="7";
				label.setText(operation);
			}else if(e.getSource() == b_8){
				operation+="8";
				label.setText(operation);
			}else if(e.getSource() == b_9){
				operation+="9";
				label.setText(operation);
			}else if(e.getSource() == b_div){
				operation+="/";
				label.setText(operation);
			}else if(e.getSource() == b_plus){
				operation+="+";
				label.setText(operation);
			}else if(e.getSource() == b_minus){
				operation+="-";
				label.setText(operation);
			}else if(e.getSource() == b_multi){
				operation+="*";
				label.setText(operation);
			}else if(e.getSource() == b_C){
				operation="0";
				label.setText("0");
			}
		}	
}

