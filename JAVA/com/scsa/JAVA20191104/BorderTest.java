package com.scsa.JAVA20191104;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;

public class BorderTest {
	// GUI - ������Ʈ, �����̳��� ���� Ŭ����
	// ������Ʈ, �����̳��� ����
	Button bt1, bt2, bt3, bt4, bt5;
	Frame f;
	
	public BorderTest() {
		// ��ü ����
		bt1 = new Button("1");
		bt2 = new Button("2");
		bt3 = new Button("3");
		bt4 = new Button("4");
		bt5 = new Button("5");
		f = new Frame("BORDER TEST");	// TITLE
		
		// �Ӽ� ����
		// ���̾ƿ� ��� ����
		f.setLayout(new BorderLayout());
		
		// �����̳ʿ� ������Ʈ ���̱�
		// �����̳ʸ�.add(��ġ, ������Ʈ);
		// ���� bt1�� center�� �ٽ� ���δٸ�, north�� ��ư�� ȸ���ϰ� center�� ����
		// 5���� �� �� �ʿ� ����
		f.add("North", bt1);
		f.add("East", bt2);
		f.add("South", bt3);
		f.add("West", bt4);
		f.add("Center", bt5);
		
		// ������ (�����̳��� ������, ���̱� ����)
		// f.setSize(int width, int height);
		f.setSize(300, 300);
		f.setVisible(true);
		f.setTitle("Border Test");
	}
	
	public static void main(String[] args) {
		// FlowTest ft = new FlowTest();
		// ���� ������ ȣ�⸸ �ʿ��ϴٸ�,
		new BorderTest();
	}
}
