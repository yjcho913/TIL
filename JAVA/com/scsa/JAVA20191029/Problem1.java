package com.scsa.JAVA20191029;

import java.util.Calendar;

// 화면에 아래와 같이 현재 시간을 출력하시오.
// 2019년 10월 29일 15시 55분 32초 (화요일)

public class Problem1 {
	public static void main(String[] args) {
		String days[] = {".", "일", "월", "화", "수", "목", "금", "토"};
		Calendar cal = Calendar.getInstance();
		String day = days[cal.get(Calendar.DAY_OF_WEEK)];
		System.out.println(cal.get(Calendar.YEAR)+"년 " + 
				(cal.get(Calendar.MONTH)+1)+"월 " + 
				cal.get(Calendar.DAY_OF_MONTH)+"일 " + 
				cal.get(Calendar.HOUR_OF_DAY)+"시 " + 
				cal.get(Calendar.MINUTE)+"분 " + 
				cal.get(Calendar.SECOND)+"초 " + 
				"("+day+"요일)" );
	}
}
