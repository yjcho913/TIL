package com.scsa.JAVA20191105;

public class StringGetBytesTest {
	public static void main(String[] args) {
		String str= "hi java stream!!!";
		byte[] b = str.getBytes();
		
		for (int i = 0; i < b.length; i++) {
//			System.out.write(int b);
			System.out.write(b[i]);
			// ������ �ؾ�, ���
			if(i % 3 == 2) System.out.write('\n');
		}
		
		// 3���� ������ ���� ������ �ڿ� ! 2���� ��µ��� ����
		// flush�� ���� ������ ���!!
		// flush --> ���۸� ����ִ� ����
		System.out.flush();
	}
}
