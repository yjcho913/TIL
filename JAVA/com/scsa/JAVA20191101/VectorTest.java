package com.scsa.JAVA20191101;

import java.util.Enumeration;
import java.util.Vector;

class A{
	void hello() {
		System.out.println("HELLO!!!");
	}
}

public class VectorTest {	
	public static void main(String[] args) {
		// �������� �迭, ����(�ּ�)�� ��� �迭
//		Vector v = new Vector();	// �⺻ ��ũ�� : 10
		Vector v = new Vector(5); 	// ��ũ�� 5�� ����	
		System.out.println("������ �� ũ�� >>> "+ v.capacity());	// 10 ���
		System.out.println("============================");
		
		// ������ ���
		//v.add(Object e);						: ������ ������ ����ֱ�
		//v.add(int index, Object element);		: ������ �����ֱ�
		v.add(100);				// new Integer(100)
		v.add(true);			// new Boolean(true)
		v.add("HELLO VECTOR");	// new String("HELLO VECTOR")
		v.add(new A());
		A a = new A();
		v.add(a);
		v.add(3.14);
		
		
		// ������ ���
		Enumeration enu = v.elements();
		// enu = [100, true, "HELLO VECTOR", ...];
		System.out.println("������ Ȯ�� �� ������ �� ũ�� >>> "+ v.capacity());	// 10 ���
		while(enu.hasMoreElements()) {
			System.out.println(enu.nextElement());
		}
		System.out.println("============================");
		
		
		// �ε����� ���� ��ü ������ ���
		for (int i = 0; i < v.size(); i++) {
			System.out.println("�ε���[" + i + "] >>> " + v.get(i));
		}
		
		
		// ���� ) 4��°(�ε��� 3)�� �Է��� A Ŭ������ hello() �޼ҵ� ȣ��
		// get�� ����Ÿ�� : Object
		Object ob = v.get(3);
		((A)ob).hello();
		// A a2 = (A)ob;
		// a2.hello();
		
		
		// JDK5���� ���׸� ��� ---> ��Ἲ UP
		// Vector<A> v2 = new Vector<A>();
		// JDK7���� ���� <>�� �ڷ����� ��� ���� ����
		// ������ �ش� �ڷ����� ������ ����!
		Vector<A> v2 = new Vector<>();
		v2.add(a);
//		v2.add("HELLO");	//����, A �ڷ����� ����
		
		// get�� ����Ÿ�� : A
		v2.get(0).hello();
		
		
		// ����
		Vector<String> v3 = new Vector<>();
		v3.add("CHO");
		v3.add("KIM");
		v3.add("LEE");
		
		for(String str : v3) {
			System.out.println(str);
		}
		
		System.out.println("KIM�� ���ԵǾ��ֽ��ϱ�? >>> " + v3.contains("KIM"));
		System.out.println("PARK�� ���ԵǾ��ֽ��ϱ�? >>> " + v3.contains("PARK"));
		
		// KIM ���� (�ε��� ���)
		v3.remove(1);
		System.out.println("=== KIM ���� �� ��� ===");
		for(String str : v3) {
			System.out.println(str);
		}
		// LEE ���� (��� ���)
		v3.remove("LEE");
		System.out.println("=== LEE ���� �� ��� ===");
		for(String str : v3) {
			System.out.println(str);
		}
		
		
	}
}
