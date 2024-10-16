package xyz.itwill.dao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//SqlSessionFactory 객체를 생성하여 반환하는 기능을 제공하는 클래스
// => 매퍼를 사용하는 모든 DAO 클래스가 상속받기 위한 부모 클래스
// => 상속을 목적으로 작성된 클래스이므로 추상클래스로 선언하는 것을 권장
public abstract class AbstractSession {
	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		String resource="mybatis-config.xml";
		
		InputStream inputStream=null;
		try {
			inputStream=Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
		
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	//protected : 상속받은 자식이 접근 가능한 메소드
	protected SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
}
