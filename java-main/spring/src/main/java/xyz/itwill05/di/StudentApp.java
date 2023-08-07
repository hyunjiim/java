package xyz.itwill05.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentApp {
	public static void main(String[] args) {
		System.out.println("================ Spring Container 초기화 전 ================");
		ApplicationContext context=new ClassPathXmlApplicationContext("05-1_di.xml");
		System.out.println("================ Spring Container 초기화 후 ================");
		Student student1=context.getBean("student1", Student.class);
		//참조변수를 출력할 경우 참조변수에 저장된 toString() 메소드 자동 호출 - 객체의 필드값 확인
		System.out.println(student1); //결과: 학번 = 0 이름 = null 이메일 = null
		System.out.println("==============================================================");
		Student student2=context.getBean("student2", Student.class);
		System.out.println(student2); //결과: 학번 = 1000 이름 = null 이메일 = null
		// => VO 클래스에 정수값 매개변수가 있는 생성자와 문자열 매개변수가 있는 생성자가 있는경우 문자열 매개변수에 1000이 저장됨
		//학번 = 0 이름 = 1000 이메일 = null
		// => String에 우선권이 있어 이름에 1000저장 => 매개변수의 갯수가 같은 생성자는 작성하지 않도록! - constructor-arg 엘리먼트의 type 속성에 int로 설정해주면 해결
		System.out.println("==============================================================");
		
		Student student3=context.getBean("student3", Student.class);
		System.out.println(student3); //결과: 학번 = 1000 이름 = null 이메일 = null
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
		//프로그램 실행에 필요한 데이터 처리 기능을 제공하는 Sercive 객체를 제공받아 저장
		//StudentServiceImpl service=context.getBean("studentServiceImpl", StudentServiceImpl.class);
		
		//클래스로 참조변수(필드)를 생성하여 저장하는 것보다 인터페이스로 참조변수(필드)를
		//생성하여 객체를 저장하는 것이 유지보수 효율성을 증가하는 방법
		StudentService service=context.getBean("studentServiceImpl", StudentService.class);
		
		//Service 객체의 메소드를 호출하여 데이터 처리 기능 구현
		// => java.lang.NullPointerException 발생
		// => ServiceImple의 메소드에 있는 studentDAO에 객체가 저장되어 있지 않기 때문 - 의존관계 생성되지 않음
		service.addStudent(student1);
		service.modifyStudent(student1);
		service.removeStudent(1000);
		service.getStudent(2000);
		service.getStudentList();
		System.out.println("==========================================================");
		((ClassPathXmlApplicationContext)context).close();
		
	}
}
