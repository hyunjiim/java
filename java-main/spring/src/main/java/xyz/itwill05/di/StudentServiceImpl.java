package xyz.itwill05.di;

import java.util.List;

//���յ��� ���� �������� ȿ���� ���� - Ŭ������ �ƴ� �������̽��� ���� ����/���� ���� ����


//Service Ŭ���� : ���α׷� ���࿡ �ʿ��� ������ ó�� ����� �����ϴ� Ŭ���� - ���۳�Ʈ
//DAO Ŭ������ �ϳ��� �� ����,����,����,�˻��ϴ� ��ɸ��� ����
// => Service�� ���� ������ ó�� ����� ����ϴ� Ŭ����
// => Service Ŭ������ �޼ҵ�� �ټ��� DAO ��ü�� �޼ҵ带 ȣ���Ͽ� �ۼ� - DAO ���ȭ
// => Service Ŭ������ �޼ҵ忡�� DAO ��ü�� ����ϱ� ���� DAO Ŭ������ ���԰���(��������)�� ���� - TV/������
// => ���԰���(��������)�� �����ϱ� ���� ���� �ʵ带 ���
// => Service��  ����ŵ� Service Ŭ������ ����ϴ� Ŭ����(Controller - Model)�� ������ �ּ�ȭ
//�ϱ� ���� �ݵ�� �������̽��� ��ӹ޾� �ۼ� - ���յ��� ���� ���������� ȿ���� ����
public class StudentServiceImpl implements StudentService {
	//StudentJdbcDAO Ŭ������ �ʵ� ���� : Ŭ������ Ŭ������ ���������� ���� ���� - StudentJdbcDAO ��ü�� ���� ������ �ʵ�
	// => �ʵ忡 StudentJdbcDAO ��ü�� �����ؾ߸� ���԰���(��������)�� �ϼ�
	// => StudentServiceImpl Ŭ������ �޼ҵ忡�� �ʵ忡 ����� ��ü�� StudentJdbcDAO ��ü�� �޼ҵ� ȣ��
	//������)���� StudentJdbcDAO�� �ƴ� �ٸ� DAO Ŭ������ ����/���� ���踦 �����Ѵٸ�?
	// => DAO Ŭ������ ����� ��� Service Ŭ������ �ʵ� �� �޼ҵ� ���� ����
	// => ���յ��� ���� ���������� ȿ���� ����
	//private StudentJdbcDAO studentJdbcDao;
	
	
	//StudentDAO �������̽��� �ʵ� ���� - StudentDAO �������̽��� ��ӹ��� �ڽ�Ŭ������ ������ ��ü�� ���� ������ �ʵ�
	// => �ʵ忡 StudentDAO �������̽��� ��ӹ��� DAO Ŭ������ ��ü�� �����ؾ߸� ���԰���(��������) ����
	// => StudentServiceImpl Ŭ������ �޼ҵ忡�� �������̽��� ������ �ʵ��� �߻�޼ҵ带 ȣ���Ͽ�
	//�ʵ忡 ����� �ڽ�Ŭ���� ��ü�� �޼ҵ� ȣ�� - �������̵��� ���� ������
	// => DAO Ŭ������ ����ŵ� Service Ŭ������ ���� �ּ�ȭ - ���յ��� ���� �������� ȿ���� ����
	private StudentDAO studentDAO;
	
	public StudentServiceImpl() {
		System.out.println("### StudentServiceImpl Ŭ������ �⺻ ������ ȣ�� ###");
	}
	
	public StudentServiceImpl(StudentDAO studentDAO) {
		System.out.println("### StudentServiceImpl Ŭ������ �Ű������� ����� ������ ȣ�� ###");
	}

	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
		System.out.println("*** StudentServiceImpl Ŭ������ setStudentDAO(StudentDAO studentDAO) �޼ҵ� ȣ�� ***");
	}

	//�ʵ忡 ��ü�� ����Ǿ� ���� ������ NullPointerException �߻�
	@Override
	public void addStudent(Student student) {
		System.out.println("*** StudentServiceImpl Ŭ������ setStudentDAO(StudentDAO studentDAO) �޼ҵ� ȣ�� ***");
		studentDAO.insertStudent(student);
	}

	@Override
	public void modifyStudent(Student student) {
		System.out.println("*** StudentServiceImpl Ŭ������ modifyStudent(StudentDAO studentDAO) �޼ҵ� ȣ�� ***");
		studentDAO.updateStudent(student);
	}

	@Override
	public void removeStudent(int num) {
		System.out.println("*** StudentServiceImpl Ŭ������ removeStudent(int num) �޼ҵ� ȣ�� ***");
		studentDAO.deleteStudent(num);
	}

	@Override
	public Student getStudent(int num) {
		System.out.println("*** StudentServiceImpl Ŭ������ getStudent(int num) �޼ҵ� ȣ�� ***");
		return studentDAO.selectStudent(num);
	}

	@Override
	public List<Student> getStudentList() {
		System.out.println("*** StudentServiceImpl Ŭ������ getStudentList() �޼ҵ� ȣ�� ***");
		return studentDAO.selectStudentList();
	}

}
