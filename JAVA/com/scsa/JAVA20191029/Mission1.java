package com.scsa.JAVA20191029;

/*
 public class System{
  	static InputStream in;	--> new ���� class���� Ȱ���Ͽ� ���������� ���� ����
  	static PrintStream out;
 	static PrintStream err;
 }
 */

/*
����1) ������ ���� ȭ�鿡 ����Ͻÿ�
  1
  2
  3
  4
  5

����2) ������ ���� ȭ�鿡 ����Ͻÿ�
  5 4 3 2 1
  
����3) ������ ���� ȭ�鿡 ����Ͻÿ�
  3 6 9
  
����4) ������ ���� ȭ�鿡 ����Ͻÿ�
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
