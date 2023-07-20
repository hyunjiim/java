package xyz.itwill.dto;

public class MyReplyUser {
	/*
	private int replyNo;
	private String replyId;
	private String replyContent;
	private String replyDate;
	private int replyCommentNo;
	*/
	private MyReply reply;
	
	/*
	private String userId;
	private String userName;
	*/
	private MyUser user;
	
	public MyReplyUser() {
		// TODO Auto-generated constructor stub
	}

	public MyReply getReply() {
		return reply;
	}

	public void setReply(MyReply reply) {
		this.reply = reply;
	}

	public MyUser getUser() {
		return user;
	}

	public void setUser(MyUser user) {
		this.user = user;
	}
	
	
}
