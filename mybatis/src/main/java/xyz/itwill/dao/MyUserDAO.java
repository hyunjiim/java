package xyz.itwill.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import xyz.itwill.dto.MyUser;
import xyz.itwill.mapper.MyUserMapper;

//효율성만을 극대화하여 만들다 보니 기본적인 객체지향 기법을 무시하고
//작성되었고 그래서 오히려 비효율적인 방법이 되기도 함
public class MyUserDAO extends AbstractSession {
	private static MyUserDAO _dao;
	
	public MyUserDAO() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_dao=new MyUserDAO();
	}
	
	public static MyUserDAO getDAO() {
		return _dao;
	}
	
	//SqlSessionFactory 객체를 생성하여 반환하는 메소드
	// => DAO를 만들때마다 중복 작성하였기 때문에 따로 클래스로 만들어 작성 - AbstractSession
	
	public int insertUser(MyUser user) {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			return sqlSession.getMapper(MyUserMapper.class).insertUser(user);
		} finally {
			sqlSession.close();
		}
	}
	
	public List<MyUser> selectUserList() {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			return sqlSession.getMapper(MyUserMapper.class).selectUserList();
		}finally {
			sqlSession.close();
		}
	}
}
