package xyz.itwill04.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Spring Boot���� ����ϴ� ���
// => xml ������ ������� �ʰ� ������̼��� �̿�


//@Configuration : ������ �����̳ʿ� ���� ������ ��ü(Spring Bean)�� �����Ͽ� ��ȯ�ϴ� �޼ҵ尡
//����� Ŭ������ �����ϱ� ���� ������̼�
// => Ŭ������ Spring Bean Configuration File�� ������ ����� ������ �� �ֵ��� �����ϴ� ������̼�
@Configuration 
public class AnnotationConfigurationBean {
	
	//@Bean : Ŭ������ ��ü�� �����Ͽ� ��ȯ�ϴ� �޼ҵ忡 �����ϴ� ������̼� - @Configuration �ȿ��� ���Ǿ�� �̱��� ����
	// => @Bean ������̼��� ����� �޼ҵ尡 ��ȯ�� ��ü�� ������ �����̳ʿ� ���� ���� - Spring Bean
	// => Spring Bean Configuration File�� bean ������Ʈ�� ������ ����� �����ϴ� ������̼�
	// => �޼ҵ��� �̸��� Spring Bean�� �ĺ���(beanName)�� ���
	// => @Bean ������̼��� name �Ӽ��� �̿��Ͽ� �ĺ���(beanName) ���� ����
	// => ex) @Bean(name = "annotation")
	@Bean
	public AnnotationBean annotationBean() {
		return new AnnotationBean();
	}
}
