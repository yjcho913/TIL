package com.scsa.JAVA20191030;

class Abc{
	/*
	 * ������� (field)�� �ʱⰪ(�⺻��)�� ����
	 * ���������� �ʱⰪ X	--> �ʱ�ȭ �� ����ؾ� ��
	 <�⺻��>
	 ���� : 0
	 �Ǽ� : 0.0
	 �� : false
	 ���� : '\u0000' 
	 class Ÿ�� : null
	 */
	int num;
	boolean bool;
	String str;
	
	// ������ : �ʱ�ȭ(�� �Ҵ�) �޼ҵ�
	// �⺻ ������ : ���ڰ� ���� ������
	Abc(){
		// ���� ����ʵ忡 ���� �ʱ�ȭ
		num = 10;
		bool = true;
		str = "CHO";
		System.out.println("�⺻ ������");
	}
	
	// �����ε� ������
	Abc(String name){
		str = name;
		System.out.println("�����ε� ������");
	}
	
	void print() {
		// int sum;	// �ʱ�ȭ���� �ʾ� compile error
		int sum = 100;
		
		System.out.println("PRINT sum : " + sum);
		System.out.println("PRINT int : " + num);
		System.out.println("PRINT boolean : " + bool);
		System.out.println("PRINT string : " + str);
	}
}

public class ConstructorTest {
	public static void main(String[] args) {
		// new --> �޸� �Ҵ� + ������ ȣ��
		// �޸� �Ҵ� �� �� �ѹ� ȣ��!
		Abc abc = new Abc();	
		abc.print();
		System.out.println("=============");

		Abc abc2 = new Abc("CHOOOOOO");
		abc2.print();
		System.out.println("=============");
	}
}