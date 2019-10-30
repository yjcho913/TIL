package com.scsa.JAVA20191030;

public class InheritanceTest {
	public static void main(String[] args) {
		
		Parent p = new Parent();
		p.hello();
		p.hello("YJ");
		p.print();
		System.out.println("=============");
		
		Child c = new Child();
		c.hello();
		// Parent���� toString �޼ҵ尡 ������, �����Ϸ��� �ڵ����� Object Ŭ������ ��� ����
		System.out.println(c.toString());
		// �������̵��� �޼ҵ�
		c.print();
		System.out.println("=============");

		Parent p2 = new Child();
		p2.hello("YJ");
		// p2.goodBye();	// �������̵� �޼ҵ尡 �ƴϱ� ������ ����
		p2.print();			// �ڽ��� �������̵� �޼ҵ�
		System.out.println("i = " + p2.i);	// �ʵ�� �������̵��� ����! ���� �θ��� i ���
		System.out.println("=============");

		/*
		 �⺻ : �θ� ���۷��� ���� �ڽ� ȣ�� �Ұ�
		 ���� : �ڽ��� �������̵� �޼ҵ�
		 */
		
		Child c2;
		// c2 = (Child) p;	// p�� Child�� �ٸ� �޸𸮸� �Ҵ���� --> runtime error
		c2 = (Child) p2;	// p2�� Child�� ���� �޸𸮸� �Ҵ�޾ұ� ������ ����
		c2.goodBye();		// �������̵� �޼ҵ尡 �ƴϾ Child�� Ż�ٲ��߱� ������ ����
		System.out.println("i = " + c2.i);
		System.out.println("=============");

	}
}
