package com.scsa.JAVA20191105;

public class ASCIIOutputTest {
	public static void main(String[] args) {
		for (int i = 32; i < 127; i++) {
			System.out.write(i);
			// (아스키코드) 숫자에 매핑된 문자 출력
			if(i%8 == 7) System.out.write('\n');
			else System.out.write('\t');
		}
		
		// '~' 출력
		System.out.flush();
	}
}