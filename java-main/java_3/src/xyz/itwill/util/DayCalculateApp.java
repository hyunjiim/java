package xyz.itwill.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

//키보드로 생년월일을 입력받아 오늘까지 살아온 날짜(일)을 계산하여 출력하는 프로그램 작성
//ex) 생년월일 입력[ex) 2000-01-01] >> 2023-04-15
//    [결과]태어난지 <1일>이 지났습니다.
//=>형식에 맞지 않는 생년월일을 입력한 경우 에러 메세지 출력 후 프로그램 종료
public class DayCalculateApp {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		System.out.print("생년월일 입력[ex) 2000-01-01] >> ");
		String birth = scanner.nextLine();
		
		try {
			Date birthFormat=dateFormat.parse(birth);
			long currentTime=System.currentTimeMillis();
			long birthTime=birthFormat.getTime();
			System.out.println("[결과]태어난지 <"+(currentTime-birthTime)/(1000*86400)+"일>이 지났습니다.");
		}catch(ParseException e) {
	         System.out.println("[에러]형식에 맞게 날짜와 시간을 입력해주세요.");
	         System.exit(0);
		}
	}

}
