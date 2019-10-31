package com.scsa.JAVA20191031;

import java.util.Arrays;
import java.util.Random;

/*

<<����� �ζǹ�ȣ ������>>
1. ���� ��ġ�� �ʴ� (�ߺ����� �ʴ�) ���� 6�� ����
2. �� ���ڴ� 1~45 �������� ����
3. �Ź� ����� �ٸ� ���� ���
   ---> ������ : RandomŬ���� - nextInt(int bound)��� 
4. �ټ�ȸ ���
5. �� ��ȣ�� �������� ����
   ---> ArraysŬ������ sort()�޼ҵ� ���.
   
�������)

  �ڡ� ���� ����� �ζǹ�ȣ �ڡ�
 1ȸ: 2, 12, 15, 34, 36, 42
 2ȸ: 1, 2, 9, 33, 42, 45
 3ȸ: 9, 12, 14, 19, 34, 40
 4ȸ: 5, 10, 15, 18, 19, 22
 5ȸ: 7, 9, 15, 19, 39, 41

*/
public class LottoTest {
	
	   int [] lotto;
	   boolean [] visited;
	   Random r;
	   
	   public LottoTest() {
		  lotto = new int[6];
		  visited = new boolean[46];
		  r = new Random();
	   }
	   
	   public void generateNum() {
		  for (int i = 0; i < lotto.length; i++) {
			 lotto[i] = r.nextInt(45)+1;
			 if(visited[lotto[i]]) i--;
			 else visited[lotto[i]] = true;
		  } 
	   }
	   
	   public void printNum() {
		  Arrays.sort(lotto); 
		  for (int i = 0; i < lotto.length; i++) {
			System.out.print(lotto[i]);
			if(i<lotto.length-1)System.out.print(", ");
		  }
	   }
	   
		
	   public static void main(String[] args) {
		   
		   System.out.println("�ڡ� ���� ����� �ζǹ�ȣ �ڡ�");
		   
		   for(int i=1; i<=5; i++)
		   {
			   System.out.print(i + "ȸ: ");
			   LottoTest lotto = new LottoTest();
			   lotto.generateNum();
			   lotto.printNum();
			   System.out.println();
		   }
	   }
}