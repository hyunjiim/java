package xyz.itwill.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import xyz.itwill.dto.MyReply;
import xyz.itwill.dto.MyReplyUser;
import xyz.itwill.mapper.MyReplyMapper;

public class MyReplyDAO extends AbstractSession {
	public static MyReplyDAO _dao;
	
	public MyReplyDAO() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_dao=new MyReplyDAO();
	}
	
	public static MyReplyDAO getDAO() {
		return _dao;
	}
	
	public int insertReply(MyReply reply) {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			return sqlSession.getMapper(MyReplyMapper.class).insertReply(reply);
		}finally {
			sqlSession.close();
		}
	}
	
	public List<MyReply> selectReplyList(){
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			return sqlSession.getMapper(MyReplyMapper.class).selectReplyList();
		}finally {
			sqlSession.close();
		}
	}
	
	public List<MyReply> selectCountReplyList(){
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			return sqlSession.getMapper(MyReplyMapper.class).selectCountReplyList();
		}finally {
			sqlSession.close();
		}
	}

	public List<MyReplyUser> selectReplyUserList1(){
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			return sqlSession.getMapper(MyReplyMapper.class).selectReplyUserList1();
		}finally {
			sqlSession.close();
		}
	}
	
	public List<MyReplyUser> selectReplyUserList2(){
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			return sqlSession.getMapper(MyReplyMapper.class).selectReplyUserList2();
		}finally {
			sqlSession.close();
		}
	}
}
