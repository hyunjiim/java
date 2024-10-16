package xyz.itwill.service;

import java.sql.SQLException;
import java.util.List;

import xyz.itwill.dao.UserinfoModelTwoDAO;
import xyz.itwill.dto.UserinfoDTO;
import xyz.itwill.exception.AuthFailException;
import xyz.itwill.exception.ExistsUserinfoException;
import xyz.itwill.exception.UserinfoNotFoundException;

//모델이 다양한 DAO 클래스들을 가져다 쓰는 것이 아니라 다수의 DAO 클래스를 호출한 Service 클래스만을
//불러와 사용할 수 있도록 함 - 레파지토리 클래스

//Service 클래스 : 모델 클래스의 요청 처리 메소드에서 데이터 처리 기능을 메소드로 제공하기 위한 클래스
// => 단위 프로그램(모듈 프로그램) : 컴퍼넌트(Component)
// => 다수의 DAO 클래스의 메소드를 호출하여 데이터 처리에 필요한 기능을 제공 - DAO 모듈화 처리
// => 데이터 처리 기능 구현시 발생되는 모든 문제에 대한 인위적 예외 발생 - 모델 클래스에서 예외 처리
public class UserinfoService {
	private static UserinfoService _service;
	
	private UserinfoService() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_service=new UserinfoService();
	}
	
	public static UserinfoService getService() {
		return _service;
	}
	
	//회원정보를 전달받아 USERINFO 테이블에 회원정보를 삽입하는 메소드
	// => 매개변수로 전달받은 회원정보의 아이디가 USERINFO 테이블에 저장된 기존 회원정보의
	//아이디와 중복될 경우 인위적 예외 발생
	public void addUserinfo(UserinfoDTO userinfo) throws SQLException, ExistsUserinfoException {
		if(UserinfoModelTwoDAO.getDAO().selectUserinfo(userinfo.getUserid())!=null) {
			//사용자 정의 예외클래스를 이용하여 인위적 예외 발생
			throw new ExistsUserinfoException("이미 사용중인 아이디를 입력 하였습니다.");
		}
		UserinfoModelTwoDAO.getDAO().insertUserinfo(userinfo);
	}
	
	//회원정보를 전달받아 USERINFO 테이블에 저장된 회원정보를 변경하는 메소드
	// => 매개변수로 전달받은 회원정보가 USERINFO 테이블에 없는 경우 인위적 예외 발생
	public void modifyUserinfo(UserinfoDTO userinfo) throws SQLException, UserinfoNotFoundException {
		if(UserinfoModelTwoDAO.getDAO().selectUserinfo(userinfo.getUserid())==null) {
			throw new UserinfoNotFoundException("회원정보가 존재하지 않습니다.");
		}
		UserinfoModelTwoDAO.getDAO().updateUserinfo(userinfo);
	}

	//아이디를 전달받아 USERINFO 테이블에 저장된 회원정보를 삭제하는 메소드
	// => 매개변수로 전달받은 아이디의 회원정보가 USERINFO 테이블에 없는 경우 인위적 예외 발생
	public void removeUserinfo(String userid) throws SQLException, UserinfoNotFoundException {
		if(UserinfoModelTwoDAO.getDAO().selectUserinfo(userid)==null) {
			throw new UserinfoNotFoundException("회원정보가 존재하지 않습니다.");
		}
		UserinfoModelTwoDAO.getDAO().deleteUserinfo(userid);
	}
	
	//아이디를 전달받아 USERINFO 테이블에 저장된 회원정보를 검색하여 DTO 객체로 반환하는 메소드
	// => 매개변수로 전달받은 아이디의 회원정보가 USERINFO 테이블에 없는 경우 인위적 예외 발생
	public UserinfoDTO getUserinfo(String userid) throws SQLException, UserinfoNotFoundException {
		UserinfoDTO userinfo=UserinfoModelTwoDAO.getDAO().selectUserinfo(userid);
		if(userinfo==null) {
			throw new UserinfoNotFoundException("회원정보가 존재하지 않습니다.");
		}
		return userinfo;
	}
	
	//USERINFO 테이블에 저장된 모든 회원정보를 검색하여 List 객체로 반환하는 메소드
	public List<UserinfoDTO> getUserinfoList() throws SQLException {
		return UserinfoModelTwoDAO.getDAO().selectUserinfoList();
	}
	
	//로그인정보(아이디와 비밀번호)를 전달받아 인증 처리하는 메소드
	// => 인증 실패시 인위적 예외 발생 - 예외가 발생하지 않은 경우 인증 성공
	public void auth(String userid, String password) throws SQLException, AuthFailException {
		UserinfoDTO userinfo=UserinfoModelTwoDAO.getDAO().selectUserinfo(userid);
		if(userinfo==null || !userinfo.getPassword().equals(password)) {
			throw new AuthFailException("입력된 아이디가 잘못 되었거나 비밀번호가 맞지 않습니다.");
		}
	}
}