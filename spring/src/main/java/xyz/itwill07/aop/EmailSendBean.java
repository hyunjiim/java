package xyz.itwill07.aop;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.mail.javamail.JavaMailSender;

import lombok.Setter;

//비밀번호 찾기 >> 회원가입한 이메일로 비밀번호 보내기 & 광고 메일 전송에 활용 가능

//JavaMail 기능을 구현하기 위해 spring-context-support 라이브러리와 javax.mail 라이브러리가
//프로젝트에 빌드되도록 처리 - 메이븐 이용 : pom.xml

//spring-context-support 라이브러리 : Spring Context의 확장 기능 제공
// => 캐쉬, 메일, 스케줄링, UI 관련 기능 포함
//javax.mail 라이브러리 : Java Mail 기능을 제공

//메일 전송 기능을 제공하기 위한 클래스 - 메일 서버의 SMTP 서비스를 사용하여 메일 전송
// => 메일 서버(Mail Server) : 메일을 송수신하는 서비스를 제공하는 컴퓨터
// => SMTP(Simple Message Transfer Protocol - 25) 서비스로 메일을 보내고 POP3(Post Office Protocol 3 - 110)
//서비스나 IMAP(Internet Message Access Protocol - 143) 서비스로 메일을 받아 사용자에게 전달

//POP3 : 하나의 기기에서 메일을 확인, 한번만 전달 => 스마트폰이나 다른 기기에서도 메일을 확인해야할 필요성 증다
// => IMAP : 여러 기기에서 메일 확인 가능
// => 사용하기 위해 메일 서버와 DNS 서버 구현

public class EmailSendBean {
	//JavaMailSender 객체를 저장하기 위한 필드 선언 - Setter Injection을 위해 @Setter 어노테이션 사용
	// => JavaMailSender 객체 : SMTP 서비스를 제공하는 서버의 정보를 저장하기 위한 객체 - 메일 서버?
	@Setter
	private JavaMailSender javaMailSender;
	
	//메일을 전송하는 메소드
	// => 메일을 받는 사람의 이메일 주소, 제목, 내용을 매개변수로 전달받아 저장
	// => 메일을 받는 사람의 이메일 주소를 반환
	
	
}