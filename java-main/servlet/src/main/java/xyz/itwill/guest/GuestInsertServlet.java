package xyz.itwill.guest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xyz.itwill.dao.GuestDAO;
import xyz.itwill.dto.GuestDTO;

//방명록 게시글을 전달받아 GUEST 테이블에 삽입하고 방명록 게시글 목록페이지(/guest/list.itwill)
//이동하기 위한 URL 주소를 클라이언트에게 전달하여 응답하는 서블릿
// => 방명록 게시글 입력페이지(guest/writeForm.itwill)에서 form 태그를 사용해 post 방식으로 요청
@WebServlet("/guest/write.itwill")
public class GuestInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//URL로 응답할 것이므로, 작성하지 않음
		//response.setContentType("text/html;charset=utf-8");
		//PrintWriter out=response.getWriter();
		
		//서블릿을 GET 방식으로 요청한 경우 - 비정상적 요청(form 태그는 post 방식)
		if(request.getMethod().equals("GET")) {
			response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return;
		}
		
		//1. 전달값을 전달받기 전 리퀘스트 메세지 몸체부에 저장되어 전달되는 값(디폴트:서유럽어)에 대한 캐릭터셋 변경
		request.setCharacterEncoding("utf-8");
		
		//2. 전달값을 반환받아 저장
		String writer=request.getParameter("writer");
		String subject=request.getParameter("subject");
		String content=request.getParameter("content");
		
		//3. DTO 객체를 생성하여 전달값으로 DTO 객체의 필드값 변경
		GuestDTO guest=new GuestDTO();
		guest.setWriter(writer);
		guest.setSubject(subject);
		guest.setContent(content);
		
		//4. GUEST 테이블에 행을 삽입한 DAO 클래스의 메소드 호출
		GuestDAO.getDAO().insertGuest(guest);
		
		//5. 클라이언트에게 URL 주소를 전달하여 응답 처리
		// => 클라이언트는 전달받은 URL 주소의 서블릿을 요청하여 실행결과를 응답받아 출력 - 리다이렉트 이동
		//response.sendRedirect(): 특정 처리 후, 또는 특정 조건일 때에 지정한 페이지로 이동하는 메소드
		response.sendRedirect("list.itwill"); //상대경로 사용
	}

}
