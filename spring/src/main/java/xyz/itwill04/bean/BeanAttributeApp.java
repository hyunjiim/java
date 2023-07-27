package xyz.itwill04.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanAttributeApp {
	public static void main(String[] args) {
		System.out.println("===================== Spring Container �ʱ�ȭ �� =====================");
		ApplicationContext context = new ClassPathXmlApplicationContext("04-2_beanAttribute.xml");
		System.out.println("===================== Spring Container �ʱ�ȭ �� =====================");
		//ApplicationContext.getBean(String beanName) : ������ �����̳ʷκ��� �Ű������� ���޹���
		//beanName�� Spring Bean�� �˻��Ͽ� ��ȯ�ϴ� �޼ҵ�
		// => Object Ÿ���� ��ü�� ��ȯ�ϹǷ� �ݵ�� ����� ��ü ����ȯ ���
		//InitDestroyMethodBean bean=(InitDestroyMethodBean)context.getBean("initDestroyMethodBean");
		
		//ApplicationContext.getBean(String beanName, Class<T> clazz): ������ �����̳ʷκ���
		//�Ű������� ���޹��� beanName�� Spring Bean(��ü)�� Class ��ü�� ��ü ����ȯ�Ͽ� ��ȯ�ϴ� �޼ҵ�
		InitDestroyMethodBean bean=context.getBean("initDestroyMethodBean" , InitDestroyMethodBean.class);
		//��κ� Spring Container�� �ʵ忡 �ʱⰪ�� �����Ͽ� ��ü�� �����ϵ��� �ϱ� ������ ���� �������� �ʴ� ���
		// => XXXAware : VOŬ���� ��� Spring Container�� �����ϰ� ���� �� XXXAware �������̽��� ����Ͽ� 
		//�ʿ��� Ŭ������ �ʵ忡 �ʵ尪�� �ʱ�ȭ�Ͽ� ��ü ����  >> ������̼� ������� ���� ������ ����
		
		//bean ������Ʈ�� �̿��ϸ� �޼ҵ带 ��ü�� ������ �� �ڵ����� ȣ��ǵ��� ����
		// => Spring Bean Configuration File���� bean ������Ʈ�� init-method �Ӽ����� ����� �ڵ� ȣ��
		//bean.init(); //�ʱ�ȭ �޼ҵ�  
		
		bean.display(); 
		
		//bean ������Ʈ�� �̿��ϸ� �޼ҵ带 ��ü �Ҹ� �� �ڵ����� ȣ��ǵ��� ����
		// => Spring Bean Configuration File���� bean ������Ʈ�� destroy-method �Ӽ����� ����� �ڵ� ȣ��
		//bean.destroy(); //������ �޼ҵ�
		System.out.println("==========================================================");
		context.getBean("lazyInitBean", LazyInitBean.class);
		System.out.println("=======================================================================");
		ScopeBean bean1=context.getBean("singletonBean", ScopeBean.class);
		ScopeBean bean2=context.getBean("singletonBean", ScopeBean.class);
		ScopeBean bean3=context.getBean("singletonBean", ScopeBean.class);
		
		System.out.println("bean1 = "+ bean1);
		System.out.println("bean2 = "+ bean2);
		System.out.println("bean3 = "+ bean3);
		System.out.println("=======================================================================");
		ScopeBean bean4=context.getBean("prototypeBean", ScopeBean.class);
		ScopeBean bean5=context.getBean("prototypeBean", ScopeBean.class);
		ScopeBean bean6=context.getBean("prototypeBean", ScopeBean.class);
		
		System.out.println("bean4 = "+ bean4);
		System.out.println("bean5 = "+ bean5);
		System.out.println("bean6 = "+ bean6);
		System.out.println("=======================================================================");
		((ClassPathXmlApplicationContext)context).close();
		System.out.println("=======================================================================");
	}
}
