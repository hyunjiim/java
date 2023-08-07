package xyz.itwill03.spring;

//Spring Container가 Factory 역할
public class HelloMessageObject implements MessageObject {
	@Override
	public String getMessage() {
		return "Hello!!!";
	}
}
