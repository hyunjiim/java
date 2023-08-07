package xyz.itwill09.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Model ����� �����ϴ� Ŭ������ �ݵ�� ��ӹ޾ƾ� �Ǵ� �������̽�
// => ��� Model ����� Ŭ������ ������ �޼ҵ尡 �ۼ��ǵ��� ��Ģ ������
// => Controller���� Model ����� Ŭ������ ��û ó�� �޼ҵ带 ���� ȣ���Ͽ� ���
public interface Controller {
	//��� Model ����� Ŭ�������� �ݵ�� �ۼ��� ��û ó�� �޼ҵ带 �߻�޼ҵ�� ����
	String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;
	
}
