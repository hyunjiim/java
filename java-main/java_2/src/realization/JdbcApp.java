package realization;

public class JdbcApp {
	public static void main(String[] args) {
		/*
		Jdbc mysql=new JdbcMysql();
		
		mysql.insert();
		mysql.update();
		mysql.delete();
		mysql.select();
		
		//
		//시스템 변경에 따른 클래스 교체시 메소드 호출 명령 변경
		//객체간의 
		JdbcOracle oracle=new JdbcOracle();
		
		oracle.add();
		oracle.modify();
		oracle.remove();
		oracle.search();
		*/
		Jdbc jdbc=new JdbcMysql();
		
		jdbc.insert();
		jdbc.update();
		jdbc.delete();
		jdbc.select();
	}
}
