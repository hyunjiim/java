package xyz.itwill05.lombok;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

//�ʵ�, Setter ������ ������ ���Ժ��� ������ ������ ������ ���� ����!!!

@Slf4j

//@AllArgsConstructor : 모든 필드에 대한 초기화 설정이 가능한 생성자를 생성하는 어노테이션
//@AllArgsConstructor
//@RequiredArgsConstructor : final 제한자를 사용하여 작성된 필드에 대한 초기화 설정이 가능한 생성자를 생성하는 어노테이션
// => final 제한자 대신 @NonNull 어노테이션을 사용한 필드에 대한 생성자 생성
@RequiredArgsConstructor
@Service("memberService")
public class MemberServiceImpl implements MemberService {
	//필드에 @Autowired 어노테이션을 사용하여 의존성 주입 - 필드 레벨의 의존성 주입
	// => 필드에 Setter 메소드가 없어도 필드에 의존성 주입 가능
	// => 가장 보편적인 의존성 주입 방법이지만 순환 참조시 에러가 발생되지 않으 StackOverflow 발생 가능
	//순환참조문제?
	// => A클래스가 B클래스의 Bean을 주입받고, B클래스가 A클래스의 Bean을 주입받는 상황처럼
	//서로 순환되어 참조할 경우 발생하는 문제
	// => Setter Injection에서는 A클래스가 B클래스를 의존하고, B클래스가 A클래스를 의존하는
	//상황이더라도 애플리케이션 실행과정에서 예외가 발생하지 않음
	// => 두 클래스가 서로 순환참조하는 상황에서 해당 메소드가 호출되면 문제 발생
	//https://ch4njun.tistory.com/269
	//@Autowired
	//private MemberDAO memberDAO;
	
	//@RequireArgsConstructor 어노테이션으로 생성된 생성자로 초기화 처리하기 위한 필드
	//private final MemberDAO memberDAO;
	@NonNull private MemberDAO memberDAO;
	
	//필드에 대한 Setter 메소드에 @Autowired 어노테이션을 사용하여 의존성 주입 - Setter 레벨의 의존성 주입
	// => Setter 메소드의 접근 제한자가 [public]인 경우 Setter 메소드를 직접 호출하여 의존관계 변경 가능
	/*
	@Autowired
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO=memberDAO;
	}
	*/
	
	/*
	public MemberServiceimpl() {
		log.info("MemberServiceimpl 클래스의 기본 생성자 호출");
	}
	*/
	
	/*
	//매개변수로 전달받은 객체로 필드에 의존성 주입하는 생성자에 @Autowired 어노테이션을 
	//사용하여 의존성 주입 - Constructor 레벨의 의존성 주입
	// => Spring 프레임워크에서는 순환 참조 방지를 위해 생성자를 이용한 의존성 주입 권장
	// => 매개변수가 선언된 생성자를 하나만 작성한 경우 @Autowired 어노테이션 생략 가능
	//@Autowired
	public MemberServiceimpl(MemberDAO memberDAO) {
		this.memberDAO=memberDAO;
		log.info("MemberServiceimpl 클래스의 매개변수가 선언된 생성자 호출");
	}
	*/
	
	@Override
	public void addMember(Member member) {
		log.info("MemberServiceimpl 클래스의 addMember() 메소드 호출");
		memberDAO.insertMember(member);
	}

	@Override
	public void modifyMember(Member member) {
		log.info("MemberServiceimpl 클래스의 modifyMember() 메소드 호출");
		memberDAO.updateMember(member);
	}

	@Override
	public void removeMember(String id) {
		log.info("MemberServiceimpl 클래스의 removeMember() 메소드 호출");
		memberDAO.deleteMember(id);
	}

	@Override
	public Member getMember(String id) {
		log.info("MemberServiceimpl 클래스의 getMember() 메소드 호출");
		return memberDAO.selectMember(id);
	}

	@Override
	public List<Member> getMemberList() {
		log.info("MemberServiceimpl 클래스의 getMemberList() 메소드 호출");
		return memberDAO.selectMemberList();
	}
}
