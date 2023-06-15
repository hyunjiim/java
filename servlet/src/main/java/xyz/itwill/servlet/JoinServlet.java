package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//입력페이지(form.html)로부터 전달받은 입력값(회원정보)을 반환받아 클라이언트에게 전달하여 
//응답하는 서블릿
// => 입력페이지의 form 태그를 이용하여 POST 방식으로 요청해야만 실행되는 서블릿
@WebServlet("/join.itwill")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		//서블릿을 GET 방식으로 요청한 경우 비정상적인 요청으로 클라이언트에게 에러코드를
		//전달하거나 에러페이지로 이동되도록 처리
		//HttpServletRequest.getMethod(): 서블릿을 요청한 요청방식(Get or POST)을 반환하는 메소드
		if(request.getMethod().equals("GET")) {//서블릿을 비정상적으로 요청한 경우
			/*
			//HttpServletResponse.sendError(int sc): 클라이언트에게 에러코드(4XX or 5XX)를
			//전달하여 응답하는 메소드
			// => 상태코드(StatusCode)는 HttpServletResponse 인터페이스의 정의된 상수 사용 권장
			//response.sendError(400);
			//response.sendError(HttpServletResponse.SC_BAD_REQUEST); //400
			//response.sendError(405);
			response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED); //405
			return;
			*/
			/*
			//HttpServletResponse.sendRedirect(String url): 클라이언트에게 301 상태코드와
			//URL 주소를 전달하여 응답
			// => 클라이언트는 전달받은 URL 주소로 브라우저의 요청 URL을 변경하여 웹프로그램을
			//   요청하고 실행결과를 응답받아 출력 - 페이지 이동(리다이렉트 이동)
			//response.sendRedirect("error.html"); //에러페이지로 이동
			response.sendRedirect("form.html"); //입력페이지로 이동
			return;
			*/
			
			out.println("<script type='text/javascript'>");
			out.println("alert('비정상적으로 페이지를 요청하였습니다.');");
			out.println("location.href='form.html';");
			out.println("</script>");
		}
		
		//서블릿을 요청할 때 전달된 값을 반환받아 저장
		//HttpServletRequest.getParameter(String name): 매개변수로 전달받은 이름의 전달값을 
		//문자열(String 객체)로 반환하는 메소드
		// => 매개변수의 이름으로 전달된 값이 없는 경우 [null] 반환
		String id=request.getParameter("id");
		String passwd=request.getParameter("passwd");
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String gender=request.getParameter("gender");
		String hobby=request.getParameter("hobby");
		String job=request.getParameter("job");
		String profile=request.getParameter("profile");
		
		/*
		if(id==null || id.equals("")) { //전달값이 없는 경우
			
		}
		
		if(Pattern.matches("^[a-zA-Z]\\w{5,19}", id)) { //전달값이 정규표현식 패턴과 맞지 않는 경우
			
		}
		*/

		out.println("<!DOCTYPE html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>회원가입 확인</h1>");
		out.println("<hr>");
		out.println("<p>아이디: "+id+"</p>");
		out.println("<p>비밀번호: "+passwd+"</p>");
		out.println("<p>이름: "+name+"</p>");
		out.println("<p>이메일: "+email+"</p>");
		out.println("<p>성별: "+gender+"</p>");
		out.println("<p>취미: "+hobby+"</p>");
		out.println("<p>직업: "+job+"</p>");
		out.println("<p>자기소개: "+profile+"</p>");
		out.println("</body>");
		out.println("</html>");
	}

}
