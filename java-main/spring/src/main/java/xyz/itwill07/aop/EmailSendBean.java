package xyz.itwill07.aop;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.mail.javamail.JavaMailSender;

import lombok.Setter;

//��й�ȣ ã�� >> ȸ�������� �̸��Ϸ� ��й�ȣ ������ & ���� ���� ���ۿ� Ȱ��

//JavaMail ����� �����ϱ� ���� spring-context-support ���̺귯���� javax.mail ���̺귯����
//������Ʈ�� ����ǵ��� ó�� - ���̺� �̿� : pom.xml (185 �ٿ� ����ó��)

//spring-context-support ���̺귯�� : Spring Context�� Ȯ�� ��� ����
//javax.mail ���̺귯�� : Java Mail ����� ����


//���� ���� ����� �����ϱ� ���� Ŭ���� - ���� ������ SMTP ���񽺸� ����Ͽ� ���� ����
// => ���� ����(Mail Server): ������ �ۼ����ϴ� ���񽺸� �����ϴ� ��ǻ��
// => SMTP(Simple Message Transfer Protocol - 25) ���񽺷� ������ ������ POP3(Post Office Protocol 3 - 110)
//���񽺳� IMAP(Internet Message Access Protocol - 143) ���񽺷� ������ �޾� ����ڿ��� ����

//POP3 : �ϳ��� ��⿡�� ������ Ȯ��, �ѹ��� ���� => ����Ʈ���̳� �ٸ� ��⿡���� ������ Ȯ���ؾ��� �ʿ伺 ����
// => IMAP : ���� ��⿡�� ���� Ȯ�� ���� 
// => ����ϱ� ���� ���� ������ DNS ���� ����

public class EmailSendBean {
	//JavaMailSender ��ü�� �����ϱ� ���� �ʵ� ���� - Setter Injection�� ���� @Setter ������̼� ���
	// => JavaMailSender ��ü: SMTP ���񽺸� �����ϴ� ������ ������ �����ϱ� ���� ��ü
	@Setter
	private JavaMailSender javaMailSender;
	
	//������ �����ϴ� �޼ҵ�
	// => ������ �޴� ����� �̸��� �ּ�, ����, ������ �Ű������� ���޹޾� ����
	// => ������ �޴� ����� �̸��� �ּҸ� ��ȯ
	public String sendEmail(String email, String subject, String content) throws Exception {
		//JavaMailSender.createMimeMessage() : MimeMessage ��ü�� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
		//MimeMessage ��ü : ���� ���� ���� ������ �����ϱ� ���� ��ü
		MimeMessage message=javaMailSender.createMimeMessage();
		
		//MimeMessage.setSubject(String subject) : MimeMessage ��ü�� ���� ������ �����ϴ� �޼ҵ�
		message.setSubject(subject);
		
		//MimeMessage.setText(String context): MimeMessage ��ü�� ���� ����(�Ϲݹ���)�� �����ϴ� �޼ҵ�
		//message.setText(content);
		
		//MimeMessage.setContent(Object o, String type): MimeMessage ��ü���� ���� ������ �����ϴ� �޼ҵ�
		// => type �Ű������� ���Ϸ� ������ ������ ����(MimeType)�� �����Ͽ� ����
		message.setContent(content, "text/html; charset=utf-8"); //HTML ������ ����
		
		//MimeMessage.setRecipient(RecipientType type, Address address) : MimeMessage ��ü��
		//������ �޴� ����� �̸��� �ּ� ���� ������ �����ϴ� �޼ҵ�
		// => RecipientType : ���� ���� ����ڸ� �����ϱ� ���� ����� ����
		// => Address : �̸��� �ּҰ� ����� Address ��ü�� ����
		//InternetAddress ��ü : �̸��� �ּҸ� �����ϱ� ���� ��ü
		//MimeMessage.setRecipient(RecipientType type, Address[] address) : MimeMessage ��ü��
		//������ �޴� ������� �̸��� �ּ� ���� ������ �����ϴ� �޼ҵ� - �ټ��� ������� ���� ����
		message.setRecipient(RecipientType.TO, new InternetAddress(email));
		//message.setRecipient(RecipientType.CC, new InternetAddress(email)); - CC : �Բ� �޴� ����� ��Ÿ���� ���
		
		//JavaMailSender.send(MailMessage message) : SMTP ���񽺸� ����Ͽ� ������ �����ϴ� �޼ҵ�
		javaMailSender.send(message);
		
		return email;
	}
}
