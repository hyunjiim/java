package xyz.itwill08.dao;

import java.util.List;

import lombok.Setter;

public class StudentServiceImpl implements StudentService {
	//StudentDAO 인터페이스를 상속받은 자식클래스의 객체를 저장하기 위한 필드
	// => Spring Bean Configuration File에서 Service 클래스를 Spring Bean으로 등록할 때 StudentService
	//인터페이스를 상속받은 자식클래스의 Spring Bean을 제공받아 의존성 주입 - Setter Injection
	@Setter
	private StudentDAO studentDAO;

	@Override
	public void addStudent(Student student) {
		studentDAO.insertStudent(student);
	}

	@Override
	public void modifyStudent(Student student) {
		studentDAO.updateStudent(student);
	}

	@Override
	public void removeStudent(int no) {
		studentDAO.deleteStudent(no);
	}

	@Override
	public Student getStudent(int no) {
		return studentDAO.selectStudent(no);
	}

	@Override
	public List<Student> getStudentList() {
		return studentDAO.selectStudentList();
	}

}
