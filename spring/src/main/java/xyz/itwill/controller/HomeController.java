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

//sts 다운: Eclipse Marketplace >> sts 검색 후 sts3(Spring Boot, Spring Framework)다운
//Spring MVC project가 안나오는 문제 발생 - 이클립스의 버그, 버전 호환 문제
// => https://docs.spring.io/sts/nan/v3915/NewAndNoteworthy.html에서 sts3 직접 다운 >> 반디집으로 압축 풀기 >> sts.exe 실행

//최상위 패키지: Controller or Model 역할을 하는 클래스들을 모아둔 패키지

//Spring Framework의 단점: 환경설정 파일에서 필요한 라이브러리들을 직접 설정해줘야하는 불편함이 있음
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
