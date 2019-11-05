package com.scsa.JAVA20191105;

public class TVContribution {
	public static void main(String[] args) {
		
		//����� ��ü ����
		Account account = new Account();
		
		//����� ����
		Customer [] customers = new Customer[5];
		for (int i = 0; i < customers.length; i++) {
			customers[i] = new Customer(account);
		}
		
		//��� ����
		for (int i = 0; i < customers.length; i++) {
			customers[i].start();
		}
		
		// �ش� �����尡 �����Ҷ����� ��ٸ���
		try {
			for (int i = 0; i < customers.length; i++) {
				customers[i].join();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		}
		
		//main : ���󽺷���(�������� ����)
		System.out.println("�� ��ݾ� >>> " + account.getTotal());
		//500000���� ������ ����! ----> ���� ���� ����!
		//����ȭ�� �ʿ���	---> �޼ҵ� ����ȭ
	}
}
