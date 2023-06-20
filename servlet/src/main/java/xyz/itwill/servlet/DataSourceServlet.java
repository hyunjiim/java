package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

/* [55day]
 * 3. DataSourceServlet - DBCP 기능으로 더 쉽게 Connection 객체 사용
 * DAO 클래스에서 Connection 객체를 하나씩 생성하지 않고 Connection 객체들을 미리 생성하고 이를 제공받아
 * 사용할 수 있도록 함
*/

//DBCP(DataBase Connection Pool): 다수의 Connection 객체를 미리 생성하여 저장하고 제공하기 위한 객체
// => 일반적으로 DataSource 인터페이스를 상속받은 자식 클래스로 객체 생성

//Apache 그룹에서 제공하는 tomcat-dbcp 라이브러리의 클래스를 이용하여 DBCP 객체를 생성해 미리 생성된
//Connection 객체를 제공받아 Connection 객체의 정보를 클라이언트에게 전달하여 응답하는 서블릿

@WebServlet("/dbcp.itwill")
public class DataSourceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		//org.apache.commons.dbcp2에 있는 BasicDataSource를 이용하여 데이터베이스 커넥션 풀 생성
		//여기에 미리 생성된 Connection 객체들을 저장 
		BasicDataSource dataSource=new BasicDataSource();
		
		//BasicDataSource 객체(DataSource 객체)에 저장될 다수의 Connection 객체를 생성하기
		//위한 정보를 메소드를 호출하여 변경 처리 - DataSource 객체의 필드값 변경
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver"); //필수
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe"); //필수
		dataSource.setUsername("scott"); //필수
		dataSource.setPassword("tiger"); //필수
		dataSource.setInitialSize(10); //최초 생성될 Connection 객체의 갯수 변경
		dataSource.setMaxIdle(10); //대기상태의 Connection 객체의 최대 갯수 변경
		dataSource.setMaxTotal(15); //생성 가능한 Connection 객체의 최대 갯수 변경
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>DBCP</h1>");
		out.println("<hr>");
		try {
			//DataSource.getConnection(): DataSource 객체에 저장된 다수의 Connection 객체 중
			//하나를 제공받아 반환하는 메소드
			Connection con=dataSource.getConnection();
			out.println("<p>con: "+con+"</p>");
			out.println("<hr>");
			out.println("<h3>Connection 객체 제공 후</h3>");
			//DataSource.getNumIdle(): DataSource 객체에 저장된 다수의 Connection 객체중 대기상태의
			//Connection 객체의 갯수를 반환하는 메소드
			out.println("<p>Idle Connection Number: "+dataSource.getNumIdle()+"</p>"); //Idle Connection Number: 9
			//DataSource.getNumActive(): DataSource 객체에 저장된 다수의 Connection 객체중 사용중인
			//Connection 객체의 갯수를 반환하는 메소드
			out.println("<p>Active Connection Number: "+dataSource.getNumActive()+"</p>"); //Active Connection Number: 1
			con.close(); //Connection 객체 제거 - DataSource 객체에서 Connection 객체를 대기상태로 변경
			out.println("<hr>");
			out.println("<h3>Connection 객체 제거 후</h3>");
			out.println("<p>Idle Connection Number: "+dataSource.getNumIdle()+"</p>"); //Idle Connection Number: 10
			out.println("<p>Active Connection Number: "+dataSource.getNumActive()+"</p>"); //Active Connection Number: 0
		} catch (SQLException e) {
			e.getStackTrace();
		}
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}

}
