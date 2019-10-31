package com.scsa.JAVA20191031;

public class ArrayProblem {

	public static void main(String[] args) {
		
		int [] num = {1, 2, 3, 4, 5};

//		 *** ���� 4 ***
//		 num = {1, 2, 3, 4, 5};
//		 num3 �̶�� �迭�� ���Ӱ� ���� num �迭�� ���� �����Ͻÿ�.
//		int [] num3 = num;	// �ּ� ���� --> num3�� �� �����ϸ�, num�� ����
		
		int [] num3 = new int [num.length];
		for (int i = 0; i < num3.length; i++) {
			num3[i] = num[i];
		}
		
		
//		 *** ���� 5 ***
//		 num �迭�� for���� ���� [0]���� ~ [4]���� ������� ��
//		 5 4 3 2 1 �� ���� �ǵ��� ����Ͻÿ�.
//		 [0] <--> [4]
//		 [1] <--> [3]
		
		int tmp;
		System.out.println("*** ���� 5 ***");
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
		
		
//		 *** ���� 6 ***
//		 num �迭�� Ȧ�������� ����Ͻÿ�.
		
		System.out.println("*** ���� 6 ***");
		for (int i = 0; i < num.length; i++) {
			if(i%2 == 1) System.out.print(i+" ");
		}
		System.out.println();
		System.out.println("===============");
		
		
//		 *** ���� 7 ***
//		 num �迭�� Ȧ���� ����Ͻÿ�.
		
		System.out.println("*** ���� 7 ***");
		for (int i = 0; i < num.length; i++) {
			if(num[i]%2 == 1) System.out.print(num[i]+" ");
		}
		System.out.println();
		System.out.println("===============");
	}
}
