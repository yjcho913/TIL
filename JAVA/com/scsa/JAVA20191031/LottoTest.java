package com.scsa.JAVA20191031;

import java.util.Arrays;
import java.util.Random;

/*

<<행운의 로또번호 생성기>>
1. 서로 겹치지 않는 (중복되지 않는) 숫자 6개 생성
2. 각 숫자는 1~45 범위내의 숫자
3. 매번 실행시 다른 숫자 출력
   ---> 랜덤수 : Random클래스 - nextInt(int bound)사용 
4. 다섯회 출력
5. 각 번호는 오름차순 정렬
   ---> Arrays클래스의 sort()메소드 사용.
   
출력형태)

  ★★ 금주 행운의 로또번호 ★★
 1회: 2, 12, 15, 34, 36, 42
 2회: 1, 2, 9, 33, 42, 45
 3회: 9, 12, 14, 19, 34, 40
 4회: 5, 10, 15, 18, 19, 22
 5회: 7, 9, 15, 19, 39, 41

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
		   
		   System.out.println("★★ 금주 행운의 로또번호 ★★");
		   
		   for(int i=1; i<=5; i++)
		   {
			   System.out.print(i + "회: ");
			   LottoTest lotto = new LottoTest();
			   lotto.generateNum();
			   lotto.printNum();
			   System.out.println();
		   }
	   }
}