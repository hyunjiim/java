package xyz.itwill04.bean;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

//Spring �����ӿ�ũ������ BeanFactory ��ü �Ǵ� ApplicationContext ��ü�� Spring �����̳�
//(Spring Container) ��� ����
// => ������ �����̳ʴ� ȯ�漳������(Spring Bean Configuration File - XML)�� Ŭ������ �����޾�
//Spring Bean(��ü) ����
public class CreateBeanApp {
	public static void main(String[] args) {
		System.out.println("1. BeanFactory ��ü�� �����Ͽ� ������ �����̳ʷ� ����ϴ� ���");
		System.out.println("==================== Spring Container �ʱ�ȭ �� ====================");
		//BeanFactory �ʱ�ȭ �۾��� ����� ���� - ApplicationContext�� ���� �������̽��� ��ӹ޾� �� �پ��� ������� �ʱ�ȭ�� ����
		//BeanFactory �������̽��� ��ӹ��� �ڽ�Ŭ������ ��ü ���� - BeanFactory ��ü
		// => BeanFactory ��ü�� ������ �� Spring Bean Configuration File�� �����޾� ������ �����̳� 
		//���� - ������ �����̳� �ʱ�ȭ �۾�
		// => �Ű��������� Spring Bean Configuration File�� ��θ� �����޾� Resource ��ü�� ����
		// => BeanFactory ��ü�� Spring Bean Configuration File�� ��ϵ� Ŭ������ �̸� ��ü��
		//�������� �ʰ� Spring Bean�� �����ޱ� ���� ��û�� ��ü�� �����Ͽ� ����
		BeanFactory factory=new XmlBeanFactory
				(new FileSystemResource("src/main/resources/04-1_beanCreate.xml")); //���ڿ��� �ƴ� resource ��ü(����) �����ؾ� ��ü ���� ����
		System.out.println("==================== Spring Container �ʱ�ȭ �� ====================");
		//BeanFactory.getBean(String beanName): �Ű������� Spring Bean�� �����ϱ� ���� �ĺ���(beanName)��
		//���޹޾� ������ �����̳ʷκ��� Spring Bean(��ü)�� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
		// => ����)Object Ÿ���� ��ü�� ��ȯ�ϹǷ� �ݵ�� ����� ��ü ����ȯ ���
		// => �Ű������� ���޹��� �ĺ���(beanName)�� Spring Bean�� ���� ��� NoSuchBeanDefinitionException �߻�
		CreateBean bean1 = (CreateBean)factory.getBean("createBean"); //���⼭ ��ü ����
		bean1.display();
		System.out.println("====================================================================");
		System.out.println("2. ApplicationContext ��ü�� �����Ͽ� ������ �����̳ʷ� ����ϴ� ���");
		System.out.println("==================== Spring Container �ʱ�ȭ �� ====================");
		//ApplicationContext �������̽��� ��ӹ��� �ڽ�Ŭ������ ��ü ���� - ApplicationContext
		// => ApplicaiotnContext ��ü�� ������ �� SPring Bean Configuration File�� �����޾�
		//������ �����̳� ���� - ������ �����̳� �ʱ�ȭ �۾�
		// => Ŭ������ ���� ������ ����(ClassPath)�� ����� Spring Bean Configuration File�� [�ּ�]
		// => ApplicationContext ��ü�� Spring Bean Configuration File�� ��ϵ� Ŭ������ �̸� ��ü��
		//�����Ͽ� Spring Bean ��û�� �̸� ������ ��ü�� ���� - Spring Container�� ����Ǿ�
		ApplicationContext context=new ClassPathXmlApplicationContext("04-1_beanCreate.xml");
		System.out.println("==================== Spring Container �ʱ�ȭ �� ====================");
		//DL(Dependency Lookup) : ������ �����̳ʰ� �����ϴ� ��ü(Spring Bean)�� �˻��Ͽ� ����
		//ApplicationContext.getBean(String beanName): �Ű������� Spring Bean�� �����ϱ� ����
		//�ĺ���(beanName)�� ���޹޾� ������ �����̳ͷκ��� Spring Bean(��ü)�� ��ȯ�ϴ� �޼ҵ�
		// => Object Ÿ���� ��ü�� ��ȯ�ϹǷ� �ݵ�� ����� ��ü ����ȯ ���
		// => �Ű������� ���޹��� �ĺ���(beanName)�� Spring Bean�� ���� ��� NoSuchBeanDefinitionException �߻�
		//BeanFactory�� ����ϴ°� ���� �̺�Ʈ �ʱ�ȭ �۾� �� �� ���� ����� ����
		CreateBean bean2 = (CreateBean)factory.getBean("createBean");
		bean2.display();
		
		//ClassPathXmlApplicaiotnContext.close() : ApplicationContext ��ü�� �����ϴ� �޼ҵ�
		// => ������ �����̳ʰ� �Ҹ�Ǳ� ���� ������ �����̳ʿ� ���� �����Ǵ� ��� ��ü(Spring Bean)�� �ڵ� �Ҹ�
		// => Garbage Collector�� �˾Ƽ� �����ֱ� ������ �ۼ����� �ʾƵ� ������
		((ClassPathXmlApplicationContext)context).close();
	}
}
