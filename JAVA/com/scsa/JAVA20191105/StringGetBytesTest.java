package com.scsa.JAVA20191105;

public class StringGetBytesTest {
	public static void main(String[] args) {
		String str= "hi java stream!!!";
		byte[] b = str.getBytes();
		
		for (int i = 0; i < b.length; i++) {
//			System.out.write(int b);
			System.out.write(b[i]);
			// 개행을 해야, 출력
			if(i % 3 == 2) System.out.write('\n');
		}
		
		// 3글자 단위로 쓰기 때문에 뒤에 ! 2개는 출력되지 않음
		// flush를 통해 나머지 출력!!
		// flush --> 버퍼를 비워주는 역할
		System.out.flush();
	}
}
