package xyz.itwill05.di;

import java.util.List;

//학생정보를 처리하는 DAO 클래스가 반드시 상속받아야 되는 인터페이스
// => 객체와 객체가 직접적으로 관계를 맺어 하나의 객체를 변경할 때 관계를 맺고 있는 클래스까지 고치지
//않도록 인터페이스를 사용
// => 객체 간의 결합도를 낮춰 유지보수의 효율성 증가
public interface StudentDAO {
	//DAO 클래스가 사용해야하는 추상메소드
	int insertStudent(Student student);
	int updateStudent(Student student);
	int deleteStudent(int num);
	Student selectStudent(int num);
	List<Student> selectStudentList();
}
