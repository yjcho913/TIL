package com.scsa.JAVA20191029;

/*
(���� 2) ȭ�鿡 �Ʒ��� ���� ����Ͻÿ�. (���� for��)
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