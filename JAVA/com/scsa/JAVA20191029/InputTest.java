package com.scsa.JAVA20191029;

import java.io.IOException;

public class InputTest {
	public static void main(String[] args) throws IOException {
		System.out.println("한 자리 수를 입력해주세요 :");
		int su = System.in.read() - 48;
		System.in.read();	// 13
		System.in.read();	// 10 --> 빼줘야 함!!
		
		System.out.println("같은 수를 다시 입력해주세요 :");
		int su2 = System.in.read();
		
		System.out.println("입력한 수는 "+su+"이고 그 수의 아스키코드는 "+su2+"입니다");
		
		System.out.println((char)65);
	}
}
