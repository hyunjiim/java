package xyz.itwill07.aop;

public class ExecutionTimeBean {
	public void one() {
		//Ⱦ�ܰ����ڵ�
		//System.currentTimeMillis() : �ý����� ���� ��¥�� �ð��� ���� Ÿ�ӽ������� ��ȯ�ϴ� �޼ҵ�
		//Ÿ�ӽ�����(TimeStamp) : ��¥�� �ð��� ���� ������ �������� ��¥�� �ð��� ���������� ������ ��
		//long startTime=System.currentTimeMillis();
		
		long count=0;
		for(long i=1;i<=10000000000L;i++) {
			count++;
		}
		long endTime=System.currentTimeMillis();
		
		//Ⱦ�ܰ����ڵ�
		//System.out.println("count = "+count);
		//System.out.println("ExecutionTimeBean Ŭ������ one() �޼ҵ� ���� �ð� = "+(endTime-startTime));
	}
	
	public void two() {
		//long startTime=System.currentTimeMillis();
		long count=0;
		for(long i=1;i<=20000000000L;i++) {
			count++;
		}
		long endTime=System.currentTimeMillis();
		System.out.println("count = "+count);
		//System.out.println("count = "+count);
		//System.out.println("ExecutionTimeBean Ŭ������ two() �޼ҵ� ���� �ð� = "+(endTime-startTime));
	}
}
