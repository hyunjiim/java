package xyz.itwill05.di;

import java.util.List;

//�л������� ó���ϴ� DAO Ŭ������ �ݵ�� ��ӹ޾ƾ� �Ǵ� �������̽�
// => ��ü�� ��ü�� ���������� ���踦 �ξ� �ϳ��� ��ü�� ������ �� ���踦 �ΰ� �ִ� Ŭ�������� ��ġ��
//�ʵ��� �������̽��� ���
// => ��ü ���� ���յ��� ���� ���������� ȿ���� ����
public interface StudentDAO {
	//DAO Ŭ������ ����ؾ��ϴ� �߻�޼ҵ�
	int insertStudent(Student student);
	int updateStudent(Student student);
	int deleteStudent(int num);
	Student selectStudent(int num);
	List<Student> selectStudentList();
}
