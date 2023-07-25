package xyz.itwill.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */

//sts3 설치: Eclipse Marketplace >> sts3 다운(Spring Boot, Spring Framework)
//Spring MVC project가 뜨지 않는 에러 발생 - 이클립스의 버그로 예상, 호환성 문제
// => https://docs.spring.io/sts/nan/v3915/NewAndNoteworthy.html에서 sts3 직접 다운로드 >> 반디집으로 압축 풀기 >> STS.exe 파일 실행하여 설치

//Spring Framework의 단점: 직접 환경파일에서 사용할 라이브러리를 빌드처리해줘야 하는 번거로움
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
}
