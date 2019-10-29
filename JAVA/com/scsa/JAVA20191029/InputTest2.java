package com.scsa.JAVA20191029;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputTest2 {
	public static void main(String[] args) throws IOException {
		//라인 단위 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("입력해주세요");		// 123 입력
		String str = br.readLine();
		System.out.println("입력받은 문자열은 "+str+"입니다.");
		
		System.out.println(str + 100);			// 123100 출력
		// parseInt : 숫자로 변환하는 기능 ("" 제거)
		int su = Integer.parseInt(str);
		System.out.println(su + 100);			// 223 출력
	}
}