package xyz.itwill05.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentApp {
	public static void main(String[] args) {
		System.out.println("================ Spring Container �ʱ�ȭ �� ================");
		ApplicationContext context=new ClassPathXmlApplicationContext("05-1_di.xml");
		System.out.println("================ Spring Container �ʱ�ȭ �� ================");
		Student student1=context.getBean("student1", Student.class);
		//���������� ����� ��� ���������� ����� toString() �޼ҵ� �ڵ� ȣ�� - ��ü�� �ʵ尪 Ȯ��
		System.out.println(student1); //���: �й� = 0 �̸� = null �̸��� = null
		System.out.println("==============================================================");
		Student student2=context.getBean("student2", Student.class);
		System.out.println(student2); //���: �й� = 1000 �̸� = null �̸��� = null
		// => VO Ŭ������ ������ �Ű������� �ִ� �����ڿ� ���ڿ� �Ű������� �ִ� �����ڰ� �ִ°�� ���ڿ� �Ű������� 1000�� �����
		//�й� = 0 �̸� = 1000 �̸��� = null
		// => String�� �켱���� �־� �̸��� 1000���� => �Ű������� ������ ���� �����ڴ� �ۼ����� �ʵ���! - constructor-arg ������Ʈ�� type �Ӽ��� int�� �������ָ� �ذ�
		System.out.println("==============================================================");
		
		Student student3=context.getBean("student3", Student.class);
		System.out.println(student3); //���: �й� = 1000 �̸� = null �̸��� = null
		System.out.println("==============================================================");
		Student student4=context.getBean("student4", Student.class);
		System.out.println(student4);
		System.out.println("==========================================================");
		Student student5=context.getBean("student5", Student.class);
		System.out.println(student5);
		System.out.println("==========================================================");
		Student student6=context.getBean("student6", Student.class);
		System.out.println(student6);
		System.out.println("==========================================================");
		//���α׷� ���࿡ �ʿ��� ������ ó�� ����� �����ϴ� Sercive ��ü�� �����޾� ����
		//StudentServiceImpl service=context.getBean("studentServiceImpl", StudentServiceImpl.class);
		
		//Ŭ������ ��������(�ʵ�)�� �����Ͽ� �����ϴ� �ͺ��� �������̽��� ��������(�ʵ�)��
		//�����Ͽ� ��ü�� �����ϴ� ���� �������� ȿ������ �����ϴ� ���
		StudentService service=context.getBean("studentServiceImpl", StudentService.class);
		
		//Service ��ü�� �޼ҵ带 ȣ���Ͽ� ������ ó�� ��� ����
		// => java.lang.NullPointerException �߻�
		// => ServiceImple�� �޼ҵ忡 �ִ� studentDAO�� ��ü�� ����Ǿ� ���� �ʱ� ���� - �������� �������� ����
		service.addStudent(student1);
		service.modifyStudent(student1);
		service.removeStudent(1000);
		service.getStudent(2000);
		service.getStudentList();
		System.out.println("==========================================================");
		((ClassPathXmlApplicationContext)context).close();
		
	}
}
