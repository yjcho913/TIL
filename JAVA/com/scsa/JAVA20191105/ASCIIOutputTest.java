package com.scsa.JAVA20191105;

public class ASCIIOutputTest {
	public static void main(String[] args) {
		for (int i = 32; i < 127; i++) {
			System.out.write(i);
			// (�ƽ�Ű�ڵ�) ���ڿ� ���ε� ���� ���
			if(i%8 == 7) System.out.write('\n');
			else System.out.write('\t');
		}
		
		// '~' ���
		System.out.flush();
	}
}