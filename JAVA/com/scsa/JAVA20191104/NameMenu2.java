package com.scsa.JAVA20191104;

import java.util.Enumeration;
import java.util.Vector;

// 벡터 사용

public class NameMenu2 {
	Vector<String> names;

	public NameMenu2() {
		names = new Vector<>();
	}
	
	public void insert(String name) {
		names.add(name);
	}
	
	public void delete(String delName) {
		// 중복된 데이터가 없다면 요소로 제거 가능!
		names.remove(delName);
	}
	
	public void select() {
		System.out.println("#이름목록");
		
		// 방법1. index 사용
		for (int i = 0; i < names.size(); i++) {
			System.out.println("["+i+"]"+names.get(i));
		}
		
		// 방법2. Enumeration 객체 사용
		// enu = ["HONG", "GIL", "KIM"];
		Enumeration<String> enu = names.elements();
		while(enu.hasMoreElements()) {
			System.out.println(enu.nextElement());
		}
	}
	
	public void update(String oldName, String newName) {
		for (int i = 0; i < names.size(); i++) {
			if(oldName.equals(names.get(i))) {
				names.set(i, newName);
				break;
			}
		}
	}
}
