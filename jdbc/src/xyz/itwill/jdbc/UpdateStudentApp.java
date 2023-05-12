package xyz.itwill.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


//STUDENT 테이블에 저장된 학생정보 중 학번이 [2000]인 학생의 이름을 [임걱정]으로 변경하고 주소를 [부천시 원미구]로 변경하는 JDBC 프로그램 작성
public class UpdateStudentApp {
	public static void main(String[] args) {
		
		Connection con=null;
		Statement stmt=null;
		try {
			//1.OracleDriver 클래스로 객체를 생성하여 DriverManager 클래스의 JDBC Driver 객체로 등록
			//Class.forName(String className) 메소드를 호출하여 ClassLoader 프로그램을 이용해 OracleDriver 클래스를 읽어 메모리에 저장
			//=>OracleDriver 클래스의 정적영역에서 OracleDriver 클래스를 객체로 생성하여 DriverManager 클래스의 JDBC Driver로 등록하는 메소드 호출
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2.DriverManager 클래스에 등록된 JDBC Driver 객체를 이용하여 DBMS 서버에 접속해 Connection 객체를 반환받아 저장
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String user="scott";
			String password="tiger";
			con=DriverManager.getConnection(url, user, password);
			
			//Connection 객체로부터 SQL 명령을 전달할 수 있는 Statement 객체를 반환받아 저장
			//Connection.createStatement(): SQL 명령을 전달할 수 있는 Statement 객체를 생성하여 반환하는 메소드
			stmt=con.createStatement();
			
			//String sql = "update student set name='임걱정', address='부천시 원미구' where no= 2000 ";
			//String sql = "update student set birthday='02/05/08' where no= 2000 ";
			String sql = "update student set birthday='98/12/11 'where no= 3000 ";
			
			int rows=stmt.executeUpdate(sql);
			
			System.out.println("[메세지]"+rows+"행의 정보가 변경되었습니다.");
			
			
		}catch (ClassNotFoundException e) {
			System.out.println("[에러]OracleDriver 클래스를 찾을 수 없습니다.");
		}catch (SQLException e) {
			System.out.println("[에러]JDBC 관련 오류 = "+e.getMessage());
		}finally {
			try {
				if(stmt!=null) stmt.close();
				if(con!=null) con.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
