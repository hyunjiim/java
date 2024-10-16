package xyz.itwill.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import xyz.itwill.dto.MyMember;
import xyz.itwill.mapper.MyMemberInterfaceMapper;

//XML파일 기반의 매퍼파일보다 Interface 기반의 매퍼파일로 DAO를 만드는게 더 편리

// => XML 파일 기반의 매퍼파일은 엘리먼트를 불러와 DAO를 작성해야 하는데 
//자동완성 기능이 없음 -  이름을 잘못 작성했을 경우 에러 발생
// => SELECT 명령은 단일행, 다중행에 따라 다른 메소드를 호출해야 함 - 메소드를 잘못 호출하면 에러 발생

//Interface 기반의 매퍼파일을 사용한 DAO는 자동완성 기능을 제공하여 오타가 발생할 확률이 적음
//=> 추상메소드를 호출하여 만들기 때문에 더 자바스러운 코딩이 가능하다
public class MyMemberInterfaceDAO {
private static MyMemberInterfaceDAO _dao;
	
	private MyMemberInterfaceDAO() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_dao=new MyMemberInterfaceDAO();
	}
	
	public static MyMemberInterfaceDAO getDAO() {
		return _dao;
	}
	
	//SqlSessionFactory 객체를 생성하여 반환하는 메소드
	private SqlSessionFactory getSqlSessionFactory() {
		String resource="mybatis-config.xml";
		
		InputStream inputStream=null;
		try {
			inputStream=Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
		
		return new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	//회원정보를 전달받아 MYMEMBER 테이블의 회원정보로 삽입하고 삽입행의 갯수를 반환하는 메소드
	public int insertMember(MyMember member) {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			//SqlSession.getMapper(Class<T> clazz) : 매개변수에 메모리에 저장된 인터페이스
			//(Class 객체 - Clazz)를 전달받아 Mapper 객체로 생성하여 반환하는 메소드
			// => 매개변수에 [XXX.class] 형식으로 인터페이스를 Class 객체로 직접 표현하여 전달
			//MyMemberInterfaceMapper.class는 Clazz 객체임
			//Mapper 객체 : 인터페이스 기반의 매퍼 파일을 제공받아 Mapper 객체로 생성되며
			//추상메소드를 호출하여 추상메소드에 등록된 SQL 명령을 DBMS 서버에 전달하여 
			//실행하고 실행결과를 Java 객체로 매핑하여 반환하는 기능을 제공하는 객체
			return sqlSession.getMapper(MyMemberInterfaceMapper.class).insertMember(member);
		} finally {
			sqlSession.close();
		}
	}
	
	//회원정보를 전달받아 MYMEMBER 테이블에 저장된 회원정보를 변경하고 변경행의 갯수를 반환하는 메소드
	public int updateMember(MyMember member) {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			return sqlSession.getMapper(MyMemberInterfaceMapper.class).updateMember(member);
		} finally {
			sqlSession.close();
		}
	}
	
	//아이디를 전달받아 MYMEMBER 테이블에 저장된 회원정보를 삭제하고 삭제행의 갯수를 반환하는 메소드
	public int deleteMember(String id) {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			return sqlSession.getMapper(MyMemberInterfaceMapper.class).deleteMember(id);
		} finally {
			sqlSession.close();
		}
	}

	
	//아이디를 전달받아 MYMEMBER 테이블에 저장된 회원정보를 검색하여 DTO 객체로 반환하는 메소드
	public MyMember selectMember(String id) {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			return sqlSession.getMapper(MyMemberInterfaceMapper.class).selectMember(id);
		} finally {
			sqlSession.close();
		}
	}

	//MYMEMBER 테이블에 저장된 모든 회원정보를 검색하여 List 객체로 반환하는 메소드
	public List<MyMember> selectMemberList() {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			return sqlSession.getMapper(MyMemberInterfaceMapper.class).selectMemberList();
		} finally {
			sqlSession.close();
		}
	}
}
