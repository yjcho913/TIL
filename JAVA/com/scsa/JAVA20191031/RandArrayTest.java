package com.scsa.JAVA20191031;

import java.util.Random;

// �迭 �ȿ� ������ ���� ����

public class RandArrayTest {
	// �迭 ����
	int []num;
	Random r;
	
	public RandArrayTest() {
//		num = {1, 2, 3, 4, 5};	// ���� (�ʱ�ȭ�� ����� ���ÿ�!)
		
		
		num = new int[5];		// int []num = {0,0,0,0,0};
								// num : �ּҰ��� ���� ���۷��� ����
//		num = new int[] {1, 2, 3, 4, 5};	// int [] num = {1, 2, 3, 4, 5};
		
		r = new Random();
	}

	
	public void printArray() {
		for (int i = 0; i < num.length; i++) {
			System.out.println("num["+i+"] = "+num[i]);
		}
		System.out.println("===============");
	}
	
	
	/*
	 < JAVA�� ���� ��>
	 1. java.lang.Math -----> random()
	 	0.0 ~ 0.999999
	 	
	 2. java.util.Random ---> nextInt(), nextDouble()
	 	- ������ random()���� �� ����
	 	- nextInt(int bound)
	 	- 0 ~ bound - 1
	 */
	public void inputArray() { // ������ ���� �迭�� �Է�
		for (int i = 0; i < num.length; i++) {
			
//			Math : Ŭ���� �̸����� ���� --> static method
//			num[i] = (int)(Math.random()*1000);
			
			num[i] = r.nextInt(101);
		}
	}
	
	public void sortArray() { // SIMPLE SORT
		int tmp;
		
		for (int i = 0; i < num.length - 1; i++) {
			for (int j = i+1; j < num.length; j++) {
				if(num[i] > num[j]) {
					tmp = num[i];
					num[i] = num[j];
					num[j] = tmp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		RandArrayTest rat = new RandArrayTest();
		// �ʱⰪ�� 0�� ���� Ȯ�� ����
		rat.printArray();
		
		rat.inputArray();
		rat.printArray();
		
		rat.sortArray();
		rat.printArray();
	}
}
