package com.scsa.JAVA20191031;

class AA{
	public void hello() {
		System.out.println("HELLO");
	}
	public void method(CC c) {
		c.print();
	}
}

class CC{
	public void print() {
		System.out.println("PRINT CC");
	}
}

public class AnonymousTest {
	public static void main(String[] args) {
		// {} : Ŭ���� ���� ��ȣ
		// �޼ҵ� �������̵��� ���� ����
		AA a = new AA() {
			public void hello() {
				System.out.println("HELLOOOOOO");
			}
		};
		
		a.hello();	// HELOOOOOOO ���
		System.out.println("===============");
		
		
		CC c = new CC();
		a.method(c);
		// �޼ҵ� �������̵�
		a.method(new CC() {
			public void print() {
				System.out.println("PRINT SCSA");
			}
		});
		System.out.println("===============");
		/*
		 ���� new CC(){}
		 --> CC : Ŭ����(�߻� Ŭ����)
		 	 class My extends CC{
		 	 	// �������̵� �޼ҵ� ����
		 	 }
 		 --> CC : �������̽�
		 	 class My implements CC{
		 	 	// �������̵� �޼ҵ� ����
		 	 }
		 * ������ 'My'�� �ʿ���� ������ 'anonymous' �� �ٴ´�!
		 */
	}
}
