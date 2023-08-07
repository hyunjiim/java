package xyz.itwill.lang.thread;

public class AccountUserApp {
	public static void main(String[] args) {
		//Account 클래스로 객체를 생성하여 저장 - 은행계좌 생성
		Account account=new Account(10000); //잔액:10000원
		/*
		//단일 스레드(main)를 이용하여 AccountUser 클래스로 객체 생성해 저장
		//=>은행계좌를 사용하는 사용자를 여러개 생성하여 같은 은행계좌를 사용하도록 설정
		AccountUser one = new AccountUser(account,"홍길동");
		AccountUser two = new AccountUser(account,"임꺽정");
		AccountUser three = new AccountUser(account,"전우치");
		
		//단일 스레드(main)를 이용하여 은행계좌 사용자를 이용한 은행계좌의 입금 처리
		one.getAccount().deposit(5000, one.getUserName());
		two.getAccount().deposit(5000, two.getUserName());
		three.getAccount().deposit(5000, three.getUserName());
		*/
		
		//스레드를 여러개 생성하여 동시에 입금(출금) 처리
		//새로운 스레드를 생성하여 run() 메소드의 명령 실행- 입금처리
		new AccountUser(account, "홍길동").start();
		new AccountUser(account, "임꺽정").start();
		new AccountUser(account, "전우치").start();
	}
}
