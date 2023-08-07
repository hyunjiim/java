package xyz.itwill.mapper;

import java.util.List;

import xyz.itwill.dto.MyMember;

public interface MyMemberMapper {
	int insertMember(MyMember mymember);
	int updateMember(MyMember mymember);
	int deleteMember(String id);
	MyMember selectMember(String id);
	List<MyMember> selectMemberList();
}
