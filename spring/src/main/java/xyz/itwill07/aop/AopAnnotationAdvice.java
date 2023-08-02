package xyz.itwill07.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
//@Aspect : �ٽɰ����ڵ忡 Ⱦ�ܰ����ڵ带 �����Ͽ� �����ϱ� ���� ����� �����ϴ� ������̼�
// => Spring Bean Configuration File�� aspect ������Ʈ�� ������ ��� ����
@Aspect
public class AopAnnotationAdvice {
	//@Pointcut : Ÿ�ٸ޼ҵ带 �����ϱ� ���� ������̼�
	// => �޼ҵ带 ȣ���Ͽ� Pointcut ǥ�������� ������ Ÿ�ٸ޼ҵ带 �����޾� �޾� ���
	// => Spring Bean Configuration File�� pointcut ������Ʈ�� ������ ��� ����
	//value �Ӽ� : Ÿ�ٸ޼ҵ带 �����ϱ� ���� Pointcut ǥ������ �Ӽ������� ����
	// => �ٸ� �Ӽ��� ���� ��� �Ӽ����� ���� ���� - within : ���ԵǴ� ��� �޼ҵ�
	@Pointcut("within(xyz.itwill07.aop.AopAnnotationBean)")
	public void aopPointCut() {}
	
	//@Before : Ÿ�ٸ޼ҵ��� �ٽɰ����ڵ� ���� �� ���ԵǾ� ����� Ⱦ�ܰ����ڵ带 �����ϱ� ���� ������̼� 
	// => Spring Bean Configuration File�� before ������Ʈ�� ������ ��� ����
	//value �Ӽ� : Ÿ�ٸ޼ҵ带 �����ϱ� ���� Pointcut ǥ������ �Ӽ������� ����
	// => @Pointcut ������̼��� ����� �޼ҵ� ȣ���Ͽ� Pointcut ǥ������ ���� �޾� ��� ����
	// => �ٸ� �Ӽ��� ���� ��� �Ӽ����� ���� ����
	//@Before("within(xyz.itwill07.aop.AopAnnotationBean)")
	@Before("aopPointCut()")
	public void beforeLog() {
		log.info("[before]�ٽɰ����ڵ� ���� ���� ���ԵǾ� ����� Ⱦ�ܰ����ڵ�");
	}
	
	//@After : Ÿ�ٸ޼ҵ��� �ٽɰ����ڵ� ���� �� �ݵ�� ���ԵǾ� ����� Ⱦ�ܰ����ڵ带 �����ϱ� ���� ������̼�
	// => Spring Bean Configuration File�� after ������Ʈ�� ������ ��� ����
	@After("aopPointCut()")
	public void afterLog() {
		log.info("[after]�ٽɰ����ڵ� ���� �� �ݵ�� ���ԵǾ� ����� Ⱦ�ܰ����ڵ�");
	}
	
	
	//@AfterReturning : Ÿ�ٸ޼ҵ��� �ٽɰ����ڵ尡 ���������� ����� �� ���ԵǾ� ����� Ⱦ�ܰ����ڵ带 �����ϱ� ���� ������̼�
	//returning �Ӽ� : Ÿ�ٸ޼ҵ��� ��ȯ���� ���޹޾� �����ϱ� ���� �Ű������� �̸��� �Ӽ������� ����
	@AfterReturning(value="aopPointCut()", returning = "object")
	public void afterReturningLog(Object object) {
		log.info("[after-returning]�ٽɰ����ڵ尡 ���������� ����� �� ���ԵǾ� ����� Ⱦ�ܰ����ڵ�");
	}
	
	
	//@AfterThrowing : Ÿ�ٸ޼ҵ��� �ٽɰ����ڵ� ����� ���ܰ� �߻��� �� ���ԵǾ� ����� Ⱦ�ܰ����ڵ带 �����ϱ� ���� ������̼�
	// => Spring Bean Configuration File�� after-throwing ������Ʈ�� ������ ��� ����
	//throwing �Ӽ� : Ÿ�ٸ޼ҵ忡�� �߻��� ���ܸ� ���޹޾� �����ϱ� ���� �Ű������� �̸��� �Ӽ������� ����
	@AfterThrowing(value="aopPointCut()", throwing="exception")
	public void afterThrowingLog(Exception exception) {
		log.info("[after-throwing]�ٽɰ����ڵ� ����� ���ܰ� �߻��Ǹ� ���ԵǾ� ����� Ⱦ�ܰ����ڵ�");
	}
	
	//@Around : Ÿ�ٸ޼ҵ��� �ٽɰ����ڵ� ���� ���� �Ŀ� ���ԵǾ� ����� Ⱦ�ܰ����ڵ带 �����ϱ� ���� ������̼�
	// => Spring Bean Configuration File�� around ������Ʈ�� ������ ��� ����
	@Around("aopPointCut()")
	public Object aroundLog(ProceedingJoinPoint joinPoint) throws Throwable {
		log.info("[around]�ٽɰ����� ���� ���� ���ԵǾ� ����� Ⱦ�ܰ����ڵ�");
		Object result=joinPoint.proceed();
		log.info("[around]�ٽɰ����� ���� �Ŀ� ���ԵǾ� ����� Ⱦ�ܰ����ڵ�");
	
		return result;
	}
}