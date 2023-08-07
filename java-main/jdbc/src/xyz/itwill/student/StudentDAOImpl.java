//[34day-8]-https://structuring.tistory.com/159

/* [DAO, DTO]
 * => 실행부분, DB에 접근하는 DAO, 데이터 전달용 DTO를 구분하여 각각의 역할 명료화
 * 
 * [DAO(Data Access Object)]
 * =>직접 DB에 접근하여 데이터를 삽입,삭제,변경,검색하는 기능을 수행하고 데이터를 실제 DB에 저장하는 클래스
 * =>데이터가 있는 저장소에 접근하는 유일한 객체
 * =>XXXDAO로 클래스명을 붙여 구분
 * =>파일 입출력 코드 클래스를 데이터 저장 형태의 파일로 보관
 * =>MVC패턴의 Model에서 이 같은 작업 수행
 * 
 * 
 * [DTO(Data Transfer Object)]
 * =>데이터 전달용 클래스
 * =>XXXDTO로 클래스명을 붙여 구분
 * =>DAO와 DB간의 데이터를 주고받는 클래스
 * =>로직을 가지지 않는 순수한 데이터 객체 - getter & setter만 가진 클래스
 * =>계층 간 데이터 교환을 하기 위해 사용하는 객체
 * =>사용자가 입력한 데이터를 DB에 넣는 과정
 *   1. 사용자가 자신의 브라우저에서 데이터를 입력하여 form에 있는 데이터를 DTO에 넣어 전송
 *   2. 해당 DTO를 받은 서버가 DAO를 이용하여 DB로 데이터 저장
 *   
 * [VO(Value Object)]
 * =>DTO와 혼용되어 사용
 * =>read-Only 특징이 있어 사용하는 도중에 변경 불가능하며 오직 읽기만 가능
 * =>DTO와 유사하지만 DTO는 setter를 가지고 있어 값 변경 가능
 * 
 * 
 * [DTO,DAO 코드 구현]
 * * DB에 접근하는 과정 호출 순서
 *  - 메인에서 DAO 호출 >> DAO에서 DB접근해 데이터를 가져옴 >> DTO에서 데이터를 받아 저장하기 위한 테이블 생성 >>
 *    >>DAO에서 전달받은 DTO를 사용해 DB로 저장(INSERT) 
 * 
 * *가장 먼저 DB에 테이블 생성
 * 
 * *메인 코드 - 사용자에게 입력받고 메소드를 호출하는 클래스
 *  1.사용자 입력을 받음
 *  2.DTO 객체 생성 & 입력값으로 초기화
 *  3.DAO 객체 생성
 *  4.DAO의 INSERT/DELETE/UPDATE/SELECT 메소드 호출해 DTO 객체 전달
 *  
 * *DAO 코드 - 데이터가 있는 DB에 접근하는 클래스
 *  1.JDBC 드라이버 로드
 *  2.DB에 연결
 *  3.SQL문 작성하여 DB에 전달
 *  4.DTO에서 변수들을 전달받아 SQL문 완성
 *  5.SQL문 실행
 *  6.DB 연결 해제
 *  
 * *DTO 코드 - 데이터 전달용 클래스
 *  -Getter & Setter 메소드 작성
 */

package xyz.itwill.student;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//DAO(Data Access Object) 클래스 : 저장매체에 행정보를 삽입,삭제,변경,검색하는 기능을 제공하는 클래스 - DB에 접근하기 위한 로직 분리
// => 저장매체 : 정보를 행단위로 저장하여 관리하기 위한 하드웨어 또는 소프트웨어 - DBMS
// => 인터페이스를 상속받아 작성하는 것을 권장 - 메소드 작성 규칙 제공 : 유지보수의 효율성 증가
// => 싱글톤 디자인 패턴을 적용하여 작성하는 것을 권장 - 프로그램에 하나의 객체만 제공되는 클래스

//STUDENT 테이블에 행을 삽입,삭제,변경,검색하는 기능의 메소드를 제공하는 클래스
// => DAO 클래스의 메소드는 SQL 명령에 필요한 값을 매개변수로 전달받아 하나의 SQL 명령을  
//    DBMS 서버에 전달하여 실행하고 실행결과를 Java 객체(값)로 매핑하여 반환
// => JdbcDAO 클래스를 상속받아 DAO 클래스의 메소드에서 JdbcDAO 클래스의 메소드 호출 가능
public class StudentDAOImpl extends JdbcDAO implements StudentDAO {
	private static StudentDAOImpl _dao;
	
	private StudentDAOImpl() {
		// TODO Auto-generated constructor stub
	}
	
	//정적 블록
	//=>클래스가 메모리로 로딩될 때 자동으로 실행
	//=>용도: 클래스 변수 초기화 코드를 둘떄
	static {
		_dao=new StudentDAOImpl();
	}
	
	public static StudentDAOImpl getDAO() {
		return _dao;
	}
	
	//학생정보를 전달받아 STUDENT 테이블에 삽입하고 삽입행의 갯수를 반환하는 메소드
	@Override
	public int insertStudent(StudentDTO student) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		try {
			//JdbcDAO의 getConnection() 메소드를 통해 PoolDataSource 객체에 저장된 Connection 객체 중 하나를 반환
			con=getConnection(); 
			
			String sql="insert into student values(?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, student.getNo());
			pstmt.setString(2, student.getName());
			pstmt.setString(3, student.getPhone());
			pstmt.setString(4, student.getAddress());
			pstmt.setString(5, student.getBirthday());
			
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]insertStudent() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}

	//학생정보를 전달받아 STUDENT 테이블에 저장된 학생정보를 변경하고 변경행의 갯수를 반환하는 메소드
	@Override
	public int updateStudent(StudentDTO student) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		try {
			con=getConnection();
			
			String sql="update student set name=?,phone=?,address=?,birthday=? where no=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, student.getName());
			pstmt.setString(2, student.getPhone());
			pstmt.setString(3, student.getAddress());
			pstmt.setString(4, student.getBirthday());
			pstmt.setInt(5, student.getNo());

			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]updateStudent() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}

	//학번을 전달받아 STUDENT 테이블에 저장된 학생정보를 삭제하고 삭제행의 갯수를 반환하는 메소드
	@Override
	public int deleteStudent(int no) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		try {
			con=getConnection();
			
			String sql="delete from student where no=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, no);

			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]deleteStudent() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}

	//학번을 전달받아 STUDENT 테이블에 저장된 해당 학번의 학생정보를 검색하여 반환하는 메소드
	@Override
	public StudentDTO selectStudent(int no) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		StudentDTO student=null;
		try {
			con=getConnection();
			
			String sql="select * from student where no=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			rs=pstmt.executeQuery();
			
			//ResultSet 객체에 저장된 검색행을 Java 객체(값)로 매핑 처리
			//검색행이 0 또는 1인 경우 선택문 사용
			if(rs.next()) {//검색행이 있는 경우
				student=new StudentDTO();
				//처리행의 컬럼값을 반환받아 DTO 객체의 필드값으로 변경
				student.setNo(rs.getInt("no"));
				student.setName(rs.getString("name"));
				student.setPhone(rs.getString("phone"));
				student.setAddress(rs.getString("address"));
				student.setBirthday(rs.getString("birthday").substring(0, 10));
			}
		} catch (SQLException e) {
			System.out.println("[에러]selectStudent() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		//검색행이 없는 경우 [null]를 반환하고 검색행이 있으면 DTO 객체 반환
		return student;
	}

	//이름을 전달받아 STUDENT 테이블에 저장된 해당 이름의 학생정보를 검색하여 반환하는 메소드
	@Override
	public List<StudentDTO> selectNameStudentList(String name) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<StudentDTO> studentList=new ArrayList<>();
		try {
			con=getConnection();
			
			String sql="select * from student where name=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, name);
			
			rs=pstmt.executeQuery();
			
			//검색행이 0개 이상인 경우 반복문 사용
			while(rs.next()) {
				//하나의 검색행을 DTO 객체로 매핑 처리
				StudentDTO student=new StudentDTO();
				student.setNo(rs.getInt("no"));
				student.setName(rs.getString("name"));
				student.setPhone(rs.getString("phone"));
				student.setAddress(rs.getString("address"));
				student.setBirthday(rs.getString("birthday").substring(0, 10));
				
				//DTO 객체를 List 객체의 요소로 추가 
				studentList.add(student);
			}
		} catch (SQLException e) {
			System.out.println("[에러]selectNameStudentList() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return studentList;
	}

	//STUDENT 테이블에 저장된 모든 학생정보를 검색하여 반환하는 메소드
	@Override
	public List<StudentDTO> selectAllStudentList() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<StudentDTO> studentList=new ArrayList<>();
		try {
			con=getConnection();
			
			String sql= "select * from student order by no";
			//String sql= "select no,name,phone,address,to_char(birthday,'yyyy-mm-dd') birthday from student order by no";
			pstmt=con.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				StudentDTO student=new StudentDTO();
				student.setNo(rs.getInt("no"));
				student.setName(rs.getString("name"));
				student.setPhone(rs.getString("phone"));
				student.setAddress(rs.getString("address"));
				//substring() 사용하기 보다는 sql select 문에 * 대신 컬럼명 나열하는게 좋음
				student.setBirthday(rs.getString("birthday").substring(0,10));
				//student.setBirthday(rs.getString("birthday"));
				
				studentList.add(student);
			}
			
		}catch (SQLException e) {
			System.out.println("[에러]selectNameStudentList() 메소드의 SQL 오류 = "+e.getMessage());
		}finally {
			close(con, pstmt, rs);
		}
		return studentList;
	}
	

}