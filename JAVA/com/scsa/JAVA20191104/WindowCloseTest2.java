package com.scsa.JAVA20191104;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

// ���� ����� x ��ư Ŭ�� ---> ���α׷� ����
//WindowListener(�������̽�)	---> WindowAdaptor(Ŭ����)
// WindowAdaptor : WindowListener�� implement�ؼ� ������� �߻� Ŭ����
// WindowListener�� �޼ҵ���� ���ǵǾ� ����!
public class WindowCloseTest2 extends WindowAdapter{
	
	Frame f;
	
	public WindowCloseTest2() {
		f = new Frame();
		f.setSize(300,300);
		f.setVisible(true);
		
		// �̺�Ʈ�ҽ�.add~Listener(�̺�Ʈ�ڵ鷯�� ��ġ)
		f.addWindowListener(this);
	}
	
	public static void main(String[] args) {
		new WindowCloseTest2();
	}
	
	// ��� �Լ��� overriding�� �ʿ� ����
	public void windowClosing(WindowEvent e) {
		System.out.println("���α׷� ����");
		System.exit(0);
	}
}
