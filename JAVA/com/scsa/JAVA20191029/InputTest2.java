package com.scsa.JAVA20191029;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputTest2 {
	public static void main(String[] args) throws IOException {
		//���� ���� �Է�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("�Է����ּ���");		// 123 �Է�
		String str = br.readLine();
		System.out.println("�Է¹��� ���ڿ��� "+str+"�Դϴ�.");
		
		System.out.println(str + 100);			// 123100 ���
		// parseInt : ���ڷ� ��ȯ�ϴ� ��� ("" ����)
		int su = Integer.parseInt(str);
		System.out.println(su + 100);			// 223 ���
	}
}