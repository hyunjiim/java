package xyz.itwill01.old;

public class MessagePrint {
	public void helloMessagePrint() {
		//new �����ڸ� ���� ��ü ���� ���� - ��ü �� ���յ��� �ſ� ����
		//HelloMessageObject Ŭ������ �ƴ� HiMessageObject Ŭ������ �޼ҵ带 ����ϰ� ������?
		// => HelloMessageObject�� �����ϴ� �ٸ� Ŭ������ ���� �� �����Ƿ� ������ �ۼ���
		//HelloMessageObject�� �ٲٱ� ���� ���ο� �޼ҵ带 �ٽ� ������ ��
		HelloMessageObject object=new HelloMessageObject();
		String message=object.getHelloMessage();
		System.out.println("message = "+message);
	}
	
	public void hiMessagePrint() {
		HiMessageObject object=new HiMessageObject();
		String message=object.getHiMessage();
		System.out.println("message = "+message);
	}
}
