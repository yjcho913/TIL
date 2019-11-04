package com.scsa.JAVA20191104;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class LottoSetTest {
	// 중복되지 않는 6개의 숫자 (1 ~ 45) ==> 정렬
	
	public static void main(String[] args) {
		// 제네릭에는 기본 타입형이 아닌, 클래스형을 언급!
		// 기본 타입형 ----> Wrapper Class
		Set<Integer> set = new TreeSet<Integer>();
		Random r = new Random();
		
		while(set.size() != 6) {
			set.add(r.nextInt(45) + 1);
		}
		
		Iterator<Integer> iter = set.iterator();
		while(iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
		System.out.println();
	}
}
