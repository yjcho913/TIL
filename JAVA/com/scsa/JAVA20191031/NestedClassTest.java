package com.scsa.JAVA20191031;

class NestingClass{ // �ܺ� Ŭ����, outer Ŭ����, top-level Ŭ����
	int i = 11;
	
	void varPrintNesting() {
		System.out.println("i = " + i);
//		System.out.println("j = " + j);	// ����
		// j�� �������� ���� ��ü ������ �ؾ� ��
		
		NestedClass nested = new NestedClass();
		System.out.println("j = " + nested.j);
		nested.varPrintNested();
		// ������ �ܺο� �����ϰ�, ȣ��
	}
	
	class NestedClass{ // ���� Ŭ����, inner Ŭ����
		int j = 22;
		void varPrintNested() {
			System.out.println("j : " + j);
			System.out.println("i : " + i);
		}
	}
}
public class NestedClassTest { 
	public static void main(String[] args) {
		
		// �ܺ� Ŭ����
		NestingClass nesting = new NestingClass();
		nesting.varPrintNesting();
		System.out.println("===============");
		
		// ���� Ŭ������ ȣ�� ���� (�̷� ��� ����..)
		// �ܺ�Ŭ������.����Ŭ������ ����������;
		NestingClass.NestedClass nested = new NestingClass().new NestedClass();
		nested.varPrintNested();
	}
}
