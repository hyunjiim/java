package xyz.itwill.access;

public class PrivateMemberUSe {
	public void run() {
		@SuppressWarnings("unused")
		PrivateMember member=new PrivateMember();
		
		//member.num=100;
		//member.display();
	}
}
