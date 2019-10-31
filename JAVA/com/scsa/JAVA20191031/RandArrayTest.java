package com.scsa.JAVA20191031;

import java.util.Random;

// 배열 안에 랜덤한 수를 저장

public class RandArrayTest {
	// 배열 선언
	int []num;
	Random r;
	
	public RandArrayTest() {
//		num = {1, 2, 3, 4, 5};	// 에러 (초기화는 선언과 동시에!)
		
		
		num = new int[5];		// int []num = {0,0,0,0,0};
								// num : 주소값을 갖는 레퍼런스 변수
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
	 < JAVA의 랜덤 수>
	 1. java.lang.Math -----> random()
	 	0.0 ~ 0.999999
	 	
	 2. java.util.Random ---> nextInt(), nextDouble()
	 	- 성능은 random()보다 더 좋음
	 	- nextInt(int bound)
	 	- 0 ~ bound - 1
	 */
	public void inputArray() { // 랜덤한 값을 배열에 입력
		for (int i = 0; i < num.length; i++) {
			
//			Math : 클래스 이름으로 접근 --> static method
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
		// 초기값이 0인 것을 확인 가능
		rat.printArray();
		
		rat.inputArray();
		rat.printArray();
		
		rat.sortArray();
		rat.printArray();
	}
}
