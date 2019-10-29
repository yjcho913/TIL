package com.scsa.JAVA20191029;

/*
 public class System{
  	static InputStream in;	--> new 없이 class명을 활용하여 직접적으로 접근 가능
  	static PrintStream out;
 	static PrintStream err;
 }
 */

/*
문제1) 다음과 같이 화면에 출력하시오
  1
  2
  3
  4
  5

문제2) 다음과 같이 화면에 출력하시오
  5 4 3 2 1
  
문제3) 다음과 같이 화면에 출력하시오
  3 6 9
  
문제4) 다음과 같이 화면에 출력하시오
  [5,10,15,20]
 */

public class Mission1 {
	public static void main(String[] args) {
		// P1
		System.out.println("P1");
		for(int i=1; i<=5; i++) {
			System.out.println(i);
		}
		
		// P2
		System.out.println("P2");
		for(int i=5; i>=1; i--) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		// P3
		System.out.println("P3");
		for(int i=1; i<=3; i++) {
			System.out.print((i*3) + " ");
		}
		System.out.println();
		
		// P4
		System.out.println("P4");
		System.out.print("[");
		for(int i=1; i<=4; i++) {
			System.out.print(i*5);
			if(i!=4) System.out.print(",");
			else System.out.print("]");
		}
	}
}
