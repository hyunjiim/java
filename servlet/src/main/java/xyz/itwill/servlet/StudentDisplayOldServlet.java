package xyz.itwill.servlet;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* [55day]
 1. StudentDisplayOldServlet - JDBC 기능 구현
- DBMS 서버에 접속(Driver 클래스)
  => OracleDriver을 사용하기 위해 ojdbc 라이브러리 빌드 처리
  =>클래스로더로 OracleDriver 클래스를 읽어들여 메소드 메모리 영역에 클래스 저장
  => OracleDriver를 JDBC Driver로 등록
  => JDBC Driver로 DBMS 서버에 접속하여 Connection 객체 반환
- 검색명령 전달
  => Connection 객체로 부터 sql 명령이 저장된 PreparedStatement 객체 반환
- 결과를 받아 클라이언트에게 전달
  => excuteQuery 메소드를 통해 DBMS에 SQL 명령 전달하여 검색 결과 반환

 */

/* [이 코딩의 문제점]
 - 가독성이 좋지 않고 유지보수 효율성과 생산성이 떨어짐
 - try 안에 servlet을 적어줘야 하기 때문에 예외가 발생하는지 확인하느라 프로그램 속도 저하
 - 코드에 중복이 생기고, 만드는 속도가 느림
 - servlet은 서버에 만들어지는 간단한 프로그램인데 간단한 프로그램이라 보기 어려움
	=> 비권장

 */


//STUDENT 테이블에 저장된 모든 학생정보를 검색하여 클라이언트에게 전달하여 응답하는 서블릿
// => JDBC 프로그램을 작성하기 위해서는 JDBC 관련 라이브러리 파일(ojdbc 라이브러리)을 프로젝트 빌드처리
@WebServlet("/old.itwill")
public class StudentDisplayOldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//가장 맨 위에 작성해야 함 헤더에서 전달되기 때문 중간에 적게되면 변경이 안될 수 있음
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		//JDBC 관련 객체를 저장하기 위한 변수 선언
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			//1. OracleDriver 클래스를 읽어 메모리에 저장
			// => OracleDriver 객체가 생성되어 DriverManager 클래스의 JDBC Driver로 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2. DriverManager 클래스에 등록된 JDBC 드라이버를 이용하여 DBMS 서버에 접속해
			//접속정보가 저장된 Connection 객체를 반환받아 저장
			String url="jdbc:oracle:thin:@localhost:1521:xe"; //xe라는 데이터베이스에 접속
			String username="scott";
			String password="tiger";
			con=DriverManager.getConnection(url, username, password);
			
			//3. Connection 객체로부터 SQL 명령이 저장된 PreparedStatement 객체를 반환받아 저장
			String sql="select * from student order by no";
			pstmt=con.prepareStatement(sql);
			
			//4. PreparedStatement 객체에 저장된 SQL 명령을 DBMS 서버에 전달하여 실행한 후 실행결과를
			//반환받아 저장
			rs=pstmt.executeQuery();
			
			//5.반환받은 실행결과를 사용자에게 제공
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset='UTF-8'>");
			out.println("<title>Servlet</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>학생목록</h1>");
			out.println("<hr>");
			out.println("<table border='1' cellspacing='0'>");
			out.println("<tr>");
			out.println("<th width='100'>학번</th>");
			out.println("<th width='150'>이름</th>");
			out.println("<th width='200'>전화번호</th>");
			out.println("<th width='300'>주소</th>");
			out.println("<th width='250'>생년월일</th>");
			out.println("</tr>");
			//ResultSet 객체에 저장된 모든 행의 컬럼값을 반환받아 클라이언트에 전달 - 반복처리
			while(rs.next()) {
				out.println("<tr>");
				out.println("<td align='center'>"+rs.getInt("no")+"</th>");
				out.println("<td align='center'>"+rs.getString("name")+"</th>");
				out.println("<td align='center'>"+rs.getString("phone")+"</th>");
				out.println("<td align='center'>"+rs.getString("address")+"</th>");
				out.println("<td align='center'>"+rs.getString("birthday").substring(0, 10)+"</th>");
				out.println("</tr>");
			}
			out.println("</table>");
			out.println("</body>");
			out.println("</html>");
		} catch (ClassNotFoundException e) {
			System.out.println("[에러]OracleDriver 클래스를 찾을 수 없습니다.");
		} catch (SQLException e) {
			System.out.println("[에러]JDBC 관련 오류"+e.getMessage());
		} finally {
			//6. JDBC 관련 객체 제거
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			}catch (SQLException e) {}
		}
	}

}
