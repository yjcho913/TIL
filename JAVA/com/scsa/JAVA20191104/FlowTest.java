package com.scsa.JAVA20191104;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;

public class FlowTest {
	// GUI - ������Ʈ, �����̳��� ���� Ŭ����
	// ������Ʈ, �����̳��� ����
	Button bt1, bt2, bt3;
	Frame f;
	
	public FlowTest() {
		// ��ü ����
		bt1 = new Button("�ູ��ư1");
		bt2 = new Button("�ູ��ư2");
		bt3 = new Button("�ູ��ư3");
		f = new Frame();
		
		// �Ӽ� ����
		// ���̾ƿ� ��� ����
		f.setLayout(new FlowLayout());
		
		// �����̳ʿ� ������Ʈ ���̱�
		// �����̳ʸ�.add(������Ʈ);
		f.add(bt1);
		f.add(bt2);
		f.add(bt3);
		
		// ������ (�����̳��� ������, ���̱� ����)
		// f.setSize(int width, int height);
		f.setSize(300, 300);
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		// FlowTest ft = new FlowTest();
		// ���� ������ ȣ�⸸ �ʿ��ϴٸ�,
		new FlowTest();
	}
}
