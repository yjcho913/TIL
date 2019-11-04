package com.scsa.JAVA20191104;

import java.util.Enumeration;
import java.util.Vector;

// ���� ���

public class NameMenu2 {
	Vector<String> names;

	public NameMenu2() {
		names = new Vector<>();
	}
	
	public void insert(String name) {
		names.add(name);
	}
	
	public void delete(String delName) {
		// �ߺ��� �����Ͱ� ���ٸ� ��ҷ� ���� ����!
		names.remove(delName);
	}
	
	public void select() {
		System.out.println("#�̸����");
		
		// ���1. index ���
		for (int i = 0; i < names.size(); i++) {
			System.out.println("["+i+"]"+names.get(i));
		}
		
		// ���2. Enumeration ��ü ���
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
