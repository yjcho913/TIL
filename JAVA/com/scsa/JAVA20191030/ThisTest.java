package com.scsa.JAVA20191030;

class My{
	String name;

	My(){//�⺻ ������
		this("CHO");
	}
	
/*
	// ���콺 ��Ŭ�� -> Source -> Generate Constructors using Fields
	public My(String name) {
		// �θ� ������ ȣ��, default�� ������
		// �θ� ����� ���� �޸� �Ҵ��� ���� ȣ��
		super();
		this.name = name;
	}
*/
	
	My(String name){//�����ε� ������
		
//		name = name;		// null ���
							// �������� name = �������� name
		
		// ��� ������ ���� ������ ����
		this.name = name;
	}
}

public class ThisTest {
	public static void main(String[] args) {
		My m = new My();
		System.out.println("name : " + m.name);
	}
}