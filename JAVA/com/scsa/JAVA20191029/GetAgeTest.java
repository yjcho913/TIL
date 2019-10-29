package com.scsa.JAVA20191029;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

public class GetAgeTest {
	public static void main(String[] args) throws IOException {
		// 콘솔을 통해 주민번호를 입력받고, 그에 해당되는 나이를 화면 출력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("주민번호를 입력해주세요");
		String str = br.readLine();
		
		// 나이 계산
		int subyear = 1900;
		String birth = str.substring(0, 2);
		if(str.charAt(7) >= '3') subyear = 2000;
		
		// 현재 연도 계산
		// 날짜 관련 class : Date, Calendar
		// Calendar : 추상 클래스 --> new를 하지 못함!
		Calendar cal = Calendar.getInstance();
		int curyear = cal.get(Calendar.YEAR);
		
		int age = curyear - Integer.parseInt(birth) - subyear + 1;
		System.out.println("당신의 나이는 "+age+"세 입니다.");
	}
}