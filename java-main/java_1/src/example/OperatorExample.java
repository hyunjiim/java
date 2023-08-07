package example;

public class OperatorExample {
	public static void main(String[] args) {
		
		//245678초를 일시분초 형식으로 변환하여 출력하세요.
		int time = 245678;
		int day = time/(24*3600);    
		int hour= (time-(day*24*3600))/3600;
		int min = (time-(hour*3600)-(day*24*3600))/60;
		int sec= (time-(hour*3600)-(day*24*3600))%60;	
		System.out.println(day+"일 "+hour+"시 "+min+"분 "+sec+"초");
		
		
		/*강사님 코딩(더 간결)
		 * int time = 245678;
		 * int day = time/(24*3600);   
		 * time%=86400; 
		 * int hour= time/3600;
		 * time%=3600;
		 * int min = time/60;
		 * int sec= time%60;	
		 * System.out.println(day+"일 "+hour+"시 "+min+"분 "+sec+"초");
		 */

		System.out.println("===============================================");
		
		//한대의 가격이 1억 5천원만인 비행기를 20대 구매할 경우 지불해야될 금액을 계산하여 출력하세요. 
		//단, 15대 이상 구매할 경우 1대당 25%의 할인율을 적용하여 계산하세요.
		 int plane = 150000000;
		 int cnt = 20;
		 long pay =(long)(cnt>15?plane*0.75:plane)*cnt;
		 System.out.println("비행기 "+cnt+"대의 가격= "+pay);

		System.out.println("===============================================");
		
		/*강사님 코딩
		 * int plane = 150000000;
		 * int cnt = 20;
		 * long pay =(long)(cnt>15?plane*0.75:plane)*cnt;
		 * System.out.println("비행기 "+cnt+"대의 가격= "+pay);
		 */
	}
}
