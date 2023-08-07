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
//@AllArgsConstructor : ��� �ʵ忡 ���� �ʱ�ȭ ������ ������ �����ڸ� �����ϴ� ������̼�����,
//@RequiredArgsConstructor : final �����ڸ� ����Ͽ� �ۼ��� �ʵ忡 ���� �ʱ�ȭ ������ ������ �����ڸ� �����ϴ� ������̼�
// => final ������ ��� @NonNull ������̼��� ����� �ʵ忡 ���� ������ ����
// => @AllArgsConstructor ���� @RequiredArgsConstructor ������̼��� ����ϴ� ���� ����
@RequiredArgsConstructor
@Service("memberService")
public class MemberServiceImpl implements MemberService {
	//�ʵ忡 @Autowired ������̼��� ����Ͽ� ������ ���� - �ʵ� ������ ������ ����
	// => �ʵ忡 Setter �޼ҵ尡 ��� �ʵ忡 ������ ���� ����
	// => ���� �������� ������ ���� ��������� ��ȯ ������ ������ �߻����� �ʾ� StackOverflow �߻� ����
	//@Autowired
	//private final MemberDAO memberDAO;
	// => final ������ ��� @NonNull ��� ����
	//@RequiredArgsConstructor ������̼����� ������ �����ڷ� �ʱ�ȭ ó���ϱ� ���� �ʵ�
	@NonNull
	private MemberDAO memberDAO;
	
	/*
	//�ʵ忡 ���� Setter �޼ҵ忡 @Autowired ������̼��� ����Ͽ� ������ ���� - Setter ������ ������ ����
	// ������)Setter �޼ҵ��� ���� �����ڰ� [public]�� ��� Setter �޼ҵ带 ���� ȣ���Ͽ� �������� ���� ����
	@Autowired
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO=memberDAO;
	}
	*/
	
	/*
	public MemberServiceImpl() {
		log.info("MemberServiceImpl Ŭ������ �⺻������ ȣ��");
	}
	*/

	//�Ű������� ���޹��� ��ü�� �ʵ忡 �������� �����ϴ� �����ڿ� @Authowired ������̼���
	//����Ͽ� ������ ���� - Constructor ������ ������ ����
	// => Spring �����ӿ�ũ������ ��ȯ ���� ������ ���� �����ڸ� �̿��� ������ ���� ����
	// => �Ű������� ����� �����ڸ� �ϳ��� �ۼ��� ���(�⺻�����ڸ� �������� �ʰ� �Ű����� �����ڸ� �ۼ��� ���)
	//@Authowired ������̼� ���� ���� - ����
	//@Autowired
	/*
	public MemberServiceImpl(MemberDAO memberDAO) {
		this.memberDAO=memberDAO;
		log.info("MemberServiceImpl Ŭ������ �⺻������ ȣ��");
	}
	*/
	
	@Override
	public void addMember(Member member) {
		log.info("MemberServiceImpl Ŭ������ addMember() �޼ҵ� ȣ��");
		memberDAO.insertMember(member);
	}

	@Override
	public void modifyMember(Member member) {
		log.info("MemberServiceImpl Ŭ������ modifyMember() �޼ҵ� ȣ��");
		memberDAO.updateMember(member);
	}

	@Override
	public void removeMember(String id) {
		log.info("MemberServiceImpl Ŭ������ removeMember() �޼ҵ� ȣ��");
		memberDAO.deleteMember(id);
		
	}

	@Override
	public Member getMember(String id) {
		log.info("MemberServiceImpl Ŭ������ getMember() �޼ҵ� ȣ��");
		return memberDAO.selectMember(id);
	}

	@Override
	public List<Member> getMemberList() {
		log.info("MemberServiceImpl Ŭ������ getMemberList() �޼ҵ� ȣ��");
		return memberDAO.selectMemberList();
	}
}
