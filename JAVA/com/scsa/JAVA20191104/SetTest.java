package com.scsa.JAVA20191104;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SetTest {
	/*
		<Set> �������̽�
		- �ߺ� ����, ���� ���� X (�Էµ� ������ �˻����� ����)
		- HashSet
		- TreeSet : (+ ���� ���)
	 */
	public static void main(String[] args) {
		// *** HashSet *** //
		Set<String> set = new HashSet<String>();
		
		// ������ �߰�
		set.add("HONG");
		set.add("KIM");
		set.add("LEE");
		set.add("CHO");
		set.add("HONG");
		
		// ������ ���
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
			// HONG - CHO - LEE - KIM
			// �Է� ���� ���� X
		}
		System.out.println("========================================");
		
		// *** TreeSet *** //
		Set<String> set2 = new TreeSet<String>();
		
		// ������ �߰�
		set2.add("HONG");
		set2.add("KIM");
		set2.add("LEE");
		set2.add("CHO");
		set2.add("HONG");
		
		// ������ ���
		Iterator<String> iter2 = set2.iterator();
		while(iter2.hasNext()) {
			System.out.println(iter2.next());
			// CHO - HONG - KIM - LEE
			// ���������� ����
		}
	}
}
