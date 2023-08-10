package xyz.itwill07.aop;

public class ExecutionTimeBean {
	public void one() {
		//횡단관심코드
		//System.currentTimeMillis() : 시스템의 현재 날짜와 시간에 대한 타임스탬프를 반환하는 메소드
		//타임스템프(TimeStamp) : 날짜와 시간에 대한 연산을 목적으로 날짜와 시간을 정수값으로 변환한 값
		//long startTime=System.currentTimeMillis();
		long count=0;
		for(long i=1;i<=10000000000L;i++) {
			count++;
		}
		long endTime=System.currentTimeMillis();
		
		//횡단관심코드
		System.out.println("count = "+count);
		//System.out.println("ExecutionTimeBean 클래스의 one() 매소드 실행 시간 = "+(endTime-startTime));
	}
	
	public void two() {
		long count=0;
		for(long i=1;i<=20000000000L;i++) {
			count++;
		}
		long endTime=System.currentTimeMillis();
		System.out.println("count = "+count);
	}
}
