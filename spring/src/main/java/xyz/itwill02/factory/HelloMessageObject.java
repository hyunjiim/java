package xyz.itwill02.factory;

//xyz.itwill01.old ��Ű���� HiMessageObject, HelloMessageObject�� ��ü ������
//�����ڰ� �ƴ� Factory���� ��� �Ͽ� ���յ��� ���ߴ� ���

//Factory Ŭ������ �������� ��ü�� ����ŵ� �޼ҵ�� ������� �ʵ��� �ݵ�� �������̽��� ��ӹ޾� �ۼ�
public class HelloMessageObject implements MessageObject {

	@Override
	public String getMessage() {
		return "Hello!!!";
	}

}
