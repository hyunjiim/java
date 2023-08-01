package xyz.itwill07.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//AOP : ��ü���� ���α׷���/�α� ó��, ����, Ʈ����� ���� �׸��� ���ܻ��� ó�� ���� �ڵ带 ���� ����
//���� �ۼ��ϰ� �ʿ��� ������ �ٽ��ڵ带 �����Ͽ� �����ϰ� �ϴ� ��

//AOP�� ���� : OOP�� ���� ���ȭ�� �پ ����� ����ϴ��� ���� ���� �и��� ���� �ۼ��ϱ� ����
//�䱸������ ���� ���ø����̼� ����� ���߿��� ���� �߰ߵ�
// => AOP������ �̸� Ⱦ�� �����̶� ��

//Ⱦ�� ����(Crosscutting Concerns): ���� ���� �и��� ���� �ۼ��ϱ� ���� �䱸��������, ��ü������ �⺻
//��Ģ�� ��Ű�鼭 �̸� �и��ؼ� ���ȭ�ϴ� ���� �ſ� �����
//�ٽ� ����(Core Concerns): �ش� �ý����� �ٽ� ��ġ�� ������ �״�� �巯�� ���ɿ�������, ������ ��ü����
//�м�/����(OOAD)�� ���� ���� ���ȭ�� �߻�ȭ�� ������

public class HewonAopApp {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("07-1_aop.xml");
		HewonService service=context.getBean("hewonService", HewonService.class);
		System.out.println("==========================================================");
		service.addHewon(null);
		System.out.println("==========================================================");
		service.getHewon(0);
		System.out.println("==========================================================");
		service.getHewonList();
		System.out.println("==========================================================");
		((ClassPathXmlApplicationContext)context).close();
	}
}
