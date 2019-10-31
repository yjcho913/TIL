package com.scsa.JAVA20191031;

import java.util.Arrays;

public class ArraySortTest {
	public static void main(String[] args) {
		
		int []num = {10, 1, 20, 9, 5};
		Arrays.sort(num);
		for (int i = 0; i < num.length; i++) {
			System.out.println("num["+i+"] = "+num[i]);
		}
		System.out.println("===============");
		
		
		// ���� ���� : �ƽ�Ű �ڵ� ��
		// ��ҹ��ڰ� ���� �ִٸ�, �빮�ڰ� �켱
		char []ch = {'j','a','v','a','c','l','a','s','s'};
		Arrays.sort(ch);
		for (int i = 0; i < ch.length; i++) {
			System.out.println("ch["+i+"] = "+ch[i]);
		}
		System.out.println("===============");
		
		
		String []names = {"KIM", "LEE", "PARK", "CHOI", "CHO"};
		Arrays.sort(names);
		for (int i = 0; i < names.length; i++) {
			System.out.println("names["+i+"] = "+names[i]);
		}
		System.out.println("===============");
	}
}
