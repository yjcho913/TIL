package com.scsa.JAVA20191030;

public class Restaurant implements MenuPan{
	// �������̵� �ÿ�, �������̽��� ���������ڴ� public!
	@Override
	public void ¥���() {
		System.out.println("PRINT ¥���");
	}

	@Override
	public void «��() {
		System.out.println("PRINT «��");
	}

	@Override
	public void ������() {
		// �� �޼ҵ� ����
	}
	
	// �ش� �������̽� ���� ���� �޼ҵ� �߰� ����
	public void �ʹ�() {
		System.out.println("PRINT �ʹ�");
	}
}
