package com.scsa.JAVA20191104;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventTest extends Frame implements ActionListener{
	
	Button bt;
	// Button Ŭ������ �޼ҵ� �� add ~ Listener() �޼ҵ� ã��
	// ===> addActionListener()
	// ActionListener �������̽� ���, ����(�������̵�)
	
	public EventTest() {
		bt = new Button("�� ��ư");
		
		setLayout(new FlowLayout());
		add(bt);
		
		setSize(300, 300);
		setVisible(true);
		bt.addActionListener(this);
	}
	
	public static void main(String[] args) {
		new EventTest();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// �̺�Ʈ ó����, Event Handler Method
		// ��ư�� ������ �� ó���� ��� ����
		System.out.println("HELLO BUTTON!");
		System.exit(0);
	}
}
