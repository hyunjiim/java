package xyz.itwill.io;

import java.awt.BorderLayout;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

//문서파일 편집기 프로그램 작성-메모장
public class NotepadApp extends JFrame {
	private static final long serialVersionUID = 1L;
	
	JTextArea jTextArea;
	JMenuItem init,open,save,exit; //초기화,열기,저장,끝내기
	
	//FileDialog 클래스: 파일을 선택하기 위한 다이얼로그를 생성하기 위한 컴퍼넌트 클래스
	FileDialog openDialog, saveDialog;
	
	//현재 작업중인 문서파일의 경로를 저장하기 위한 필드
	private String filepath;
	
	public NotepadApp(String title) {
		super(title);
		
		JMenuBar jMenuBar=new JMenuBar();
		JMenu jMenu=new JMenu("파일(F)");
		//JMenu.setMnemonic(Key):메뉴를 빠르게 선택할 수 있는 문자(Key) 지정[Alt+Key]
		jMenu.setMnemonic('F');
		
		//메뉴아이템을 선택할 경우 ActionEvent 발생
		init=new JMenuItem("새로 만들기(N)",'N');
		open=new JMenuItem("열기(O)",'O');
		save=new JMenuItem("저장(S)",'S');
		exit=new JMenuItem("끝내기(X)",'X');
		
		init.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,InputEvent.CTRL_DOWN_MASK));//단축키 제공:[Ctrl]+[N]
		open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,InputEvent.ALT_DOWN_MASK+InputEvent.SHIFT_DOWN_MASK) );//단축키 제공:[Ctrl]+[N]
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.ALT_DOWN_MASK+InputEvent.SHIFT_DOWN_MASK));//단축키 제공:[Ctrl]+[N]
		
		jMenu.add(init);
		jMenu.add(open);
		jMenu.add(save);
		jMenu.add(exit);
		
		jMenuBar.add(jMenu);
		
		setJMenuBar(jMenuBar);
		
		jTextArea=new JTextArea();
		jTextArea.setFont(new Font("굴림체", Font.PLAIN, 20));
		JScrollPane jScrollPane=new JScrollPane(jTextArea);
		
		getContentPane().add(jScrollPane, BorderLayout.CENTER);
		
		openDialog=new FileDialog(this,"열기",FileDialog.LOAD); //읽어들이기 용도의 다이얼로그
		saveDialog=new FileDialog(this,"저장",FileDialog.SAVE); //저장 용도의 다이얼로그
		 
		init.addActionListener(new NotepadEventHandle());
		open.addActionListener(new NotepadEventHandle());
		save.addActionListener(new NotepadEventHandle());
		exit.addActionListener(new NotepadEventHandle());
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(450, 150, 1000, 600);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new NotepadApp("제목없음-Java 메모장");
	}
	
	public class NotepadEventHandle implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object eventSource=e.getSource();
			
			if(eventSource==init) {
				jTextArea.setText("");	//JTextArea 컴퍼넌트 초기화
				filepath="";	//필드 초기화
				setTitle("제목 없음-Java 메모장");	//프레임 제목 초기화
			}else if(eventSource==open) {
				//열기 관련 파일 다이얼로그를 화면에 출력
				//=>파일을 선택하거나 선택을 취소한 경우 파일 다이얼로그는 자동으로 숨김 처리
				openDialog.setVisible(true);
				
				//FileDialog.getFile(): 선택된 파일의 이름을 반환하는 메소드
				if(openDialog.getFile()==null) return;//파일 선택을 취소한 경우 메소드 종료
				
				//FileDialog.getDirectory(): 선택된 파일의 디렉터리 경로를 반환하는 메소드
				filepath=openDialog.getDirectory()+openDialog.getFile();//선택된 파일 경로 저장
				
				try {
					BufferedReader in = new BufferedReader(new FileReader(filepath)); //문서파일을 읽거나 쓸때는 Reader,Writer 사용
					
					jTextArea.setText("");//JTextArea 컴퍼넌트 초기화
					
					while(true) {
						//파일에 저장된 값을 한줄씩 읽어 문자열로 반환받아 저장
						String text=in.readLine(); //BufferedReader.readLine(): Enter 전까지의 문자열을 한번에 읽어들일 수 있음
						if(text==null) break; //""가 아니라 null //파일 내용이 없는 경우 반복문 종료
						//변수에 저장된 문자열을 JTextArea 컴퍼넌트에 추가하여 출력
						jTextArea.append(text+"\n"); //enter는 인식안되기 때문에 여기서 처리
					}
					in.close();
					
					setTitle(openDialog.getFile()+" - Java 메모장");
				}catch (FileNotFoundException exception) { //IOException 보다 위에 작성되어야함
					JOptionPane.showMessageDialog(null, "파일을 찾을 수 없습니다."); 
				}catch (IOException exception) {
					JOptionPane.showMessageDialog(null, "프로그램에 문제가 발생 하였습니다"); 
				}
				
				
			}else if(eventSource==save) {
				if(filepath==null||filepath.equals("")) {
					//저장 관련 파일 다이얼로그를 화면에 출력
					saveDialog.setVisible(true);
				
					if(saveDialog.getFile()==null) return;//파일 선택을 취소한 경우 메소드 종료
				
					filepath=saveDialog.getDirectory()+saveDialog.getFile();//선택된 파일 경로 저장
					
					setTitle(saveDialog.getFile()+" - Java 메모장");
				}
				try {
					BufferedWriter out=new BufferedWriter(new FileWriter(filepath));
					
					//JTextArea 컴퍼넌트의 모든 문자열을 반환받아 저장
					String text=jTextArea.getText();
					
					//반환받은 문자열을 출력스트림으로 전달하여 저장
					out.write(text);
					
					out.close();
					
				}catch (FileNotFoundException exception) {
					JOptionPane.showMessageDialog(null, "파일을 찾을 수 없습니다."); 
				}catch (IOException exception) {
					JOptionPane.showMessageDialog(null, "프로그램에 문제가 발생 하였습니다"); 
				}
				
			}else if(eventSource==exit) {
				System.exit(0);
			}
		}
		
	}
}
