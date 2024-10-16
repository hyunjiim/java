package xyz.itwill.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentMapApp {
	public static void main(String[] args) {
		//List객체마다 학생 정보 추가
		List<Student> studentListOne=new ArrayList<Student>();
		studentListOne.add(new Student(1000,"홍길동"));
		studentListOne.add(new Student(2000,"임꺽정"));
		studentListOne.add(new Student(3000,"전우치"));
		studentListOne.add(new Student(4000,"일지매"));
		studentListOne.add(new Student(5000,"장길산"));
		
		List<Student> studentListTwo=new ArrayList<>();
		studentListTwo.add(new Student(6000,"유재석"));
		studentListTwo.add(new Student(7000,"강호동"));
		studentListTwo.add(new Student(8000,"신동엽"));
		studentListTwo.add(new Student(9000,"김용만"));
		
		//key-Integer, value-List 객체
		Map<Integer, List<Student>> studentListMap=new HashMap<>();
		studentListMap.put(1, studentListOne);   //key 1에 studentListOne이라는 List 객체를 저장
		studentListMap.put(2, studentListTwo);   //key 2에 studentListTwo이라는 List 객체를 저장
		
		for(Integer ban: studentListMap.keySet()) {
			System.out.println(ban+"반의 학생정보 >> ");
			
			List<Student> studentList = studentListMap.get(ban);
			for(Student student:studentList) {
				System.out.println(student);
			}
			
			System.out.println();
		}
	}
}
