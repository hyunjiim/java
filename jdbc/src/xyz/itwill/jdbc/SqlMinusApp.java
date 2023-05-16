//[33day-과제]
package xyz.itwill.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

//키보드로 SQL 명령을 입력받아 DBMS 서버에 전달하여 실행하고 실행결과를 출력하는 JDBC 프로그램 작성
// => 키보드로 INSERT,UPDATE,DELETE,SELECT 명령만 입력받아 실행되도록 작성
// => SQL 명령은 [exit] 명령을 입력하기 전까지 반복적으로 입력받아 실행 - 대소문자 미구분
// => 입력받은 SQL 명령이 잘못된 경우 에러 메세지 출력
public class SqlMinusApp {
	public static void main(String[] args) throws Exception {
		// 키보드로 SQL 명령을 입력받기 위한 입력스트림 생성
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		Connection con = ConnectionFactory.getConnection();
		Statement stmt = con.createStatement(); // 반복처리하는 경우 PrepareStatement 보다 Statement를 사용하는게 더 효율적
		ResultSet rs = null;
		String sql = "";

		System.out.println("SQLMinus 프로그램을 실행합니다.(종료 : exit)");

		while (true) {
			// 키보드로 SQL 명령을 입력받아 저장
			System.out.print("SQL> ");
			// 키보드로 입력받은 문자열의 앞과 뒤에 존재하는 모든 공백을 제거한 후 변수에 저장
			sql = in.readLine().trim();

			// 키보드 입력값이 없는 경우 반복문을 처음부터 다시 실행
			if (sql == null || sql.equals(""))
				continue;

			// 키보드 입력값이 [exit]인 경우 반복문 종료 - 프로그램 종료
			// String.equalsIgnoreCase(String str): str과 문자열이 같은 경우 - 대소문자 구분하지 않음
			if (sql.equalsIgnoreCase("exit"))
				break;

			// 입력받은 SQL 명령을 전달하여 실행하고 실행결과를 반환받아 출력

			try {
				if (stmt.execute(sql)) {// SELECT 명령이 전달되어 실행된 경우
					rs = stmt.getResultSet();

					if(rs.next()) { //검색행이 있는 경우
						ResultSetMetaData rsmd=rs.getMetaData();
						
						//검색행의 컬럼의 갯수를 반환받아 저장
						int columnCount = rsmd.getColumnCount();
						
						//검색행의 컬럼명을 반환받아 출력
						for(int i=1;i<=columnCount;i++) {
							System.out.print(rsmd.getColumnLabel(i)+"\t");
						}
						System.out.println();
						System.out.println("==========================================");
						do {
							for(int i=1;i<=columnCount;i++) {
								String columnValue=rs.getString(i);
								//컬럼의 자료형이 DATE인 경우
								if(rsmd.getColumnTypeName(i).equals("DATE")) {
									//[yyyy-MM-dd] 형식의 문자열로 분리하여 저장
									columnValue=columnValue.substring(0, 10);
								}
								if(columnValue==null) { //컬럼값이 없는 경우
									columnValue="";
								}
								System.out.print(columnValue+"\t");
							}
							System.out.println();
						}while(rs.next());
						
					}else { //검색행이 없는 경우
						System.out.println("[메세지]검색된 결과가 없습니다.");
					}
				} else {// DML 명령 또는 DDL 명령이 전달되어 실행된 경우
					int rows = stmt.getUpdateCount();
					System.out.println("[메세지]" + rows + "개의 행을 "+sql.substring(0,6).toUpperCase()+"하였습니다.");
				}

			} catch (SQLException e) { // 전달되어 실행된 SQL 명령이 잘못된 경우
				System.out.println("[SQL 오류] "+e.getMessage());
			}
		}

		ConnectionFactory.close(con, stmt, rs);
		System.out.println("SQLMinus 프로그램을 종료합니다.");
	}
}