package com.scsa.JAVA20191030;

public class Child extends Parent{
	
	int i = 33;
	int j = 22;
	
	// �θ��� �޼ҵ带 �ùٸ��� �������̵��ߴ��� Ȯ���� ��
	@Override
	void print() {
		// �θ��� �޼ҵ带 ���� �ް�, �ڿ� �����̰���1
		// super.print();
		
		// �θ��� �޼ҵ带 ������ ������!
		System.out.println("Print Child");
	}
	
	void goodBye() {
		System.out.println("GOOD BYE");
	}
}
