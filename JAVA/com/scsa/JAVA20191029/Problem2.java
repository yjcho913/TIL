package com.scsa.JAVA20191029;

/*
(문제 2) 화면에 아래와 같이 출력하시오. (다중 for문)
*
**
***
****
*/

public class Problem2 {
	public static void main(String[] args) {
		for(int i=1; i<=4; i++) {
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}