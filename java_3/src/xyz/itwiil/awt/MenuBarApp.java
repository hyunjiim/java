package xyz.itwiil.awt;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.TextArea;
import java.awt.event.KeyEvent;

//MenuItem >> Menu >> MenuBar >> Frame
public class MenuBarApp extends Frame {
	private static final long serialVersionUID = 1L;

	public MenuBarApp(String title) {
		super(title);
		
		MenuBar menuBar=new MenuBar();
		
		Menu file=new Menu("File");
		Menu help=new Menu("Help");
		
		menuBar.add(file);
		menuBar.add(help);
		
		//MenuShortcut 클래스: 메뉴 아이템에 단축키를 제공하기 위한 클래스
		//KeyEvent 클래스: 가상의 키보드 정보를 제공하기 위한 클래스
		MenuItem open=new MenuItem("Open",new MenuShortcut(KeyEvent.VK_0));
		MenuItem save=new MenuItem("Save",new MenuShortcut(KeyEvent.VK_S));
		MenuItem exit=new MenuItem("Exit");

		MenuItem view=new MenuItem("HelpView");
		MenuItem info=new MenuItem("Information");
		
		file.add(open);
		file.add(save);
		file.addSeparator();
		file.add(exit);
		
		help.add(view);
		help.addSeparator();
		help.add(info);
		
		//Frame.setMenuBar(MenuBar bar): 프레임의 메뉴바를 변경하는 메소드
		setMenuBar(menuBar);
		TextArea textArea=new TextArea();
		textArea.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,20));
		add(textArea, BorderLayout.CENTER);
		
		setBounds(500, 100, 1000, 1000);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MenuBarApp("MenuBar");
	}
}
