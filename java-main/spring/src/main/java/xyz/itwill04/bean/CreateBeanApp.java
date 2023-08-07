package xyz.itwill04.bean;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

//Spring 프레임워크에서는 BeanFactory 객체 또는 ApplicationContext 객체로 Spring 컨테이너
//(Spring Container) 기능 제공
// => 스프링 컨테이너는 환경설정파일(Spring Bean Configuration File - XML)로 클래스를 제공받아
//Spring Bean(객체) 관리
public class CreateBeanApp {
	public static void main(String[] args) {
		System.out.println("1. BeanFactory 객체를 생성하여 스프링 컨테이너로 사용하는 방법");
		System.out.println("==================== Spring Container 초기화 전 ====================");
		//BeanFactory 초기화 작업의 방법이 적음 - ApplicationContext는 많은 인터페이스를 상속받아 더 다양한 방법으로 초기화가 가능
		//BeanFactory 인터페이스를 상속받은 자식클래스로 객체 생성 - BeanFactory 객체
		// => BeanFactory 객체를 생성할 때 Spring Bean Configuration File을 제공받아 스프링 컨테이너 
		//생성 - 스프링 컨테이너 초기화 작업
		// => 매개변수에는 Spring Bean Configuration File의 경로를 제공받아 Resource 객체로 생성
		// => BeanFactory 객체는 Spring Bean Configuration File에 등록된 클래스로 미리 객체를
		//생성하지 않고 Spring Bean을 제공받기 위해 요청시 객체를 생성하여 제공
		BeanFactory factory=new XmlBeanFactory
				(new FileSystemResource("src/main/resources/04-1_beanCreate.xml")); //문자열이 아닌 resource 객체(파일) 전달해야 객체 생성 가능
		System.out.println("==================== Spring Container 초기화 후 ====================");
		//BeanFactory.getBean(String beanName): 매개변수로 Spring Bean을 구분하기 위한 식별자(beanName)을
		//전달받아 스프링 컨테이너로부터 Spring Bean(객체)를 생성하여 반환하는 메소드
		// => 주의)Object 타입읠 객체를 반환하므로 반드시 명시적 객체 형변환 사용
		// => 매개변수로 전달받은 식별자(beanName)의 Spring Bean이 없는 경우 NoSuchBeanDefinitionException 발생
		CreateBean bean1 = (CreateBean)factory.getBean("createBean"); //여기서 객체 생성
		bean1.display();
		System.out.println("====================================================================");
		System.out.println("2. ApplicationContext 객체를 생성하여 스프링 컨테이너로 사용하는 방법");
		System.out.println("==================== Spring Container 초기화 전 ====================");
		//ApplicationContext 인터페이스를 상속받은 자식클래스로 객체 생성 - ApplicationContext
		// => ApplicaiotnContext 객체를 생성할 때 SPring Bean Configuration File을 제공받아
		//스프링 컨테이너 생성 - 스프링 컨테이너 초기화 작업
		// => 클래스가 참조 가능한 폴더(ClassPath)에 저장된 Spring Bean Configuration File을 [주석]
		// => ApplicationContext 객체는 Spring Bean Configuration File에 등록된 클래스로 미리 객체를
		//생성하여 Spring Bean 요청시 미리 생성된 객체를 제공 - Spring Container가 실행되어
		ApplicationContext context=new ClassPathXmlApplicationContext("04-1_beanCreate.xml");
		System.out.println("==================== Spring Container 초기화 후 ====================");
		//DL(Dependency Lookup) : 스프링 컨테이너가 관리하는 객체(Spring Bean)를 검색하여 제공
		//ApplicationContext.getBean(String beanName): 매개변수로 Spring Bean을 구분하기 위한
		//식별자(beanName)을 전달받아 스프링 컨테이넌로부터 Spring Bean(객체)를 반환하는 메소드
		// => Object 타입의 객체를 반환하므로 반드시 명시적 객체 형변환 사용
		// => 매개변수로 전달받은 식별자(beanName)의 Spring Bean이 없는 경우 NoSuchBeanDefinitionException 발생
		//BeanFactory를 사용하는것 보다 이벤트 초기화 작업 등 더 많은 기능을 제공
		CreateBean bean2 = (CreateBean)factory.getBean("createBean");
		bean2.display();
		
		//ClassPathXmlApplicaiotnContext.close() : ApplicationContext 객체를 제거하는 메소드
		// => 스프링 컨테이너가 소멸되기 전에 스프링 컨테이너에 의해 관리되는 모든 객체(Spring Bean)를 자동 소멸
		// => Garbage Collector가 알아서 지워주기 때문에 작성하지 않아도 괜찮음
		((ClassPathXmlApplicationContext)context).close();
	}
}
