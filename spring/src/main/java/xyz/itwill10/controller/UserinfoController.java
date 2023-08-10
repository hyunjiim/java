package xyz.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.RequiredArgsConstructor;
import xyz.itwill10.dto.Userinfo;
import xyz.itwill10.exception.ExistsUserinfoException;
import xyz.itwill10.service.UserinfoService;

@Controller
@RequestMapping("/userinfo")
@RequiredArgsConstructor
public class UserinfoController {
	private final UserinfoService userinfoService;
	
	//회원정보를 입력받기 위한 뷰이름을 반환하는 메소드
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String write() {
		return "userinfo/user_write";
	}
	
	//회원정보를 전달받아 USERINFO 테이블에 삽입하고 로그인 페이지를 요청할 수 있는 URL 주소를
	//클라이언트에게 전달하여 응답 처리하는 요청 처리 메소드
	// => UserinfoService 객체로 메소드 호출시 예외 발생 - try~catch 구분을 사용하여 예외 처리
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(@ModelAttribute Userinfo userinfo, Model model) {
		try{
			//매개변수로 전달받은 회원정보의 아이디가 중복될 경우 ExistsUserinfoException 발생
			userinfoService.addUserinfo(userinfo);
		}catch (ExistsUserinfoException e) {
			//ExistsUserinfoException 객체에 저장된 예외 메세지를 반환받아 속성값으로 저장
			model.addAttribute("message", e.getMessage());
			
			//Ex
			model.addAttribute("userinfo", e.getUserinfo());
	
		}
		return "userinfo/user_write";
	}
}
