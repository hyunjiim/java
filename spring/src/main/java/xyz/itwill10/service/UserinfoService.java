package xyz.itwill10.service;

import java.util.List;

import xyz.itwill10.dto.Userinfo;
import xyz.itwill10.exception.ExistsUserinfoException;
import xyz.itwill10.exception.LoginAuthFailException;
import xyz.itwill10.exception.UserinfoNotFoundException;

public interface UserinfoService {
	//아이디가 중복될 때 인위적 예외처리 : [xyz.itwill10.exception] 패키지에 예외처리 클래스 작성
	void addUserinfo(Userinfo userinfo) throws ExistsUserinfoException;
	//변경할 회원이 없는 경우 인위적 예외 발생 
	void modifyUserinfo(Userinfo userinfo) throws UserinfoNotFoundException;
	//삭제할 회원이 없는 경우 인위적 예외 발생 
	void removeUserinfo(String userid) throws UserinfoNotFoundException;
	//검색할 회원이 없는 경우 인위적 예외 발생 
	Userinfo getUserinfo(String userid) throws UserinfoNotFoundException;
	List<Userinfo> getUserinfoList();
	//로그인 인증을 진행할 때 인증에 실패할 경우 인위적 예외 발생
	Userinfo loginAuth(Userinfo userinfo) throws LoginAuthFailException; //로그인 시 인증하기 위한 메소드
}
