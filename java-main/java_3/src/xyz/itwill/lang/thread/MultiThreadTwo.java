package xyz.itwill.lang.thread;

//Thread를 상속받은 것이 아니므로 Thread 객체 생성 불가능
//Thread.start() 메소드 사용 불가
public class MultiThreadTwo implements Runnable {
	@Override
	public void run() {
		for(char i='0';i<='9';i++) {
			System.out.print(i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
