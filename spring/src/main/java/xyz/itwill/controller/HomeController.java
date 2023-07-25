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

//sts �ٿ�: Eclipse Marketplace >> sts �˻� �� sts3(Spring Boot, Spring Framework)�ٿ�
//Spring MVC project�� �ȳ����� ���� �߻� - ��Ŭ������ ����, ���� ȣȯ ����
// => https://docs.spring.io/sts/nan/v3915/NewAndNoteworthy.html���� sts3 ���� �ٿ� >> �ݵ������� ���� Ǯ�� >> sts.exe ����

//�ֻ��� ��Ű��: Controller or Model ������ �ϴ� Ŭ�������� ��Ƶ� ��Ű��

//Spring Framework�� ����: ȯ�漳�� ���Ͽ��� �ʿ��� ���̺귯������ ���� ����������ϴ� �������� ����
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
