package com.scsa.JAVA20191031;

public class ArrayProblem {

	public static void main(String[] args) {
		
		int [] num = {1, 2, 3, 4, 5};

//		 *** 문제 4 ***
//		 num = {1, 2, 3, 4, 5};
//		 num3 이라는 배열을 새롭게 만들어서 num 배열의 값을 복사하시오.
//		int [] num3 = num;	// 주소 복사 --> num3의 값 변경하면, num도 변경
		
		int [] num3 = new int [num.length];
		for (int i = 0; i < num3.length; i++) {
			num3[i] = num[i];
		}
		
		
//		 *** 문제 5 ***
//		 num 배열을 for문을 통해 [0]번지 ~ [4]번지 출력했을 때
//		 5 4 3 2 1 과 같이 되도록 출력하시오.
//		 [0] <--> [4]
//		 [1] <--> [3]
		
		int tmp;
		System.out.println("*** 문제 5 ***");
		for (int i = 0, j = num.length - 1; i < j; i++, j--) {
			tmp = num[i];
			num[i] = num[j];
			num[j] = tmp;
		}
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i]+" ");
		}
		System.out.println();
		System.out.println("===============");
		
		
//		 *** 문제 6 ***
//		 num 배열의 홀수번지를 출력하시오.
		
		System.out.println("*** 문제 6 ***");
		for (int i = 0; i < num.length; i++) {
			if(i%2 == 1) System.out.print(i+" ");
		}
		System.out.println();
		System.out.println("===============");
		
		
//		 *** 문제 7 ***
//		 num 배열의 홀수값 출력하시오.
		
		System.out.println("*** 문제 7 ***");
		for (int i = 0; i < num.length; i++) {
			if(num[i]%2 == 1) System.out.print(num[i]+" ");
		}
		System.out.println();
		System.out.println("===============");
	}
}
