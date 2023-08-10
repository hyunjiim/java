package xyz.itwill10.exception;

//회원정보 변경, 삭제, 검색할 때 사용자로부터 전달받은 아이디의 회원정보가 없는 경우
public class UserinfoNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public UserinfoNotFoundException() {
	}
	
	public UserinfoNotFoundException(String messgae) {
		super(messgae);
	}
	
	
}
