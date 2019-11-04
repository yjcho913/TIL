package com.scsa.JAVA20191104;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SetTest {
	/*
		<Set> 인터페이스
		- 중복 제거, 순서 보장 X (입력된 순서로 검색되지 않음)
		- HashSet
		- TreeSet : (+ 정렬 기능)
	 */
	public static void main(String[] args) {
		// *** HashSet *** //
		Set<String> set = new HashSet<String>();
		
		// 데이터 추가
		set.add("HONG");
		set.add("KIM");
		set.add("LEE");
		set.add("CHO");
		set.add("HONG");
		
		// 데이터 출력
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
			// HONG - CHO - LEE - KIM
			// 입력 순서 보장 X
		}
		System.out.println("========================================");
		
		// *** TreeSet *** //
		Set<String> set2 = new TreeSet<String>();
		
		// 데이터 추가
		set2.add("HONG");
		set2.add("KIM");
		set2.add("LEE");
		set2.add("CHO");
		set2.add("HONG");
		
		// 데이터 출력
		Iterator<String> iter2 = set2.iterator();
		while(iter2.hasNext()) {
			System.out.println(iter2.next());
			// CHO - HONG - KIM - LEE
			// 사전순으로 정렬
		}
	}
}
