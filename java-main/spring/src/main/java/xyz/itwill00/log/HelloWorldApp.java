package xyz.itwill00.log;

public class HelloWorldApp {
	public static void main(String[] args) {
		//�α� ����ü�� ������� �ʾƵ� System.out.println()�� ����Ͽ� Ȯ�� ����
		//Ŭ������ �ٲ�� �ٲ�� �Ѵٴ� ��, �ڵ� ������ ���� �ð��� �þ�ٴ� ������ ��ȿ����
		System.out.println("HelloWorldAapp Ŭ������ main �޼ҵ� - ����");
		System.out.println("HelloWorldAapp Ŭ������ main �޼ҵ� - ����");
		HelloWorld hw=new HelloWorld();
		String message=hw.hello("ȫ�浿");
		System.out.println("message = "+message);
		System.out.println("HelloWorldAapp Ŭ������ main �޼ҵ� - ����");
	}
}
