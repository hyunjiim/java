package xyz.itwill04.bean;

import org.springframework.stereotype.Component;

//@Component: Ŭ������ ������ �����̳ʰ� �����ϴ� ��ü(Spring Bean)���� ����ϴ� ������̼�
// => Ŭ������ �̸��� Spring Bean�� �����ϴ� �ĺ���(beanName)�� ��� -  ù��° ���ڴ� �ҹ��ڷ�
// => @Component ������̼��� value �Ӽ��� ����Ͽ� �ĺ���(beanName) ���� ���� - value �Ӽ����� ������ ��� �Ӽ����� ���� ����

//XML�̳� Configuration ������Ʈ ��� ����: ���̺귯���� �������� ������ Spring Bean���� ����ϰ� ���� ��� 
@Component("bean")
public class ComponentAnnotationBean {
	public ComponentAnnotationBean() {
		System.out.println("### ComponentAnnotationBean Ŭ������ �⺻ ������ ȣ�� ###");
	}
	
	public void display() {
		System.out.println("*** ComponentAnnotationBean Ŭ������ display() �޼ҵ� ȣ�� ***");
	}
	
}
