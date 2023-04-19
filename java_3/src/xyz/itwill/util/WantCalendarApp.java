package xyz.itwill.util;

import java.util.Calendar;
import java.util.Scanner;

//키보드로 [년]과 [월]을 입력받아 해당 년월에 대한 달력을 출력하는 프로그램 작성
public class WantCalendarApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("연도를 입력하세요 >> ");
		String wantYear = scanner.nextLine();
		System.out.print("월을 입력하세요 >> ");
		String wantMonth = scanner.nextLine();

		// calendar.set(Calendar.DATE, 1);

		Calendar calendar = Calendar.getInstance();

		calendar.set(Calendar.YEAR, Integer.parseInt(wantYear));
		calendar.set(Calendar.MONTH, Integer.parseInt(wantMonth) - 1);
		calendar.set(Calendar.DATE, 1);

		// Calendar 객체에 저장된 날짜와 시간 중 [요일]을 반환받아 저장
		int week = calendar.get(Calendar.DAY_OF_WEEK);
//				System.out.println("week: "+week);

		System.out.println("         " + calendar.get(Calendar.YEAR) + "년 " + (calendar.get(Calendar.MONTH) + 1) + "월");
		System.out.println("==============================");
		System.out.println("  일  월  화  수  목  금  토");
		System.out.println("==============================");

		// [1일]을 출력하기 전까지의 요일을 공백으로 출력
		for (int i = 1; i < week; i++) {
			System.out.print("    ");
		}

		// 1일부터 [월]의 마지막 일까지 출력
		// Calendar.getActualMaximum(int field): Calnedar 객체에 저장된 날짜와 시간에서 매개변수로 전달받은
		// 상수에 대한 최대값을 반환하는 메소드
		for (int i = 1; i <= calendar.getActualMaximum(Calendar.DATE); i++) {
			if (i <= 9) {
				System.out.print("   " + i);
			} else {
				System.out.print("  " + i);
			}

			week++;

			if (week % 7 == 1) { // 다음 출력값(일)이 일요일인 경우
				System.out.println();

			}
		}
		System.out.println();
		System.out.println("==============================");

	}

}
