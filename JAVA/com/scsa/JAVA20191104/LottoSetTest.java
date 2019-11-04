package com.scsa.JAVA20191104;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class LottoSetTest {
	// �ߺ����� �ʴ� 6���� ���� (1 ~ 45) ==> ����
	
	public static void main(String[] args) {
		// ���׸����� �⺻ Ÿ������ �ƴ�, Ŭ�������� ���!
		// �⺻ Ÿ���� ----> Wrapper Class
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
