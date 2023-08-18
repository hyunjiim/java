package xyz.itwill10.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import xyz.itwill10.dto.Member;

@Controller
public class LoginController {
	//login 페이지를 get 방식으로 요청하면 login_form으로 응답처리
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login_form"; //아이디, 비밀번호
	}
	
	/*
	//전달값(로그인정보)을 제공받아 인증 처리 후 권한 관련 정보를 Session Scope 속성값으로 저장하고
	//로그인 성공 메세지를 출력하는 JSP 문서의 뷰이름을 반환하는 요청 처리 메소드
	// => 전달값을 String 클래스의 매개변수에 하나씩 제공받아 사용
	// => Session Scope 속성값을 저장하기 위해 매개변수로 HttpSession 객체를 제공받아 사용
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam String id, @RequestParam String passwd
			,HttpSession session, Model model) {
		if(!id.equals("abc123") || !passwd.equals("123456")) { //인증 실패
			//인증 실패 관련 정보를 Request Scope 속성값으로 저장 - 입력페이지(JSP)에서 출력 가능
			//Request Scope : 현재 요청 처리 메소드와 포워드 이동되는 뷰(JSP)에서만 속성값을 제공받아 사용
			model.addAttribute("message", "아이디 또는 비밀번호를 잘못 입력 하였습니다.");
			model.addAttribute("id", id);
			return "login_form"; //입력페이지로 이동
		}
		
		//인증성공 - 권한 관련 정보를 Session Scope 속성값으로 저장
		//Session Scope : 동일한 세션을 사용하는 모든 요청 처리 메소드와 뷰에서 속성값을 제공받아 사용
		session.setAttribute("loginId", id);
		
		return "login_display";
	}
	*/

	//전달값(로그인정보)를 제공받아 인증 처리 후 권한 관련 정보를 Session Scope 속성값으로 저장하고
	//로그인 성공 메세지를 출력하는 JSP 문서의 뷰이름을 반환하는 요청 처리 메소드
	// => 모든 전달값을 Member 클래스의 매개변수에 필드값으로 제공받아 사용
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute Member member, HttpSession session, Model model) { //Command 객체로 받아 처리
		if(!member.getId().equals("abc123") || !member.getPasswd().equals("123456")) {//인증 실패
			//인증 실패 관련 정보를 Request Scope 속성값으로 저장 - 입력페이지(JSP)에서 출력 가능
			//Request Scope : 현재 요청 처리 메소드와 포워드 이동 되는 뷰(JSP)에서만 속성값을 제공받아 사용
			model.addAttribute("message", "아이디 또는 비밀번호를 잘못 입력 하였습니다.");
			return "login_form"; //입력페이지로 이동 - member 객체와 model 객체에 저장된 message를 login_form 페이지에서 사용 가능
		}
		
		//인증 성공 - 권한 관련 정보를 Session Scope 속성값으로 저장
		//Session Scope : 동일한 세션을 사용하는(클라이언트가 같은) 모든 요청 처리 메소드와 뷰에서 속성값을 제공받아 사용
		session.setAttribute("loginId", member.getId());
		
		return "login_display";
	}
	
	//세션의 유효 시간은 기본적으로 30 - 세션 시간 변경? Spring Security 사용
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		//session.removeAttribute("loginId");
		//session.invalidate() : 세션의 값들을 모두 사라지도록 하기 위해 사용
		session.invalidate();
		
		return "logout_display";
	}
	
	@RequestMapping("/login_display")
	public String login(HttpSession session, Model model) {
		if(session.getAttribute("loginId")==null) {
			model.addAttribute("message", "로그인 사용자만 접근 가능합니다.");
			return "login_form";
		} 
		
		return "login_display";
	}
}