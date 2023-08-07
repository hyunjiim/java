package xyz.itwill.access;

public class ProtectedMemberUse {
	public void run() {
		@SuppressWarnings("unused")
		ProtectedMember member=new ProtectedMember();
		
		member.num=100;
		member.display();
	}
}
