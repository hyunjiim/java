package xyz.itwill00.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//���� �� F5(���ΰ�ħ) ��ư Ŭ���ϸ� dailyLog ���� ����
public class LogHelloWorldApp {
	//Logger ��ü : �α� �̺�Ʈ�� �߻���Ű�� ���� ��ü
	// => �α� �̺�Ʈ�� �߻��Ǹ� �α� ����ü�� �α������� �����޾� ���
	//LoggerFactory Ŭ���� : Logger ��ü�� �����Ͽ� �����ϱ� ���� Ŭ���� - Factory ������ ������ �̿��� ������� Ŭ����
	//LoggerFactory.getLogger(Class<T> clazz) : �޸𸮿� ����� Ŭ����(Class ��ü - Clazz)��
	//���޹޾� �ش� Ŭ�������� �α� �̺�Ʈ�� �߻��� �� �ִ� Logger ��ü�� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
	private static final Logger logger=LoggerFactory.getLogger(LogHelloWorldApp.class);
	
	public static void main(String[] args) {
		//Logger.info(String message): Logger ��ü�� INFO ������ �α� �̺�Ʈ�� �߻��ϴ� �޼ҵ�
		// => �Ű��������� �α� ����ü�� ��ϵ� �α� �޼��� ����
		// => Logger.debug(String message) ���� �ٸ� �̺�Ʈ ������ �޼ҵ带 ����� ���� ����
		//log4j.xml ���Ͽ��� warn �̻��� ������ ��ϵǵ��� �����߱� ������ info �޼ҵ带 ���� ������ �޼����� �ֿܼ��� Ȯ�� �Ұ�
		// => log4j.xml ���Ͽ��� �ش� ��Ű���� �α� �̺�Ʈ level�� info�� �����ϴ� logger ������Ʈ �߰�
		logger.info("����"); 
		LogHelloWorld hw=new LogHelloWorld();
		String message=hw.hello("ȫ�浿");
		System.out.println("message = "+message);
		logger.info("����");
	}
}
