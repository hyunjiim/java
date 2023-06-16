package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//클라이언트에게 쿠키를 전달하고 실행결과를 웹문서로 응답하는 서블릿
// => 클라이언트는 전달받은 쿠키를 저장
//쿠키(Cookie): 서버(웹프로그램)와 클라이언트(브라우저)의 연결 지속성을 제공하기 위한 정보를
//클라이언트에 저장하는 문자값
// => 클라이언트는 접속 서버의 정보를 식별자로 하여 쿠키 저장
@WebServlet("/create.itwill")
public class CookieCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		/* Cookie 객체 생성 -  Cookie 객체를 클라이언트에 전달하여 클라이언트에 쿠키 저장 */
		// Cookie 객체: 쿠키관련 정보를 저장하기 위한 객체
		// Cookie(String name, String value) 생성자의 매개변수에 쿠키명과 쿠키값을 전달해 객체 생성
		// 쿠키명: 쿠키값을 구분하기 위한 식별자, 쿠키값: 연결 지속성을 제공하기 위한 문자값
		// 쿠키명과 쿠키값은 영문자, 숫자, 일부 특수문자만 사용하여 작성 가능
		Cookie idCookie= new Cookie("id", "abc123");
		Cookie countCookie= new Cookie("count", "0"); //String으로 작성되어야 함
		
		//클라이언트에 전달되어 저장될 쿠키의 유지시간 변경
		//Cookie.setMaxAge(int ex)
		idCookie.setMaxAge(24*60*60); //쿠키의 유지시간을 1일로 변경
		
		
		
		
		
		
		
	}

}
