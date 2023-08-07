package xyz.itwill.team_02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//ProtectedEndAnimals DAO 클래스-PROTECTED_END_ANIMALS테이블
public class ProtectedEndAnimalsDAOImpl extends JdbcDAO implements ProtectedEndAnimalsDAO {
	
	private static ProtectedEndAnimalsDAOImpl _dao;
	
	public ProtectedEndAnimalsDAOImpl() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_dao=new ProtectedEndAnimalsDAOImpl();
		
	}
	
	public static ProtectedEndAnimalsDAOImpl getDAO() {
		return _dao;
	}
	
	//1. 보호종료동물 정보를 전달받아 PROTECTED_END_ANIMALS 테이블에 삽입하고 삽입행의 갯수를 반환하는 메소드
	@Override
	public int insertProtectedEndAnimal(ProtectedEndAnimalsDTO proEndAnimal) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		
		try {
			con=getConnection();
			
			String sql="insert into protected_end_animals values(?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, proEndAnimal.getAnimalName());
			pstmt.setString(2, proEndAnimal.getAnimalKind());
			pstmt.setString(3, proEndAnimal.getGender());
			pstmt.setInt(4, proEndAnimal.getAge());
			pstmt.setString(5, proEndAnimal.getReason());
			
			rows=pstmt.executeUpdate();
					
		}catch (SQLException e) {
			System.out.println("[에러]insertProtectedEndAnimal() 메소드의 SQL 오류 : "+e.getMessage());
		}finally {
			close(con, pstmt);
		}
		
		return rows;
	}
	
	//2. 잘못 삽입된 보호종료동물 이름을 전달받아 PROTECTED_END_ANIMALS 테이블에 저장된 동물정보를 삭제하고 삭제행의 갯수를 반환하는 메소드
	@Override
	public int deleteProtectedEndAnimal(ProtectedEndAnimalsDTO proEndAnimal) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		try {
			con=getConnection();
			
			String sql="delete from protected_end_animals where animal_name=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, proEndAnimal.getAnimalName());
			
			rows=pstmt.executeUpdate();
		}catch (SQLException e) {
			System.out.println("[에러]deleteProtectedEndAnimal() 메소드의 SQL 오류 = "+e.getMessage());

		}finally {
			close(con, pstmt);
		}
		return rows;
	}

}
