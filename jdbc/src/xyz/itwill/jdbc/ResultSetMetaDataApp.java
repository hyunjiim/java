//[33day-4]
package xyz.itwill.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetMetaDataApp {
	public static void main(String[] args) throws SQLException {
		Connection con=ConnectionFactory.getConnection();
		Statement stmt=con.createStatement();
		
		//String sql="select * from student order by no";
		String sql="select no,name from student order by no";
		ResultSet rs=stmt.executeQuery(sql);
		
		while(rs.next()) {
			System.out.println("학번 = "+rs.getInt("no")+", 이름 = "+rs.getString("name"));
		}
		System.out.println("==============================================================");
		//ResultSet.getMetaData() : 검색행(ResultSet 객체)에 대한 부가적인 정보(검색대상)가 
		//저장된 ResultSetMetaData 객체를 반환하는 메소드
		ResultSetMetaData rsmd=rs.getMetaData();
		
		//ResultSetMetaData.getColumnCount() : 검색행의 컬럼 갯수를 반환하는 메소드
	 	int columnCount=rsmd.getColumnCount();
	 	System.out.println("검색행의 컬럼 갯수 = "+columnCount);
		System.out.println("==============================================================");
		for(int i=1;i<=columnCount;i++) {//검색대상의 갯수만큼 반복 처리
			//ResultSetMetaData.getColumnLabel(int columnIndex) : 첨자 위치(columnIndex)의 
			//검색대상의 이름(컬럼명)을 반환하는 메소드
			String columnLabel=rsmd.getColumnLabel(i);
			
			//ResultSetMetaData.isNullable(int columnIndex) : 첨자 위치(columnIndex)의 컬럼에
			//대한 NULL 허용 유무값(0 또는 1)을 반환하는 메소드
			int isNull=rsmd.isNullable(i);
			String nullResult="NULL";
			//ResultSetMetaData.columnNoNulls : NULL를 허용하지 않는 상수 - 정수값 : 0 
			if(isNull==ResultSetMetaData.columnNoNulls) {
				nullResult="NOT NULL";
			}
			
			//ResultSetMetaData.isNullable(int columnIndex) : 첨자 위치(columnIndex)의 컬럼에
			//대한 오라클 자료형을 반환하는 메소드
			String columnTypeName=rsmd.getColumnTypeName(i);
			
			//ResultSetMetaData.getColumnDisplaySize(int columnIndex) : 첨자 위치(columnIndex)의 
			//컬럼에 대한 출력크기를 반환하는 메소드
			int columnDisplaySize=rsmd.getColumnDisplaySize(i);
			
			System.out.println("컬럼의 이름= "+columnLabel);
			System.out.println("NULL 허용 유무 = "+nullResult);
			System.out.println("컬럼의 자료형 = "+columnTypeName);
			System.out.println("컬럼의 출력크기 = "+columnDisplaySize);
			System.out.println("==============================================================");
		}
		ConnectionFactory.close(con, stmt, rs);
	}
}