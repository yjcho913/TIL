package com.scsa.JAVA20191029;

import java.io.IOException;

public class InputTest {
	public static void main(String[] args) throws IOException {
		System.out.println("�� �ڸ� ���� �Է����ּ��� :");
		int su = System.in.read() - 48;
		System.in.read();	// 13
		System.in.read();	// 10 --> ����� ��!!
		
		System.out.println("���� ���� �ٽ� �Է����ּ��� :");
		int su2 = System.in.read();
		
		System.out.println("�Է��� ���� "+su+"�̰� �� ���� �ƽ�Ű�ڵ�� "+su2+"�Դϴ�");
		
		System.out.println((char)65);
	}
}
