package com.scsa.JAVA20191104;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;

public class GridTest extends Frame{ // this == Frame
	// GUI - ������Ʈ, �����̳��� ���� Ŭ����
	// ������Ʈ�� ���� (�����̳ʴ� ������ �ʿ� ����)
	Button bt1, bt2, bt3, bt4, bt5;
	
	public GridTest() {
		// ���� Ŭ����(Frame) ������ ȣ��
		super("GRID TEST");
		
		// ��ü ����
		bt1 = new Button("1");
		bt2 = new Button("2");
		bt3 = new Button("3");
		bt4 = new Button("4");
		bt5 = new Button("5");
		
		// �Ӽ� ����
		// ���̾ƿ� ��� ����
		// this.setLayout(new GridLayout(rows, cols));
		this.setLayout(new GridLayout(2, 3));
		
		// �����̳ʿ� ������Ʈ ���̱�
		// this ���� ����
		this.add("North", bt1);
		this.add("East", bt2);
		this.add("South", bt3);
		this.add("West", bt4);
		this.add("Center", bt5);
		
		// ������ (�����̳��� ������, ���̱� ����)
		// f.setSize(int width, int height);
		this.setSize(500, 300);
		this.setVisible(true);
		this.setTitle("Grid Test");
	}
	
	public static void main(String[] args) {
		// FlowTest ft = new FlowTest();
		// ���� ������ ȣ�⸸ �ʿ��ϴٸ�,
		new GridTest();
	}
}
